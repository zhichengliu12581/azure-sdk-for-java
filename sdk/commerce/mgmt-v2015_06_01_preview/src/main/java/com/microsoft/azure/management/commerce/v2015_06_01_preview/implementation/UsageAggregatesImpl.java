/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.commerce.v2015_06_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.commerce.v2015_06_01_preview.UsageAggregates;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.commerce.v2015_06_01_preview.UsageAggregation;
import org.joda.time.DateTime;

class UsageAggregatesImpl extends WrapperImpl<UsageAggregatesInner> implements UsageAggregates {
    private final CommerceManager manager;

    UsageAggregatesImpl(CommerceManager manager) {
        super(manager.inner().usageAggregates());
        this.manager = manager;
    }

    public CommerceManager manager() {
        return this.manager;
    }

    @Override
    public Observable<UsageAggregation> listAsync(final DateTime reportedStartTime, final DateTime reportedEndTime) {
        UsageAggregatesInner client = this.inner();
        return client.listAsync(reportedStartTime, reportedEndTime)
        .flatMapIterable(new Func1<Page<UsageAggregationInner>, Iterable<UsageAggregationInner>>() {
            @Override
            public Iterable<UsageAggregationInner> call(Page<UsageAggregationInner> page) {
                return page.items();
            }
        })
        .map(new Func1<UsageAggregationInner, UsageAggregation>() {
            @Override
            public UsageAggregation call(UsageAggregationInner inner) {
                return new UsageAggregationImpl(inner, manager());
            }
        });
    }

}