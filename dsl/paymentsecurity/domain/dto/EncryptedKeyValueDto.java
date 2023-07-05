package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A key encrypted by the HSM. If not provided then one will be generated.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class EncryptedKeyValueDto {

    /**
     * The HSM encrypted key variant value. If omitted in a POST request the key value will be generated. Will be
     * omitted in responses without the embed query parameter with 'encrypted_key_value' and the appropriate
     * permission.
     */
    private String variantValue;

    /**
     * The HSM encrypted key keyblock value. If omitted in a POST request the key value will be generated. Will be
     * omitted in responses without the embed query parameter with 'encrypted_key_value' and the appropriate
     * permission.
     */
    private String keyblockValue;

    /**
     * The non-sensitive check value used to validate the key value for imported or exported keys. Required if the value
     * is present.
     */
    private String checkValue;

    /**
     * The key under which the value (subordinate key) is encrypted. Must be of type ZMK (Zone Management Key). If
     * omitted the key is protected by the LMK.
     */
    private ManagementKeyDto managementKey;

}
