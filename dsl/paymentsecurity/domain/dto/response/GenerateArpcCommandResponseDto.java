package com.pps.dsl.paymentsecurity.domain.dto.response;

import com.pps.dsl.paymentsecurity.domain.dto.ApplicationCryptogramKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The result of one or more commands to generate ARPCs.
 *
 * @author cedmunds
 * @version 1.2.0
 * @since 1.2.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class GenerateArpcCommandResponseDto {

    /**
     * The clear PAN (Primary Account Number) of the card.
     */
    private String pan;

    /**
     * Optional sequence number of the PAN.
     */
    private String panSequenceNumber;

    /**
     * Specifies the Key Derivation Method that the HSM will use for generating the ARPC.
     */
    private String scheme;

    private String method;

    /**
     * The unique id of the cryptographic key to use for the command. The key must be of type ZEK.
     */
    private ApplicationCryptogramKeyDto applicationCryptogramKey;

    /**
     * The original ARQC to be used in the generation of the APRC.
     */
    private String arqc;

    /**
     * Application transaction counter is a counter used by the chip on the Card
     */
    private String atc;

    /**
     * Card Status Update, used as an input in the generation of the ARPC.
     */
    private String csu;

    /**
     * The generated ARPC.
     */
    private String arpc;

}
