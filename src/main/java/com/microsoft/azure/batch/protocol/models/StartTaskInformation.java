/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information about a start task running on a compute node.
 */
public class StartTaskInformation {
    /**
     * The state of the start task on the compute node.
     * running - The start task is currently running. completed - The start
     * task has exited with exit code 0, or the start task has failed and the
     * retry limit has reached, or the start task process did not run due to
     * scheduling errors. Possible values include: 'running', 'completed'.
     */
    @JsonProperty(value = "state", required = true)
    private StartTaskState state;

    /**
     * The time at which the start task started running.
     * This value is reset every time the task is restarted or retried (that
     * is, this is the most recent time at which the start task started
     * running).
     */
    @JsonProperty(value = "startTime", required = true)
    private DateTime startTime;

    /**
     * The time at which the start task stopped running.
     * This is the end time of the most recent run of the start task, if that
     * run has completed (even if that run failed and a retry is pending). This
     * element is not present if the start task is currently running.
     */
    @JsonProperty(value = "endTime")
    private DateTime endTime;

    /**
     * The exit code of the program specified on the start task command line.
     * This property is set only if the start task is in the completed state.
     * In general, the exit code for a process reflects the specific convention
     * implemented by the application developer for that process. If you use
     * the exit code value to make decisions in your code, be sure that you
     * know the exit code convention used by the application process. However,
     * if the Batch service terminates the start task (due to timeout, or user
     * termination via the API) you may see an operating system-defined exit
     * code.
     */
    @JsonProperty(value = "exitCode")
    private Integer exitCode;

    /**
     * Information describing the task failure, if any.
     * This property is set only if the task is in the completed state and
     * encountered a failure.
     */
    @JsonProperty(value = "failureInfo")
    private TaskFailureInformation failureInfo;

    /**
     * The number of times the task has been retried by the Batch service.
     * The number of times the task has been retried by the Batch service. Task
     * application failures (non-zero exit code) are retried, pre-processing
     * errors (the task could not be run) and file upload errors are not
     * retried. The Batch service will retry the task up to the limit specified
     * by the constraints.
     */
    @JsonProperty(value = "retryCount", required = true)
    private int retryCount;

    /**
     * The most recent time at which a retry of the task started running.
     * This element is present only if the task was retried (i.e. retryCount is
     * nonzero). If present, this is typically the same as startTime, but may
     * be different if the task has been restarted for reasons other than
     * retry; for example, if the compute node was rebooted during a retry,
     * then the startTime is updated but the lastRetryTime is not.
     */
    @JsonProperty(value = "lastRetryTime")
    private DateTime lastRetryTime;

    /**
     * The result of the task execution.
     * If the value is 'failed', then the details of the failure can be found
     * in the failureInfo property. Possible values include: 'success',
     * 'failure'.
     */
    @JsonProperty(value = "result")
    private TaskExecutionResult result;

    /**
     * Get the state value.
     *
     * @return the state value
     */
    public StartTaskState state() {
        return this.state;
    }

    /**
     * Set the state value.
     *
     * @param state the state value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withState(StartTaskState state) {
        this.state = state;
        return this;
    }

    /**
     * Get the startTime value.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the startTime value.
     *
     * @param startTime the startTime value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withStartTime(DateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the endTime value.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Set the endTime value.
     *
     * @param endTime the endTime value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withEndTime(DateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the exitCode value.
     *
     * @return the exitCode value
     */
    public Integer exitCode() {
        return this.exitCode;
    }

    /**
     * Set the exitCode value.
     *
     * @param exitCode the exitCode value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withExitCode(Integer exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    /**
     * Get the failureInfo value.
     *
     * @return the failureInfo value
     */
    public TaskFailureInformation failureInfo() {
        return this.failureInfo;
    }

    /**
     * Set the failureInfo value.
     *
     * @param failureInfo the failureInfo value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withFailureInfo(TaskFailureInformation failureInfo) {
        this.failureInfo = failureInfo;
        return this;
    }

    /**
     * Get the retryCount value.
     *
     * @return the retryCount value
     */
    public int retryCount() {
        return this.retryCount;
    }

    /**
     * Set the retryCount value.
     *
     * @param retryCount the retryCount value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withRetryCount(int retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    /**
     * Get the lastRetryTime value.
     *
     * @return the lastRetryTime value
     */
    public DateTime lastRetryTime() {
        return this.lastRetryTime;
    }

    /**
     * Set the lastRetryTime value.
     *
     * @param lastRetryTime the lastRetryTime value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withLastRetryTime(DateTime lastRetryTime) {
        this.lastRetryTime = lastRetryTime;
        return this;
    }

    /**
     * Get the result value.
     *
     * @return the result value
     */
    public TaskExecutionResult result() {
        return this.result;
    }

    /**
     * Set the result value.
     *
     * @param result the result value to set
     * @return the StartTaskInformation object itself.
     */
    public StartTaskInformation withResult(TaskExecutionResult result) {
        this.result = result;
        return this;
    }

}