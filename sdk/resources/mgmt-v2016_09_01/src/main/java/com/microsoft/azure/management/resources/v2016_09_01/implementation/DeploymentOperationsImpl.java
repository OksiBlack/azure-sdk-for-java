/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.resources.v2016_09_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.resources.v2016_09_01.DeploymentOperations;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.management.resources.v2016_09_01.DeploymentOperation;
import com.microsoft.azure.Page;

class DeploymentOperationsImpl extends WrapperImpl<DeploymentOperationsInner> implements DeploymentOperations {
    private final ResourcesManager manager;

    DeploymentOperationsImpl(ResourcesManager manager) {
        super(manager.inner().deploymentOperations());
        this.manager = manager;
    }

    public ResourcesManager manager() {
        return this.manager;
    }

    private DeploymentOperationImpl wrapDeploymentOperationModel(DeploymentOperationInner inner) {
        return  new DeploymentOperationImpl(inner, manager());
    }

    private Observable<DeploymentOperationInner> getDeploymentOperationInnerUsingDeploymentOperationsInnerAsync(String id) {
        String resourceGroupName = IdParsingUtils.getValueFromIdByName(id, "resourcegroups");
        String deploymentName = IdParsingUtils.getValueFromIdByName(id, "deployments");
        String operationId = IdParsingUtils.getValueFromIdByName(id, "operations");
        DeploymentOperationsInner client = this.inner();
        return client.getAsync(resourceGroupName, deploymentName, operationId);
    }

    @Override
    public Observable<DeploymentOperation> getAsync(String resourceGroupName, String deploymentName, String operationId) {
        DeploymentOperationsInner client = this.inner();
        return client.getAsync(resourceGroupName, deploymentName, operationId)
        .map(new Func1<DeploymentOperationInner, DeploymentOperation>() {
            @Override
            public DeploymentOperation call(DeploymentOperationInner inner) {
                return wrapDeploymentOperationModel(inner);
            }
       });
    }

    @Override
    public Observable<DeploymentOperation> listByResourceGroupAsync(final String resourceGroupName, final String deploymentName) {
        DeploymentOperationsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName, deploymentName)
        .flatMapIterable(new Func1<Page<DeploymentOperationInner>, Iterable<DeploymentOperationInner>>() {
            @Override
            public Iterable<DeploymentOperationInner> call(Page<DeploymentOperationInner> page) {
                return page.items();
            }
        })
        .map(new Func1<DeploymentOperationInner, DeploymentOperation>() {
            @Override
            public DeploymentOperation call(DeploymentOperationInner inner) {
                return wrapDeploymentOperationModel(inner);
            }
        });
    }

}
