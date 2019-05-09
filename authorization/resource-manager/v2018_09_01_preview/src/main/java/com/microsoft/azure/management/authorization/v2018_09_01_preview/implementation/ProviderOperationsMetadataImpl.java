/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.authorization.v2018_09_01_preview.implementation;

import com.microsoft.azure.management.authorization.v2018_09_01_preview.ProviderOperationsMetadata;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import java.util.List;
import com.microsoft.azure.management.authorization.v2018_09_01_preview.ProviderOperation;
import com.microsoft.azure.management.authorization.v2018_09_01_preview.ResourceType;

class ProviderOperationsMetadataImpl extends WrapperImpl<ProviderOperationsMetadataInner> implements ProviderOperationsMetadata {
    private final AuthorizationManager manager;
    ProviderOperationsMetadataImpl(ProviderOperationsMetadataInner inner, AuthorizationManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public AuthorizationManager manager() {
        return this.manager;
    }

    @Override
    public String displayName() {
        return this.inner().displayName();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public List<ProviderOperation> operations() {
        return this.inner().operations();
    }

    @Override
    public List<ResourceType> resourceTypes() {
        return this.inner().resourceTypes();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}