package com.pps.dsl.paymentsecurity;

import static com.pps.dsl.util.ResourcePaths.APP_BASE_PATH;
import static com.pps.dsl.wiremock.ResourcePaths.WIREMOCK_SERVER_BASE_PATH;

import com.pps.dsl.paymentsecurity.app.AppManager;
import com.pps.dsl.paymentsecurity.mockserver.PaymentSecurityWiremockServerManager;
import com.pps.dsl.rest.RestUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * An entry point to the Payment-Security App DSL context.
 *
 * @author vradulescu, gmacdonald, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentSecurityDsl {

    /**
     * Returns an app manager that communicates with the app server available at the given {@code appBaseUri}
     *
     * @param appBaseUri The app server base URI
     * @return An app manager that communicates with the app server available at the given {@code appBaseUri}
     */
    public static AppManager app(final String appBaseUri) {
        return new AppManager(new RestUtil(appBaseUri, APP_BASE_PATH));
    }

    /**
     * Returns the Payment Security wiremock manager allowing communications with a configured wiremock standalone
     * server instance available at the given {@code wiremockServerBaseUri}. This can then be used to pre-configure
     * responses with the methods within.
     *
     * @param wiremockServerBaseUri The wiremock instance base URI
     * @return A Wiremock manager that communicates with the wiremock service available at the given {@code
     * wiremockServerBaseUri}
     */
    public static PaymentSecurityWiremockServerManager mockApp(String wiremockServerBaseUri) {
        return new PaymentSecurityWiremockServerManager(new RestUtil(wiremockServerBaseUri, WIREMOCK_SERVER_BASE_PATH));
    }

}
