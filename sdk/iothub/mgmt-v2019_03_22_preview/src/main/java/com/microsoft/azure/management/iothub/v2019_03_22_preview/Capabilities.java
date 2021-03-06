/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.iothub.v2019_03_22_preview;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for Capabilities.
 */
public final class Capabilities extends ExpandableStringEnum<Capabilities> {
    /** Static value None for Capabilities. */
    public static final Capabilities NONE = fromString("None");

    /** Static value DeviceManagement for Capabilities. */
    public static final Capabilities DEVICE_MANAGEMENT = fromString("DeviceManagement");

    /**
     * Creates or finds a Capabilities from its string representation.
     * @param name a name to look for
     * @return the corresponding Capabilities
     */
    @JsonCreator
    public static Capabilities fromString(String name) {
        return fromString(name, Capabilities.class);
    }

    /**
     * @return known Capabilities values
     */
    public static Collection<Capabilities> values() {
        return values(Capabilities.class);
    }
}
