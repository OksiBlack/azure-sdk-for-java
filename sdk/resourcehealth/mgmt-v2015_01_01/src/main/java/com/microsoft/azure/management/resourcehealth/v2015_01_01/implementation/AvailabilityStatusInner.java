/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resourcehealth.v2015_01_01.implementation;

import com.microsoft.azure.management.resourcehealth.v2015_01_01.AvailabilityStatusProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * availabilityStatus of a resource.
 */
public class AvailabilityStatusInner {
    /**
     * Azure Resource Manager Identity for the availabilityStatuses resource.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * current.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Microsoft.ResourceHealth/AvailabilityStatuses.
     */
    @JsonProperty(value = "type")
    private String type;

    /**
     * Azure Resource Manager geo location of the resource.
     */
    @JsonProperty(value = "location")
    private String location;

    /**
     * Properties of availability state.
     */
    @JsonProperty(value = "properties")
    private AvailabilityStatusProperties properties;

    /**
     * Get azure Resource Manager Identity for the availabilityStatuses resource.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set azure Resource Manager Identity for the availabilityStatuses resource.
     *
     * @param id the id value to set
     * @return the AvailabilityStatusInner object itself.
     */
    public AvailabilityStatusInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get current.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set current.
     *
     * @param name the name value to set
     * @return the AvailabilityStatusInner object itself.
     */
    public AvailabilityStatusInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get microsoft.ResourceHealth/AvailabilityStatuses.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set microsoft.ResourceHealth/AvailabilityStatuses.
     *
     * @param type the type value to set
     * @return the AvailabilityStatusInner object itself.
     */
    public AvailabilityStatusInner withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get azure Resource Manager geo location of the resource.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Set azure Resource Manager geo location of the resource.
     *
     * @param location the location value to set
     * @return the AvailabilityStatusInner object itself.
     */
    public AvailabilityStatusInner withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get properties of availability state.
     *
     * @return the properties value
     */
    public AvailabilityStatusProperties properties() {
        return this.properties;
    }

    /**
     * Set properties of availability state.
     *
     * @param properties the properties value to set
     * @return the AvailabilityStatusInner object itself.
     */
    public AvailabilityStatusInner withProperties(AvailabilityStatusProperties properties) {
        this.properties = properties;
        return this;
    }

}
