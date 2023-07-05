package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Modifiable fields on an HSM management encryption key.
 *
 * @author gmacdonald
 * @version 1.2.0
 * @since 1.2.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class EncryptionKeyUpdateResource {

    /**
     * The state of the encryption key.
     */
    private StatusDto status;
}
