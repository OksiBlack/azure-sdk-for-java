/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.peering.v2019_08_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.peering.v2019_08_01_preview.implementation.PeeringManager;
import com.microsoft.azure.management.peering.v2019_08_01_preview.implementation.PeeringInner;

/**
 * Type representing Peering.
 */
public interface Peering extends HasInner<PeeringInner>, Resource, GroupableResourceCore<PeeringManager, PeeringInner>, HasResourceGroup, Refreshable<Peering>, Updatable<Peering.Update>, HasManager<PeeringManager> {
    /**
     * @return the direct value.
     */
    PeeringPropertiesDirect direct();

    /**
     * @return the exchange value.
     */
    PeeringPropertiesExchange exchange();

    /**
     * @return the kind value.
     */
    Kind kind();

    /**
     * @return the peeringLocation value.
     */
    String peeringLocation();

    /**
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * @return the sku value.
     */
    PeeringSku sku();

    /**
     * The entirety of the Peering definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithKind, DefinitionStages.WithSku, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of Peering definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a Peering definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the Peering definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithKind> {
        }

        /**
         * The stage of the peering definition allowing to specify Kind.
         */
        interface WithKind {
           /**
            * Specifies kind.
            * @param kind The kind of the peering. Possible values include: 'Direct', 'Exchange'
            * @return the next definition stage
*/
            WithSku withKind(Kind kind);
        }

        /**
         * The stage of the peering definition allowing to specify Sku.
         */
        interface WithSku {
           /**
            * Specifies sku.
            * @param sku The SKU that defines the tier and kind of the peering
            * @return the next definition stage
*/
            WithCreate withSku(PeeringSku sku);
        }

        /**
         * The stage of the peering definition allowing to specify Direct.
         */
        interface WithDirect {
            /**
             * Specifies direct.
             * @param direct The properties that define a direct peering
             * @return the next definition stage
             */
            WithCreate withDirect(PeeringPropertiesDirect direct);
        }

        /**
         * The stage of the peering definition allowing to specify Exchange.
         */
        interface WithExchange {
            /**
             * Specifies exchange.
             * @param exchange The properties that define an exchange peering
             * @return the next definition stage
             */
            WithCreate withExchange(PeeringPropertiesExchange exchange);
        }

        /**
         * The stage of the peering definition allowing to specify PeeringLocation.
         */
        interface WithPeeringLocation {
            /**
             * Specifies peeringLocation.
             * @param peeringLocation The location of the peering
             * @return the next definition stage
             */
            WithCreate withPeeringLocation(String peeringLocation);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<Peering>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithDirect, DefinitionStages.WithExchange, DefinitionStages.WithPeeringLocation {
        }
    }
    /**
     * The template for a Peering update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<Peering>, Resource.UpdateWithTags<Update>, UpdateStages.WithDirect, UpdateStages.WithExchange, UpdateStages.WithPeeringLocation {
    }

    /**
     * Grouping of Peering update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the peering update allowing to specify Direct.
         */
        interface WithDirect {
            /**
             * Specifies direct.
             * @param direct The properties that define a direct peering
             * @return the next update stage
             */
            Update withDirect(PeeringPropertiesDirect direct);
        }

        /**
         * The stage of the peering update allowing to specify Exchange.
         */
        interface WithExchange {
            /**
             * Specifies exchange.
             * @param exchange The properties that define an exchange peering
             * @return the next update stage
             */
            Update withExchange(PeeringPropertiesExchange exchange);
        }

        /**
         * The stage of the peering update allowing to specify PeeringLocation.
         */
        interface WithPeeringLocation {
            /**
             * Specifies peeringLocation.
             * @param peeringLocation The location of the peering
             * @return the next update stage
             */
            Update withPeeringLocation(String peeringLocation);
        }

    }
}
