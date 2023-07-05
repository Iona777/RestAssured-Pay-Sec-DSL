package com.pps.dsl.paymentsecurity.domain.dto.response;

import com.pps.dsl.paymentsecurity.domain.dto.PinOffsetType;
import com.pps.dsl.paymentsecurity.domain.dto.PinVerificationKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The result of one or more commands to generate PIN offsets
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class GeneratePinOffsetCommandResponseDto {

    /**
     * The calculated PIN offset.
     */
    private String pinOffset;

    /**
     * The LMK encrypted PIN block.
     */
    private String pinBlock;
    /**
     * The unique id of the PIN Verification Key (PVK) to use to generate the PIN Offset. The key must be of type PVK.
     */
    private PinVerificationKeyDto pinVerificationKey;

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * Indicator for the PIN offset algorithm / mechanism to use.
     */
    private PinOffsetType type;

}
