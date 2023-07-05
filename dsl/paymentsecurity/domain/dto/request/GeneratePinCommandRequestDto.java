package com.pps.dsl.paymentsecurity.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Commands to generate random PINs.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class GeneratePinCommandRequestDto {

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * The length of the PIN.
     */
    private int pinLength;

}
