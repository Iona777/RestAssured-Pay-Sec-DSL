package com.pps.dsl.paymentsecurity.domain.dto.response;

import com.pps.dsl.paymentsecurity.domain.dto.ZonePinBlockFormatDto;
import com.pps.dsl.paymentsecurity.domain.dto.ZonePinKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The result of one or more commands to translate PIN blocks to a ZPK (Zone PIN Key) for secure transmission.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class TranslatePinToZonesCommandResponseDto {

    /**
     * The format by which the encrypted PIN block is formatted and padded.
     */
    private ZonePinBlockFormatDto zonePinBlockFormat;

    /**
     * The LMK encrypted PIN block.
     */
    private String pinBlock;

    /**
     * The LMK encrypted PIN block.
     */
    private String zonePinBlock;

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * The zone PIN key.
     */
    private ZonePinKeyDto zonePinKey;

}
