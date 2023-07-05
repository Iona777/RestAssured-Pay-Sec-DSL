package com.pps.dsl.paymentsecurity.domain.dto.request;

import com.pps.dsl.paymentsecurity.domain.dto.EncryptionKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Commands to decrypt one or more item of encrypted data e.g. card PANs.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class EncryptDataCommandRequestDto {

    /**
     * The unique id of the cryptographic key to use for the command. The key must be of type ZEK.
     */
    private EncryptionKeyDto encryptionKey;

    /**
     * The clear data to be encrypted e.g. a card PAN.
     */
    private String data;

}
