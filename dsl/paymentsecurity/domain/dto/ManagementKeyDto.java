package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The key under which the value (subordinate key) is encrypted. Must be of type ZMK (Zone Management Key). If omitted
 * the key is protected by the LMK.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class ManagementKeyDto {

    /**
     * The unique id of a cryptographic key.
     */
    private String id;

}
