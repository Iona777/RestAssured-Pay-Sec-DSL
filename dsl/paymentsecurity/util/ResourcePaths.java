package com.pps.dsl.paymentsecurity.util;

import com.pps.dsl.rest.HttpPath;
import java.util.function.Function;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Holds the resource paths of the Payment-security endpoints
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResourcePaths {

    /**
     * Constant that is re-used in several places
     */

    public static final String ENCRYPTION_KEY_ID = "id";

    /**
     * Security commands resource URL path prefix
     */
    public static final String SECURITY_COMMANDS_PREFIX = "/security-commands";

    /**
     * The base path for the security-commands resources endpoints
     */
    public static final HttpPath SECURITY_COMMANDS_PATH = HttpPath.builder()
            .url(SECURITY_COMMANDS_PREFIX)
            .build();



    /**
     * Encryption keys resource URL path prefix
     */
    public static final String ENCRYPTION_KEYS_PREFIX = "/encryption-keys";

    /**
     * The base path for the encryption-keys resources endpoints
     */
    public static final HttpPath ENCRYPTION_KEYS_PATH = HttpPath.builder()
            .url(ENCRYPTION_KEYS_PREFIX)
            .build();

    /**
     * Function that generates the path corresponding to the encryption-keys resource with a specified encryptionKey.
     */
    public static final Function<String, HttpPath> ENCRYPTION_KEYS_BY_KEY_PATH_GENERATOR =
            encryptionKeyId -> HttpPath.builder()
                    .url(ENCRYPTION_KEYS_PREFIX + "/{id}")
                    .addPathParam(ENCRYPTION_KEY_ID, encryptionKeyId)
                    .build();

}
