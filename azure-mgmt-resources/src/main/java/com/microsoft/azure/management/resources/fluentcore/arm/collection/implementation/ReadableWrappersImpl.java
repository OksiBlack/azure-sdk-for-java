/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.resources.fluentcore.arm.collection.implementation;

import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.resources.fluentcore.utils.PagedListConverter;
import com.microsoft.azure.management.resources.implementation.PageImpl;
import rx.Observable;
import rx.functions.Func1;

import java.util.List;

/**
 * Base class for readable wrapper collections, i.e. those whose models can only be read, not created.
 * (Internal use only)
 * @param <T> the individual resource type returned
 * @param <ImplT> the individual resource implementation
 * @param <InnerT> the wrapper inner type
 */
public abstract class ReadableWrappersImpl<
        T,
        ImplT extends T,
        InnerT> {

    private final PagedListConverter<InnerT, T> converter;

    protected ReadableWrappersImpl() {
        this.converter = new PagedListConverter<InnerT, T>() {
            @Override
            public T typeConvert(InnerT inner) {
                return wrapModel(inner);
            }
        };
    }

    protected abstract ImplT wrapModel(InnerT inner);

    protected PagedList<T> wrapList(PagedList<InnerT> pagedList) {
        return converter.convert(pagedList);
    }

    protected PagedList<T> wrapList(List<InnerT> list) {
        return converter.convert(ReadableWrappersImpl.convertToPagedList(list));
    }

    /**
     * Converts the List to PagedList.
     * @param list list to be converted in to paged list
     * @param <InnerT> the wrapper inner type
     * @return the Paged list for the inner type.
     */
    public static <InnerT> PagedList<InnerT> convertToPagedList(List<InnerT> list) {
        PageImpl<InnerT> page = new PageImpl<>();
        page.setItems(list);
        page.setNextPageLink(null);
        return new PagedList<InnerT>(page) {
            @Override
            public Page<InnerT> nextPage(String nextPageLink) {
                return null;
            }
        };
    }


    protected Observable<T> convertPageToIndividualResourcesAsync(Observable<Page<InnerT>> innerPage) {
        return convertListToIndividualResourcesAsync(convertPageToListAsync(innerPage));
    }

    private Observable<List<InnerT>> convertPageToListAsync(Observable<Page<InnerT>> innerPage) {
        return innerPage.map(new Func1<Page<InnerT>, List<InnerT>>() {
            @Override
            public List<InnerT> call(Page<InnerT> pageInner) {
                return pageInner.items();
            }
        });
    }

    private Observable<T> convertListToIndividualResourcesAsync(Observable<List<InnerT>> innerList) {
        return innerList.flatMap(new Func1<List<InnerT>, Observable<T>>() {
            @Override
            public Observable<T> call(List<InnerT> inners) {
                return Observable.from(inners).map(new Func1<InnerT, T>() {
                    @Override
                    public T call(InnerT inner) {
                        return wrapModel(inner);
                    }
                });
            }
        });
    }
}