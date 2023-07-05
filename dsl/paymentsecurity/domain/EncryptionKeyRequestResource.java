package com.pps.dsl.paymentsecurity.domain;

import com.pps.dsl.paymentsecurity.domain.dto.EncryptedKeyValueDto;
import com.pps.dsl.paymentsecurity.domain.dto.ScopeDto;
import com.pps.dsl.paymentsecurity.domain.dto.StatusDto;
import com.pps.dsl.paymentsecurity.domain.dto.TypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * An HSM managed encryption key. An encryption key is needed to work with the payment HSM.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class EncryptionKeyRequestResource {

    /**
     * The (well known) given identifier of the cryptographic key. Multiple keys with the same code may exist with
     * different indexes or in different scopes. As such both the code and index and optionally the scope are required
     * to uniquely identify a key.
     */
    private String code;

    /**
     * The index of the key where more than one version of the key exists with the same code. Multiple indexes are used
     * to support key rotation/replacement or other uses of different keys for the same use case.
     */
    private Long index;

    /**
     * Human-readable name for the key.
     */
    private String name;

    /**
     * Optional further information relating to the key.
     */
    private String description;

    /**
     * The state of the encryption key.
     */
    private StatusDto status;

    /**
     * Further limitations on the usage of the encryption key.
     */
    private ScopeDto scope;

    /**
     * The type (usage) of the encryption key.
     */
    private TypeDto type;

    /**
     * The encryption algorithm for the key.
     */
    private String algorithm;

    /**
     * A key encrypted by the HSM. If not provided then one will be generated.
     */
    private EncryptedKeyValueDto encryptedKeyValue;

    private boolean generateEncryptionKeyRequest;

}
