package com.pps.dsl.paymentsecurity.domain.dto.request;

import com.pps.dsl.paymentsecurity.domain.dto.ZonePinBlockFormatDto;
import com.pps.dsl.paymentsecurity.domain.dto.ZonePinKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Commands to translate PIN blocks to a ZPK (Zone PIN Key) for secure transmission.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class TranslatePinToZonesCommandRequestDto {

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * The LMK encrypted PIN block.
     */
    private String pinBlock;

    /**
     * The format by which the encrypted PIN block is formatted and padded.
     */
    private ZonePinBlockFormatDto zonePinBlockFormat;

    /**
     * The zone PIN key.
     */
    private ZonePinKeyDto zonePinKey;

}
