package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Audit information for stored data
 *
 * @author vradulescu, gmacdonald, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class AuditDto {

    /**
     * The date and time that the resource was created
     */
    private String createdDateTime;

    /**
     * The date and time that the resource was last modified
     */
    private String updatedDateTime;

}
