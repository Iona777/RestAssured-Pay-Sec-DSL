package com.pps.dsl.paymentsecurity.domain.dto.response;

import com.pps.dsl.paymentsecurity.domain.dto.ZonePinKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The result of one or more commands to encrypt PINs.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class EncryptPinCommandResponseDto {

    /**
     * The LMK encrypted PIN block.
     */
    private String pinBlock;

    /**
     * The clear PIN to encrypt.
     */
    private String pin;

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * The PIN block format for the zone. (One of: ISO_ANSI_FORMAT_0, ISO_FORMAT_1, ISO_ANSI_FORMAT_3)
     */
    private String zonePinBlockFormat;

    /**
     * The zone PIN key.
     */
    private ZonePinKeyDto zonePinKey;

    /**
     * The ZPK encrypted PIN block.
     */
    private String zonePinBlock;

}
