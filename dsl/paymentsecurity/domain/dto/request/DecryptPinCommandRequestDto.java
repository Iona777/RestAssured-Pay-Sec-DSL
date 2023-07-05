package com.pps.dsl.paymentsecurity.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Commands to decrypt one or more item of encrypted data e.g. card PANs.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class DecryptPinCommandRequestDto {

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * The LMK encrypted PIN block.
     */
    private String pinBlock;

}
