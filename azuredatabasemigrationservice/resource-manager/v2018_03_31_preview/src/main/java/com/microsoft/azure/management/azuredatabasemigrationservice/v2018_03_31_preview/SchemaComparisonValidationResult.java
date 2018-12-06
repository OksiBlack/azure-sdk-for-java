/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.azuredatabasemigrationservice.v2018_03_31_preview;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Results for schema comparison between the source and target.
 */
public class SchemaComparisonValidationResult {
    /**
     * List of schema differences between the source and target databases.
     */
    @JsonProperty(value = "schemaDifferences")
    private SchemaComparisonValidationResultType schemaDifferences;

    /**
     * List of errors that happened while performing schema compare validation.
     */
    @JsonProperty(value = "validationErrors")
    private ValidationError validationErrors;

    /**
     * Count of source database objects.
     */
    @JsonProperty(value = "sourceDatabaseObjectCount")
    private Map<String, Long> sourceDatabaseObjectCount;

    /**
     * Count of target database objects.
     */
    @JsonProperty(value = "targetDatabaseObjectCount")
    private Map<String, Long> targetDatabaseObjectCount;

    /**
     * Get list of schema differences between the source and target databases.
     *
     * @return the schemaDifferences value
     */
    public SchemaComparisonValidationResultType schemaDifferences() {
        return this.schemaDifferences;
    }

    /**
     * Set list of schema differences between the source and target databases.
     *
     * @param schemaDifferences the schemaDifferences value to set
     * @return the SchemaComparisonValidationResult object itself.
     */
    public SchemaComparisonValidationResult withSchemaDifferences(SchemaComparisonValidationResultType schemaDifferences) {
        this.schemaDifferences = schemaDifferences;
        return this;
    }

    /**
     * Get list of errors that happened while performing schema compare validation.
     *
     * @return the validationErrors value
     */
    public ValidationError validationErrors() {
        return this.validationErrors;
    }

    /**
     * Set list of errors that happened while performing schema compare validation.
     *
     * @param validationErrors the validationErrors value to set
     * @return the SchemaComparisonValidationResult object itself.
     */
    public SchemaComparisonValidationResult withValidationErrors(ValidationError validationErrors) {
        this.validationErrors = validationErrors;
        return this;
    }

    /**
     * Get count of source database objects.
     *
     * @return the sourceDatabaseObjectCount value
     */
    public Map<String, Long> sourceDatabaseObjectCount() {
        return this.sourceDatabaseObjectCount;
    }

    /**
     * Set count of source database objects.
     *
     * @param sourceDatabaseObjectCount the sourceDatabaseObjectCount value to set
     * @return the SchemaComparisonValidationResult object itself.
     */
    public SchemaComparisonValidationResult withSourceDatabaseObjectCount(Map<String, Long> sourceDatabaseObjectCount) {
        this.sourceDatabaseObjectCount = sourceDatabaseObjectCount;
        return this;
    }

    /**
     * Get count of target database objects.
     *
     * @return the targetDatabaseObjectCount value
     */
    public Map<String, Long> targetDatabaseObjectCount() {
        return this.targetDatabaseObjectCount;
    }

    /**
     * Set count of target database objects.
     *
     * @param targetDatabaseObjectCount the targetDatabaseObjectCount value to set
     * @return the SchemaComparisonValidationResult object itself.
     */
    public SchemaComparisonValidationResult withTargetDatabaseObjectCount(Map<String, Long> targetDatabaseObjectCount) {
        this.targetDatabaseObjectCount = targetDatabaseObjectCount;
        return this;
    }

}