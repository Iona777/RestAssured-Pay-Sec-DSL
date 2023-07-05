package com.pps.dsl.paymentsecurity.domain.dto.request;

import com.pps.dsl.paymentsecurity.domain.dto.ApplicationCryptogramKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Commands to verify ARQC.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class VerifyArqcCommandRequestDto {

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * The sequence number of the Card, which is read from the Card and provided in an Auth Request to PPS. This is
     * optional. If not present, should be handled as an empty string.
     */
    private String panSequenceNumber;

    /**
     * The ARQC scheme, which specifies the Key Derivation Method that the HSM will use for verifying the ARQC
     */
    private String scheme;

    /**
     * The unique id of the cryptographic key to use for the command. The key must be of type ZEK.
     */
    private ApplicationCryptogramKeyDto applicationCryptogramKey;

    /**
     * The ARQC to be verified
     */
    private String arqc;

    /**
     * Application Transaction Counter - a counter used by the chip on the Card in generating the ARQC, that the
     * algorithm needs to know to be able to verify it
     */
    private String atc;

    /**
     * Concatenated fields of data from the Auth Request to PPS, that should be passed to the HSM as is. Payment
     * Security will not be responsible for assembling the content of this.
     */
    private String transactionData;

    /**
     * Specifies the requirements for ARPC Generation, and the method that should be used for ARPC generation if needed
     */
    private String arpcGeneration;

    /**
     * Card Status Update, used as an input in the generation of the ARPC.
     */
    private String csu;

}
