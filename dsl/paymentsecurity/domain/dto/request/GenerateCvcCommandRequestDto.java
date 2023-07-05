package com.pps.dsl.paymentsecurity.domain.dto.request;

import com.pps.dsl.paymentsecurity.domain.dto.CardVerificationKeyDto;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Commands to generate CVV/CVC values.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class GenerateCvcCommandRequestDto {

    private Type type;

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * The expiry date of the card. This must be the fulfilled (or hard) expiry date usually printed on a physical
     * card.
     */
    private LocalDate expiryDate;

    /**
     * The card service code to be used to generate the CVV/CVC. Note that for chip CVC (track 2 equivalent data) the
     * service code should be set to 999
     */
    private String serviceCode;

    /**
     * The unique id of the Card Verification Key (CVK). Note that a different key should be used for magstripe and chip
     * CVV/CVCs. The key must be of type CVK.
     */
    private CardVerificationKeyDto cardVerificationKey;

    public enum Type {
        CVC1,
        CVC2
    }

}
