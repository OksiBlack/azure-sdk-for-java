﻿using CommandLine;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Reflection;
using System.Reflection.Emit;
using System.Runtime;
using System.Text.Json;
using System.Threading;
using System.Threading.Tasks;

namespace Azure.Test.PerfStress
{
    public static class PerfStressProgram
    {
        private static int _completedOperations;
        private static TimeSpan[] _lastCompletionTimes;

        public static void Main(Assembly assembly, string[] args)
        {
            var testTypes = assembly.ExportedTypes.Where(t => typeof(IPerfStressTest).IsAssignableFrom(t) && !t.IsAbstract);

            var optionTypes = GetOptionTypes(testTypes);

            var result = Parser.Default.ParseArguments(args, optionTypes).WithParsed<PerfStressOptions>(o =>
            {
                var verbName = o.GetType().GetCustomAttribute<VerbAttribute>().Name;
                var testType = testTypes.Where(t => GetVerbName(t.Name) == verbName).Single();
                Run(testType, o);
            });
        }

        private static void Run(Type testType, PerfStressOptions options)
        {
            if (!GCSettings.IsServerGC)
            {
                throw new InvalidOperationException("Requires server GC");
            }

            Console.WriteLine("=== Options ===");
            Console.WriteLine(JsonSerializer.Serialize(options, options.GetType(), new JsonSerializerOptions()
            {
                WriteIndented = true
            }));
            Console.WriteLine();

            _lastCompletionTimes = new TimeSpan[options.Parallel];

            var duration = TimeSpan.FromSeconds(options.Duration);

            using (var test = (IPerfStressTest)Activator.CreateInstance(testType, options))
            using (var cts = new CancellationTokenSource(duration))
            {
                var cancellationToken = cts.Token;

                _ = PrintStatusAsync(cancellationToken);

                if (options.Async)
                {
                    var tasks = new Task[options.Parallel];

                    for (var i = 0; i < options.Parallel; i++)
                    {
                        tasks[i] = RunLoopAsync(test, cancellationToken);
                    }
                    Task.WhenAll(tasks).Wait();
                }
                else
                {
                    var threads = new Thread[options.Parallel];

                    for (var i = 0; i < options.Parallel; i++)
                    {
                        threads[i] = new Thread(() => RunLoop(test, cancellationToken));
                        threads[i].Start();
                    }
                    for (var i = 0; i < options.Parallel; i++)
                    {
                        threads[i].Join();
                    }
                }

                var averageElapsedSeconds = _lastCompletionTimes.Select(t => t.TotalSeconds).Average();
                var operationsPerSecond = _completedOperations / averageElapsedSeconds;
                var secondsPerOperation = 1 / operationsPerSecond;

                Console.WriteLine("=== Results ===");
                Console.WriteLine($"Completed {_completedOperations} operations in an average of {averageElapsedSeconds:N2}s " +
                    $"({operationsPerSecond:N1} ops/s, {secondsPerOperation:N3} s/op)");
                Console.WriteLine();
            }
        }

        private static void RunLoop(IPerfStressTest test, CancellationToken cancellationToken)
        {
            var sw = Stopwatch.StartNew();
            while (!cancellationToken.IsCancellationRequested)
            {
                try
                {
                    test.Run(cancellationToken);
                    var count = Interlocked.Increment(ref _completedOperations);
                    _lastCompletionTimes[count % _lastCompletionTimes.Length] = sw.Elapsed;
                }
                catch (OperationCanceledException)
                {
                }
            }
        }

        private static async Task RunLoopAsync(IPerfStressTest test, CancellationToken cancellationToken)
        {
            var sw = Stopwatch.StartNew();
            while (!cancellationToken.IsCancellationRequested)
            {
                try
                {
                    await test.RunAsync(cancellationToken);
                    var count = Interlocked.Increment(ref _completedOperations);
                    _lastCompletionTimes[count % _lastCompletionTimes.Length] = sw.Elapsed;
                }
                catch (OperationCanceledException)
                {
                }
            }
        }

        static async Task PrintStatusAsync(CancellationToken token)
        {
            Console.WriteLine("=== Progress ===");

            while (!token.IsCancellationRequested)
            {
                try
                {
                    await Task.Delay(TimeSpan.FromSeconds(1), token);
                    Console.WriteLine(_completedOperations);
                }
                catch (OperationCanceledException)
                {
                }
            }

            Console.WriteLine();
        }

        // Dynamically create option types with a "Verb" attribute
        private static Type[] GetOptionTypes(IEnumerable<Type> testTypes)
        {
            var optionTypes = new List<Type>();

            var ab = AssemblyBuilder.DefineDynamicAssembly(new AssemblyName("Options"), AssemblyBuilderAccess.Run);
            var mb = ab.DefineDynamicModule("Options");

            foreach (var t in testTypes)
            {
                var baseOptionsType = t.GetConstructors().First().GetParameters().First().ParameterType;
                var tb = mb.DefineType(t.Name + "Options", TypeAttributes.Public, baseOptionsType);

                var attrCtor = typeof(VerbAttribute).GetConstructor(new Type[] { typeof(string) });
                var verbName = GetVerbName(t.Name);
                tb.SetCustomAttribute(new CustomAttributeBuilder(attrCtor, new object[] { verbName }));

                optionTypes.Add(tb.CreateType());
            }

            return optionTypes.ToArray();
        }

        private static string GetVerbName(string testName)
        {
            var lower = testName.ToLowerInvariant();
            return lower.EndsWith("test") ? lower.Substring(0, lower.Length - 4) : lower;
        }
    }
}
