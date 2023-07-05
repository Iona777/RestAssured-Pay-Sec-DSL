package com.pps.dsl.paymentsecurity.examples;


import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.APP_BASE_URI;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_AUTHORISATION_HEADER;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_CONTENT_TYPE;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_ENCRYPTION_ID;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_QUERY_PARAM;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_X_CORRELATION_ID;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_X_REQUEST_ID;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_X_TENANT_ID;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_ZONE_PIN_BLOCK_FORMAT;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.EXAMPLE_ZPK;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.createEncryptCardPinRequest;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.createEncryptionKeyOnlyVariantResource;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.createSecurityCommandRequestResourceGenerateArpc;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.createSecurityCommandRequestResourceVerifyArqc;
import static com.pps.dsl.paymentsecurity.examples.QuickStartExampleData.createSecurityCommandRequestResourceVerifyArqcWithArpcGeneration;

import com.pps.dsl.paymentsecurity.PaymentSecurityDsl;
import com.pps.dsl.rest.RestResponse;
import lombok.NoArgsConstructor;


/**
 * A quick start guide to the Payment Security DSL.
 * <p>
 * This class provides some examples of how requests can be built for the endpoints. This is to demonstrate how the
 * library can be used within your automated test code to call the application under test.
 * <p>
 * the API can be found by running the payment-security application and then loading the following webpage:
 * https://<hostname>/v3/api-docs.yaml
 *
 * @author gmacdonald
 * @version 1.0.0
 * @since 1.0.0
 */

@NoArgsConstructor
public class QuickStart {

    /**
     * Constant that is re-used in several places
     */
    static RestResponse restResponse;


    /**
     * Use cases to submit the request to generate and verify ARPC and to encrypt Pins. Endpoint resource called will
     * be: POST:/security-commands.
     */

    public static void postSecurityCommandsExamples() {
        //@formatter:off

        /*
         * Example 1.
         * Submit a standard POST request to the security-commands for ARPC Generation.
         * This will return a new ARPC
         */
        PaymentSecurityDsl.app(APP_BASE_URI)
                .securityCommandsClient()
                .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
                .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
                .xTenantId(EXAMPLE_X_TENANT_ID)
                .contentType(EXAMPLE_CONTENT_TYPE)
                .authorization(EXAMPLE_AUTHORISATION_HEADER)
                .with(createSecurityCommandRequestResourceGenerateArpc())
                .submitPost();

        /*
         * Example 2.
         * Submit a standard POST request to the security-commands for ARQC Verification.
         * This will verify the given ARPC
         */
        PaymentSecurityDsl.app(APP_BASE_URI)
                .securityCommandsClient()
                .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
                .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
                .xTenantId(EXAMPLE_X_TENANT_ID)
                .contentType(EXAMPLE_CONTENT_TYPE)
                .authorization(EXAMPLE_AUTHORISATION_HEADER)
                .with(createSecurityCommandRequestResourceVerifyArqc())
                .submitPost();

        /*
         * Example 3.
         * Submit a standard POST request to the security-commands for ARQC Verification with ARPC generation.
         * This wil both return a new ARPC and verify it.
         */
        PaymentSecurityDsl.app(APP_BASE_URI)
                .securityCommandsClient()
                .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
                .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
                .xTenantId(EXAMPLE_X_TENANT_ID)
                .contentType(EXAMPLE_CONTENT_TYPE)
                .authorization(EXAMPLE_AUTHORISATION_HEADER)
                .with(createSecurityCommandRequestResourceVerifyArqcWithArpcGeneration())
                .submitPost();

        /*
        * Example 3.
        * Submit a standard POST request to the security-commands for Pin Encryption
        */
        PaymentSecurityDsl.app(APP_BASE_URI)
                .securityCommandsClient()
                .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
                .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
                .xTenantId(EXAMPLE_X_TENANT_ID)
                .contentType(EXAMPLE_CONTENT_TYPE)
                .authorization(EXAMPLE_AUTHORISATION_HEADER)
                .with(createEncryptCardPinRequest(EXAMPLE_ZPK, EXAMPLE_ZONE_PIN_BLOCK_FORMAT, true));

        //@formatter:on

    }

    /**
     * Use cases to submit the request to create new encryption key. Endpoint resource called will be:
     * POST:/encryption-keys.
     */

    public static void postEncryptionKeysExamples() {

        /*
         * Example 1.
         * Submit a standard POST request to encryption-keys for encryption key generation.
         */
        //@formatter:off
        PaymentSecurityDsl.app(APP_BASE_URI)
                .encryptionKeysClient()
                .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
                .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
                .xTenantId(EXAMPLE_X_TENANT_ID)
                .contentType(EXAMPLE_CONTENT_TYPE)
                .authorization(EXAMPLE_AUTHORISATION_HEADER)
                .with(createEncryptionKeyOnlyVariantResource())
                .queryParams()
                .embed(EXAMPLE_QUERY_PARAM)
                .add()
                .submitPost();

        //@formatter:on
    }

    /**
     * Use cases to submit the request to delete an encryption key. Endpoint resource called will be:
     * DELETE:/encryption-keys{id}.
     */

    public static void deleteEncryptionKeysExamples() {

        /*
         * Example 1.
         * Submit a standard DELETE request to encryption-keys for encryption key deletion
         */
        //@formatter:off
        PaymentSecurityDsl.app(APP_BASE_URI)
                .encryptionKeysClient()
                .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
                .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
                .xTenantId(EXAMPLE_X_TENANT_ID)
                .contentType(EXAMPLE_CONTENT_TYPE)
                .authorization(EXAMPLE_AUTHORISATION_HEADER)
                .submitDelete(EXAMPLE_ENCRYPTION_ID);

        //@formatter:on

    }

    /**
     * Use cases to submit the request to fetch encryption keys. Endpoint resource called will be:
     * GET:/encryption-keys.
     */

    public static void getEncryptionKeysExamples() {

   //@formatter:off

   /*
    * Example 1.
    * Submit a standard GET request to encryption-key for all the encryption keys
    */

        PaymentSecurityDsl.app(APP_BASE_URI)
            .encryptionKeysClient()
            .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
            .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
            .xTenantId(EXAMPLE_X_TENANT_ID)
            .contentType(EXAMPLE_CONTENT_TYPE)
            .authorization(EXAMPLE_AUTHORISATION_HEADER)
            .submitGet();

    /*
     * Example 2.
     * Submit a standard GET request to the encryption-key sto get a specific encryption key
     */

        PaymentSecurityDsl.app(APP_BASE_URI)
                .encryptionKeysClient()
                .xCorrelationIdHeader(EXAMPLE_X_CORRELATION_ID)
                .xRequestIdHeader(EXAMPLE_X_REQUEST_ID)
                .xTenantId(EXAMPLE_X_TENANT_ID)
                .contentType(EXAMPLE_CONTENT_TYPE)
                .authorization(EXAMPLE_AUTHORISATION_HEADER)
                .submitGet(EXAMPLE_ENCRYPTION_ID);

    //@formatter:on
    }
}



