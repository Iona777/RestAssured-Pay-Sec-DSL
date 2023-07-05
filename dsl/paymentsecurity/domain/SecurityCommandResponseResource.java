package com.pps.dsl.paymentsecurity.domain;

import com.pps.dsl.paymentsecurity.domain.dto.response.DecryptDataCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.DecryptPinCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.EncryptDataCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.EncryptPinCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.GenerateArpcCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.GenerateCvcCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.GeneratePinCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.GeneratePinOffsetCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.TranslatePinToZonesCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.VerifyArqcCommandResponseDto;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The command was successfully executed and the results included in the response payload.
 *
 * @author vradulescu, gmacdonald, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class SecurityCommandResponseResource {

    /**
     * The result of one or more decrypt data commands.
     */
    private List<DecryptDataCommandResponseDto> decryptData = new ArrayList<>();

    /**
     * The result of one or more commands to translate PIN blocks to a ZPK (Zone PIN Key) for secure transmission.
     */
    private List<TranslatePinToZonesCommandResponseDto> translatePinToZones = new ArrayList<>();

    /**
     * The result of one or more commands to decrypt LMK PIN blocks.
     */
    private List<DecryptPinCommandResponseDto> decryptPins = new ArrayList<>();

    /**
     * The result of one or more encrypt data commands.
     */
    private List<EncryptDataCommandResponseDto> encryptData = new ArrayList<>();

    /**
     * The result of one or more commands to encrypt PINs.
     */
    private List<EncryptPinCommandResponseDto> encryptPins = new ArrayList<>();

    /**
     * The result of one or more commands to generate PIN offsets
     */
    private List<GeneratePinOffsetCommandResponseDto> generatePinOffsets = new ArrayList<>();

    /**
     * The result of one or more commands to generate random PINs.
     */
    private List<GeneratePinCommandResponseDto> generatePins = new ArrayList<>();

    /**
     * The result of one or more commands to generate CVV/CVC values.
     */
    private List<GenerateCvcCommandResponseDto> generateCvcs = new ArrayList<>();

    /**
     * The result of one or more commands to generate ARPCs.
     */
    private List<GenerateArpcCommandResponseDto> generateArpcs = new ArrayList<>();

    /**
     * The result of one or more commands to verify ARQC values.
     */
    private List<VerifyArqcCommandResponseDto> verifyArqcs = new ArrayList<>();

}
