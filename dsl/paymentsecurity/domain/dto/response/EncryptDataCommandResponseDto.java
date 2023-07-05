package com.pps.dsl.paymentsecurity.domain.dto.response;

import com.pps.dsl.paymentsecurity.domain.dto.EncryptionKeyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The result of one or more encrypt data commands.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class EncryptDataCommandResponseDto {

    /**
     * The unique id of the cryptographic key to use for the command. The key must be of type ZEK.
     */
    private EncryptionKeyDto encryptionKey;

    /**
     * The encrypted data.
     */
    private String encryptedData;

    /**
     * The clear data to be encrypted e.g. a card PAN.
     */
    private String data;

}
