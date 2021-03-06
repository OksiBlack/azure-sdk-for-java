/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resources.v2018_02_01;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Resource type managed by the resource provider.
 */
public class ProviderResourceType {
    /**
     * The resource type.
     */
    @JsonProperty(value = "resourceType")
    private String resourceType;

    /**
     * The collection of locations where this resource type can be created.
     */
    @JsonProperty(value = "locations")
    private List<String> locations;

    /**
     * The aliases that are supported by this resource type.
     */
    @JsonProperty(value = "aliases")
    private List<AliasType> aliases;

    /**
     * The API version.
     */
    @JsonProperty(value = "apiVersions")
    private List<String> apiVersions;

    /**
     * The properties.
     */
    @JsonProperty(value = "properties")
    private Map<String, String> properties;

    /**
     * Get the resource type.
     *
     * @return the resourceType value
     */
    public String resourceType() {
        return this.resourceType;
    }

    /**
     * Set the resource type.
     *
     * @param resourceType the resourceType value to set
     * @return the ProviderResourceType object itself.
     */
    public ProviderResourceType withResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * Get the collection of locations where this resource type can be created.
     *
     * @return the locations value
     */
    public List<String> locations() {
        return this.locations;
    }

    /**
     * Set the collection of locations where this resource type can be created.
     *
     * @param locations the locations value to set
     * @return the ProviderResourceType object itself.
     */
    public ProviderResourceType withLocations(List<String> locations) {
        this.locations = locations;
        return this;
    }

    /**
     * Get the aliases that are supported by this resource type.
     *
     * @return the aliases value
     */
    public List<AliasType> aliases() {
        return this.aliases;
    }

    /**
     * Set the aliases that are supported by this resource type.
     *
     * @param aliases the aliases value to set
     * @return the ProviderResourceType object itself.
     */
    public ProviderResourceType withAliases(List<AliasType> aliases) {
        this.aliases = aliases;
        return this;
    }

    /**
     * Get the API version.
     *
     * @return the apiVersions value
     */
    public List<String> apiVersions() {
        return this.apiVersions;
    }

    /**
     * Set the API version.
     *
     * @param apiVersions the apiVersions value to set
     * @return the ProviderResourceType object itself.
     */
    public ProviderResourceType withApiVersions(List<String> apiVersions) {
        this.apiVersions = apiVersions;
        return this;
    }

    /**
     * Get the properties.
     *
     * @return the properties value
     */
    public Map<String, String> properties() {
        return this.properties;
    }

    /**
     * Set the properties.
     *
     * @param properties the properties value to set
     * @return the ProviderResourceType object itself.
     */
    public ProviderResourceType withProperties(Map<String, String> properties) {
        this.properties = properties;
        return this;
    }

}
