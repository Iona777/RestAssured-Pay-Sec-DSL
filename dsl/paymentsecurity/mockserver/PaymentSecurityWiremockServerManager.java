package com.pps.dsl.paymentsecurity.mockserver;

import static com.pps.dsl.paymentsecurity.util.ResourcePaths.ENCRYPTION_KEYS_PREFIX;
import static com.pps.dsl.paymentsecurity.util.ResourcePaths.SECURITY_COMMANDS_PREFIX;
import static com.pps.dsl.util.ResourcePaths.APP_BASE_PATH;

import com.pps.dsl.rest.HttpOperation;
import com.pps.dsl.rest.HttpPath;
import com.pps.dsl.rest.RestUtil;
import com.pps.dsl.wiremock.WiremockServerManager;
import com.pps.dsl.wiremock.configurator.StubMappingConfigurator;

/**
 * A wiremock manager instance that is specific to the Payment-Security REST api endpoints.
 * <p>
 * This extends the base wiremock manager so that the common endpoints can be used whilst also configuring endpoints
 * that are specific for adding Payment-Security related stub mappings to the wiremock server.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
public class PaymentSecurityWiremockServerManager extends WiremockServerManager {

    /**
     * Constructs a new instance that uses the given {@link RestUtil} instance to configure the responses in the
     * wiremock server
     *
     * @param restUtil The rest utility used to connect to the wiremock server
     */
    public PaymentSecurityWiremockServerManager(RestUtil restUtil) {
        super(restUtil);
    }

    /**
     * Enables the configuration of a stubbed response for the POST /security-commands endpoint. The request matching is
     * mostly handled internally allowing just the response specification to be focused on.
     *
     * @return a <tt>StubMappingConfigurator</tt>> instance specific to this endpoint
     */
    public StubMappingConfigurator onPostSecurityCommands() {
        return new StubMappingConfigurator(restUtil, HttpOperation.POST,
                HttpPath.builder().url('/' + APP_BASE_PATH.expandedUrl() + SECURITY_COMMANDS_PREFIX)
                        .build());
    }

    /**
     * Enables the configuration of a stubbed response for the GET /encryption-keys endpoint. The request matching is
     * mostly handled internally allowing just the response specification to be focused on.
     *
     * @return a <tt>StubMappingConfigurator</tt>> instance specific to this endpoint
     */
    public StubMappingConfigurator onGetEncryptionKeys() {
        return new StubMappingConfigurator(restUtil, HttpOperation.GET,
                HttpPath.builder().url('/' + APP_BASE_PATH.expandedUrl() + ENCRYPTION_KEYS_PREFIX)
                        .build());
    }

}
