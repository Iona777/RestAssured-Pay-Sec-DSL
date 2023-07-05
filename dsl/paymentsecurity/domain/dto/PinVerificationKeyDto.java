package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The unique id of the PIN Verification Key (PVK) to use to generate the PIN Offset. The key must be of type PVK.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class PinVerificationKeyDto {

    /**
     * The unique id of a cryptographic key.
     */
    private String id;

}
