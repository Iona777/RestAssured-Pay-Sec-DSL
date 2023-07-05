package com.pps.dsl.paymentsecurity.examples;

import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.APPLICATION_JSON_HEADER_VALUE;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.DUMMY_URL_PATH;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.EXAMPLE_BODY_PATTERN;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.EXAMPLE_BODY_PATTERNS;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.EXAMPLE_CONTENT_TYPE_HEADER;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.EXAMPLE_HEADERS;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.EXAMPLE_LIMIT_QUERY_PARAMETER;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.EXAMPLE_QUERY_PARAMS;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.LIMIT_QUERY_PARAM_KEY;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.WIREMOCK_BASE_URI;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.X_CORRELATION_ID_HEADER_KEY;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.X_CORRELATION_ID_VALUE;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.X_REQUEST_ID_HEADER_KEY;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.X_TENANT_ID_HEADER_KEY;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.createSecurityCommandRequestResourceARPCGeneration;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.createSecurityCommandRequestResourceARQCValidation;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.createSecurityCommandRequestResourceZPK;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.createSecurityCommandResponseResourceARPCGeneration;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.createSecurityCommandResponseResourceARQCValidation;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.createSecurityCommandResponseResourceZPK;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.exampleBadRequestResponse;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.getEncryptionKeysPagedResultResponse;
import static com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.gson;
import static org.apache.http.HttpHeaders.AUTHORIZATION;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;

import com.pps.dsl.paymentsecurity.PaymentSecurityDsl;
import com.pps.dsl.paymentsecurity.examples.QuickStartWiremockExampleData.SomeClass;
import com.pps.dsl.rest.HttpOperation;
import com.pps.dsl.rest.HttpStatusCode;
import com.pps.dsl.wiremock.AttributeMatcher;
import com.pps.dsl.wiremock.bodypattern.BodyPatternEqualTo;

/**
 * A quick start guide to the Payment Security Wiremock DSL endpoints.
 * <p>
 * The DSL endpoints are used to configure the Payment Security Wiremock instance by sending requests to its admin
 * endpoints that allow you to build up expected responses to be received when calling the actual endpoint specified.
 * <p>
 * This class provides some examples of how requests can be built for the endpoints. This is to demonstrate how the
 * library can be used within your automated test code. You could in theory copy snippets from this file directly into
 * your test code if the description matches what you wanted to do.
 * <p>
 * Please ensure that you cross-reference against the API document linked below when building up the response objects to
 * be returned. The response objects can be built using the classes under the 'domain' package or just by manually
 * building them with the various GSON Json based classes (JSONObject, JSONArray etc.).
 * <p>
 * Reference the QuickStartWiremockExampleData file to get a handle on what model classes are used with each endpoint as
 * there will be an example there for each endpoint.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class QuickStartWiremock {

    private QuickStartWiremock() {
    }

    /**
     * <h2>Base Wiremock methods</h2>
     * Examples of how requests can be made to reset the state of the wiremock server. This makes use of common methods
     * within the base WiremockServerManager class.
     */
    public static void wiremockBaseMethodsResetServerExamples() {
        //@formatter:off

        // Deletes all request logs in the request journal
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .resetRequestLogs()
                .submit();

        /*
         * Removes any stub mappings added since the server was started.
         * Note. Default stubs will not be deleted via this method
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .resetStubMappings()
                .submit();

        /*
         * Resets both the stub mappings and the request journal back to a default state.
         * Note. Default stubs will not be deleted via this method
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .resetSystem()
                .submit();

        //@formatter:on
    }

    /**
     * <h2>Base Wiremock methods</h2>
     * Examples of how requests can be configured to get stub mappings from the wiremock server. This makes use of
     * common methods within the base WiremockServerManager class.
     */
    public static void wiremockBaseMethodsGetStubMappingExamples() {
        //@formatter:off

        // Standard request to get all mappings from the server
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .getStubMappings()
                .submit()
                    .assertThat()
                    .successfulResponse(200)
                    .with()
                        .mappings().isNotEmpty()
                        .totalMappings().isEqualTo(10);

        // The request can also specify query parameters to tailor the response returned
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .getStubMappings()
                .withQueryParameters()
                    .limit(2)   // Limit the no. of responses to 2
                    .offset(5)  // Start returning responses from the 5th element
                .submit();

        //@formatter:on
    }

    /**
     * <h2>Base Wiremock methods</h2>
     * Examples of how requests can be configured to get the request journal (request logs) from the wiremock server.
     * This makes use of common methods within the base WiremockServerManager class.
     */
    public static void wiremockBaseMethodsGetRequestJournalExamples() {
        //@formatter:off

        // Standard request to get all requests received from the server
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .getRequestLogs()
                .submit()
                    .assertThat()
                    .successfulResponse(200)
                    .with()
                        .requests().isNotEmpty()
                        .totalRequests().isEqualTo(10);

        // The request can also specify query parameters to tailor the response returned
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .getRequestLogs()
                .withQueryParameters()
                    .limit(2)                       // Limit the no. of responses to 2
                    .since("2021-07-09T12:09:58Z")  // Return requests logged after this date only
                .submit();

        //@formatter:on
    }

    /**
     * <h2>Base Wiremock methods</h2>
     * Examples of how requests can be configured to retrieve a count of the number of requests found via a particular
     * criteria from the wiremock server. This makes use of common methods within the base WiremockServerManager class.
     */
    public static void wiremockBaseMethodsCountRequestsByCriteriaExamples() {
        //@formatter:off

        /*
         * Standard request without specifying a criteria.
         * This will send a blank payload as the criteria which will result in all requests being counted.
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .countRequestsByCriteria()
                .submit();

        /*
         * A request that specifies all possible criteria which will mean that only requests matching this input
         * criteria will be returned by wiremock if any exist.
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .countRequestsByCriteria()
                .withCriteria()
                    .urlPath("/api/v1/dummy-url/12345")     // Specify a URL Path - Note only one of urlPath or urlPathPattern can be used!
                    .httpOperation(HttpOperation.POST)      // Specify the http operation to match against
                    .bodyPatterns(EXAMPLE_BODY_PATTERNS)    // Specify a map of body pattern matchers
                    .headers(EXAMPLE_HEADERS)               // Specify a map of headers
                    .queryParameters(EXAMPLE_QUERY_PARAMS)  // Specify a list of query parameters
                .submit();

        /*
         * Another example request that would require a match on all criteria, however, this time showing how the
         * criteria can be built up differently if preferred.
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .countRequestsByCriteria()
                .withCriteria()
                    .urlPathPattern(DUMMY_URL_PATH)  // Specify a urlPathPattern - Note only one of urlPath or urlPathPattern can be used!
                    .httpOperation(HttpOperation.GET)   // Specify the http operation to match against
                    .queryParameter(LIMIT_QUERY_PARAM_KEY, EXAMPLE_LIMIT_QUERY_PARAMETER) // Specify a query param to add (added to a map internally)
                    .header(CONTENT_TYPE, EXAMPLE_CONTENT_TYPE_HEADER)    // Specify a header to add (added to a map internally)
                    .bodyPattern(EXAMPLE_BODY_PATTERN)  // Specify a body pattern matcher to add (will be added to a list internally)
                .submit();

        /*
         * Another example request that would require a match on all criteria, however, this time showing how
         * query params and headers can be specified as strings using the equalTo match operator only
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .countRequestsByCriteria()
                .withCriteria()
                    .urlPathPattern(DUMMY_URL_PATH)  // Specify a urlPathPattern - Note only one of urlPath or urlPathPattern can be used!
                    .httpOperation(HttpOperation.GET)   // Specify the http operation to match against
                    .queryParameterEqualTo(LIMIT_QUERY_PARAM_KEY, String.valueOf(5))  // Specify an equalTo matcher for a query param
                    .headerEqualTo(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)  // Specify an equalTo matcher for a header
                    .bodyPattern(EXAMPLE_BODY_PATTERN)  // Specify a body pattern matcher to add (will be added to a list internally)
                .submit();

        //@formatter:on
    }

    /**
     * <h2>Base Wiremock methods</h2>
     * Examples of how requests can be configured to retrieve requests found via a particular criteria from the wiremock
     * server. This makes use of common methods within the base WiremockServerManager class.
     */
    public static void wiremockBaseMethodsFindRequestsByCriteriaExamples() {
        //@formatter:off

        /*
         * Standard request without specifying a criteria.
         * This will send a blank payload as the criteria which will result in all requests being counted.
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .findRequestsByCriteria()
                .submit();

        /*
         * A request that specifies all possible criteria which will mean that only requests matching this input
         * criteria will be returned by wiremock if any exist.
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .findRequestsByCriteria()
                .withCriteria()
                    .urlPath("/api/v1/dummy-url/12345")     // Specify a URL Path - Note only one of urlPath or urlPathPattern can be used!
                    .httpOperation(HttpOperation.POST)  // Specify the http operation to match against
                    .bodyPatterns(EXAMPLE_BODY_PATTERNS)    // Specify a map of body pattern matchers
                    .headers(EXAMPLE_HEADERS)               // Specify a map of headers
                    .queryParameters(EXAMPLE_QUERY_PARAMS)  // Specify a list of query parameters
                .submit();

        /*
         * Another example request that would require a match on all criteria, however, this time showing how the
         * criteria can be built up differently if preferred.
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .findRequestsByCriteria()
                .withCriteria()
                    .urlPathPattern(DUMMY_URL_PATH)  // Specify a urlPathPattern - Note only one of urlPath or urlPathPattern can be used!
                    .httpOperation(HttpOperation.GET)   // Specify the http operation to match against
                    .queryParameter(LIMIT_QUERY_PARAM_KEY, EXAMPLE_LIMIT_QUERY_PARAMETER)  // Specify a query param to add (added to a map internally)
                    .header(CONTENT_TYPE, EXAMPLE_CONTENT_TYPE_HEADER)     // Specify a header to add (added to a map internally)
                    .bodyPattern(EXAMPLE_BODY_PATTERN)  // Specify a body pattern matcher to add (will be added to a list internally)
                .submit();

        /*
         * Another example request that would require a match on all criteria, however, this time showing how
         * query params and headers can be specified as strings using the equalTo match operator only
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .findRequestsByCriteria()
                .withCriteria()
                    .urlPathPattern(DUMMY_URL_PATH)  // Specify a urlPathPattern - Note only one of urlPath or urlPathPattern can be used!
                    .httpOperation(HttpOperation.GET)   // Specify the http operation to match against
                    .queryParameterEqualTo(LIMIT_QUERY_PARAM_KEY, String.valueOf(5))  // Specify an equalTo matcher for a query param
                    .headerEqualTo(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)  // Specify an equalTo matcher for a header
                    .bodyPattern(EXAMPLE_BODY_PATTERN)  // Specify a body pattern matcher to add (will be added to a list internally)
                .submit();

        //@formatter:on
    }

    /**
     * <h2>Base Wiremock methods</h2>
     * Examples of how the request bodies of retrieved requests, found via a particular criteria from the wiremock
     * server, can be deserialized into a list of POJO's. This list can then be asserted by using the
     * SimpleResourceListAsserter.
     *
     * @see com.pps.dsl.asserter.SimpleResourceListAsserter
     */
    public static void wiremockBaseMethodsFindRequestsByCriteriaRequestBodyDeserializationExamples() {
        //@formatter:off

        /*
         * An example request that would require a match on all criteria. If a successful response is received
         * then the body property of each request object contained in the response will be deserialized into an example
         * class and wrapped with a SimpleResourceListAsserter. Assertions can then be applied to this list.
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .findRequestsByCriteria()
                .submit()
                .assertThat()
                .successfulResponse(200)
                .with()
                    .requestBody(SomeClass.class)
                    .entryAt(1)
                    .with()
                        .stringProperty(SomeClass::someStringProperty).isEqualTo("someExpectedValue")
                        .intProperty(SomeClass::someIntProperty).isEqualTo(999);

        //@formatter:on
    }

    /**
     * <h2>Payment Security specific mock methods</h2>
     * Examples of how the DSL can be used to pre-configure responses in the Payment Security Wiremock instance. These
     * examples configure responses for the endpoint: POST: /security-commands.
     */
    public static void onPostSecurityCommands() {
        //@formatter:off

        final String stubMappingName = "Mocked-Post-Security-Commands-Response";

        /*
            Pre-configures a response to requests on the 'POST /security-commands' endpoint that:
                - Accepts a request on the endpoint configured with:
                    - An Authorization header containing "Bearer" in it
                    - A payload matching the one specified (PIN encryption under a specific ZPK)
                - Will return a 200 OK response with the specified payload when the mocked endpoint is called
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .onPostSecurityCommands()
                    .configureStub()
                        .with()
                        .name(stubMappingName)
                        .addToStubMapping()
                .whenRequestIsMatched()
                    .with()
                    .header("Authorization", AttributeMatcher.builder().contains("Bearer").build())
                        .bodyPattern(BodyPatternEqualTo.builder()
                                .equalToJson(gson.toJson(createSecurityCommandRequestResourceZPK()))
                                .build())
                        .addToStubMapping()
                .toReturnStubbedResponse()
                    .with()
                        .status(HttpStatusCode.OK)
                        .header(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)
                        .jsonBody(gson.toJsonTree(createSecurityCommandResponseResourceZPK()).getAsJsonObject())
                        .addToStubMapping()
                .submit();

        /*
            Pre-configures a response to requests on the 'POST /security-commands' endpoint that:
                - Accepts a request on the endpoint configured with:
                    - An Authorization header matching "Bearer AUTHORIZATION_TOKEN" in it
                    - A payload matching the one specified (ARQC Validation)
                - Will return a 200 OK response with the specified payload when the mocked endpoint is called
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .onPostSecurityCommands()
                .configureStub()
                    .with()
                        .name(stubMappingName)
                        .addToStubMapping()
                .whenRequestIsMatched()
                    .with()
                        .headerEqualTo("Authorization", "Bearer AUTHORIZATION_TOKEN")
                        .bodyPattern(BodyPatternEqualTo.builder()
                                .equalToJson(gson.toJson(createSecurityCommandRequestResourceARQCValidation()))
                                .build())
                        .addToStubMapping()
                .toReturnStubbedResponse()
                    .with()
                        .status(HttpStatusCode.OK)
                        .header(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)
                        .jsonBody(gson.toJsonTree(createSecurityCommandResponseResourceARQCValidation()).getAsJsonObject())
                        .addToStubMapping()
                .submit();

        /*
            Pre-configures a response to requests on the 'POST /security-commands' endpoint that:
                - Accepts a request on the endpoint configured with:
                    - An X-Tenant-Id header with the specified value
                    - An X-Request-Id header with the specified value
                    - An X-Correlation-Id header with the specified value
                    - An Authorization header with the specified value
                    - A payload matching the one specified (ARPC Generation)
                - Will return a 200 OK response with the specified payload when the mocked endpoint is called
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .onPostSecurityCommands()
                .configureStub()
                    .with()
                        .name(stubMappingName)
                        .addToStubMapping()
                .whenRequestIsMatched()
                    .with()
                        .headerEqualTo(X_TENANT_ID_HEADER_KEY, "7567652789")
                        .headerEqualTo(X_REQUEST_ID_HEADER_KEY, "3024374c-3df4-46a0-984d-b57ef294eb79")
                        .headerEqualTo(X_CORRELATION_ID_HEADER_KEY, X_CORRELATION_ID_VALUE)
                        .headerEqualTo(AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6Ik2cVCJ9")
                        .bodyPattern(BodyPatternEqualTo.builder()
                                .equalToJson(gson.toJson(createSecurityCommandRequestResourceARPCGeneration()))
                                .build())
                        .addToStubMapping()
                .toReturnStubbedResponse()
                    .with()
                        .status(HttpStatusCode.OK)
                        .header(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)
                        .jsonBody(gson.toJsonTree(createSecurityCommandResponseResourceARPCGeneration()).getAsJsonObject())
                        .addToStubMapping()
                .submit();

        //@formatter:on
    }

    /**
     * <h2>Payment Security specific mock methods</h2>
     * Examples of how the DSL can be used to pre-configure responses in the Payment Security Wiremock instance. These
     * examples configure responses for the endpoint: GET: /encryption-keys.
     */
    public static void onGetEncryptionKeys() {
        //@formatter:off

        final String stubMappingName = "Mocked-Get-Encryption-Keys-Response";

        /*
            Pre-configures a response to requests on the 'GET /encryption-keys' endpoint that:
                - Accepts a request on the endpoint configured with:
                    - An X-Tenant-Id header with the specified value
                    - An X-Request-Id header with the specified value
                    - An X-Correlation-Id header with the specified value
                    - An Authorization header with the specified value
                - Will return a 200 OK response with the specified payload when the mocked endpoint is called
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .onGetEncryptionKeys()
                .configureStub()
                    .with()
                        .name(stubMappingName)
                        .addToStubMapping()
                .whenRequestIsMatched()
                    .with()
                        .headerEqualTo(X_TENANT_ID_HEADER_KEY, "7567652789")
                        .headerEqualTo(X_REQUEST_ID_HEADER_KEY, "3024374c-3df4-46a0-984d-b57ef294eb79")
                        .headerEqualTo(X_CORRELATION_ID_HEADER_KEY, X_CORRELATION_ID_VALUE)
                        .headerEqualTo(AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVav9")
                        .addToStubMapping()
                .toReturnStubbedResponse()
                    .with()
                        .status(HttpStatusCode.OK)
                        .header(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)
                        .jsonBody(gson.toJsonTree(getEncryptionKeysPagedResultResponse()).getAsJsonObject())
                        .addToStubMapping()
                .submit();

        /*
            Pre-configures a response to requests on the 'GET /encryption-keys' endpoint that:
                - Accepts any request on the endpoint
                - Will return a 400 BAD_REQUEST response with the specified payload when the mocked endpoint
                  is called
         */
        PaymentSecurityDsl.mockApp(WIREMOCK_BASE_URI)
                .onGetEncryptionKeys()
                .configureStub()
                    .with()
                        .name(stubMappingName)
                        .addToStubMapping()
                .toReturnStubbedResponse()
                    .with()
                        .status(HttpStatusCode.BAD_REQUEST)
                        .header(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE)
                        .jsonBody(gson.toJsonTree(exampleBadRequestResponse()).getAsJsonObject())
                        .addToStubMapping()
                .submit();

        //@formatter:on
    }

}
