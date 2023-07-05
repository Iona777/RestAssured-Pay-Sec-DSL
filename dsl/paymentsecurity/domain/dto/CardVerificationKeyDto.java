package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The unique id of the Card Verification Key (CVK). Note that a different key should be used for magstripe and chip
 * CVV/CVCs. The key must be of type CVK.
 *
 * @author cedmunds
 * @version 1.2.0
 * @since 1.2.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class CardVerificationKeyDto {

    /**
     * The unique id of a cryptographic key.
     */
    private String id;

}
