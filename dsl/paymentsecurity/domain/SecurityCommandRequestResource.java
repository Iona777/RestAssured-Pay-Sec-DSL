package com.pps.dsl.paymentsecurity.domain;

import com.pps.dsl.paymentsecurity.domain.dto.request.DecryptDataCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.DecryptPinCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.EncryptDataCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.EncryptPinCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.GenerateArpcCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.GenerateCvcCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.GeneratePinCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.GeneratePinOffsetCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.TranslatePinToZonesCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.VerifyArqcCommandRequestDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The container for payment security commands
 *
 * @author vradulescu, nong, gmacdonald, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class SecurityCommandRequestResource {

    /**
     * Commands to encrypt one or more item of data e.g. card PANs.
     */
    private List<EncryptDataCommandRequestDto> encryptData;

    /**
     * Commands to decrypt one or more item of encrypted data e.g. card PANs.
     */
    private List<DecryptDataCommandRequestDto> decryptData;

    /**
     * Commands to generate random PINs.
     */
    private List<GeneratePinCommandRequestDto> generatePins;

    /**
     * Commands to decrypt LMK PIN blocks.
     */
    private List<DecryptPinCommandRequestDto> decryptPins;

    /**
     * Commands to encrypt PINs to LMK PIN blocks.
     */
    private List<EncryptPinCommandRequestDto> encryptPins;

    /**
     * Commands to generate PIN offsets.
     */
    private List<GeneratePinOffsetCommandRequestDto> generatePinOffsets;

    /**
     * Commands to translate PIN blocks to a ZPK (Zone PIN Key) for secure transmission.
     */
    private List<TranslatePinToZonesCommandRequestDto> translatePinToZones;

    /**
     * Commands to generate CVV/CVC values.
     */
    private List<GenerateCvcCommandRequestDto> generateCvcs;

    /**
     * Commands to generate ARPCs.
     */
    private List<GenerateArpcCommandRequestDto> generateArpcs;

    /**
     * Commands to verify ARQC.
     */
    private List<VerifyArqcCommandRequestDto> verifyArqcs;

}
