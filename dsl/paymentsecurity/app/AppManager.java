package com.pps.dsl.paymentsecurity.app;

import com.pps.dsl.paymentsecurity.resources.EncryptionKeysClient;
import com.pps.dsl.paymentsecurity.resources.SecurityCommandsClient;
import com.pps.dsl.rest.JsonMappers;
import com.pps.dsl.rest.RestUtil;

/**
 * A manager class that provides methods to communicate with the Payment Security app REST apis.
 * <p>
 * Each method will identify a different resource grouping that can be used from the api.
 *
 * @author cedmunds, gmacdonald
 * @version 1.2.0
 * @since 1.2.0
 */
public class AppManager {

    /**
     * The REST utility used to connect and transfer data to / from the Payment Security app
     */
    private final RestUtil restUtil;

    /**
     * Constructs an instance of this class with the given {@link com.pps.dsl.rest.RestUtil}.
     *
     * @param restUtil the REST utility used to connect and transfer data to / from the app
     */
    public AppManager(RestUtil restUtil) {
        this.restUtil = restUtil;
    }

    /**
     * Returns an instance of {@link SecurityCommandsClient} that is then used to build a request to perform on the
     * security-commands resource from the Payment Security REST api.
     *
     * @return A new {@link SecurityCommandsClient} instance
     */
    public SecurityCommandsClient securityCommandsClient() {
        return new SecurityCommandsClient(restUtil, JsonMappers.defaultGsonMapper());
    }

    /**
     * Returns an instance of {@link EncryptionKeysClient} that is then used to build a request to perform on the
     * EncryptionKeys resource from the Payment Security REST api.
     *
     * @return A new {@link EncryptionKeysClient} instance
     */
    public EncryptionKeysClient encryptionKeysClient() {
        return new EncryptionKeysClient(restUtil, JsonMappers.defaultGsonMapper());
    }

}
