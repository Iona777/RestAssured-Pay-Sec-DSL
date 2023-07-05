package com.pps.dsl.paymentsecurity.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The result of one or more commands to decrypt LMK PIN blocks.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class DecryptPinCommandResponseDto {

    /**
     * The LMK encrypted PIN block.
     */
    private String pinBlock;

    /**
     * The requested clear PIN.
     */
    private String pin;

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

}
