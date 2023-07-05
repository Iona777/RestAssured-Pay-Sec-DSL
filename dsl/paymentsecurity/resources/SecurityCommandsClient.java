package com.pps.dsl.paymentsecurity.resources;

import static com.pps.dsl.paymentsecurity.util.ResourcePaths.SECURITY_COMMANDS_PATH;

import com.pps.dsl.paymentsecurity.domain.SecurityCommandRequestResource;
import com.pps.dsl.rest.RestResponse;
import com.pps.dsl.rest.RestUtil;
import com.pps.dsl.upgraded.AppClientBasePost;
import com.pps.qa.reporting.Metrics;
import io.restassured.mapper.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Manages various HTTP operations on the security-commands resource in the Payment Security app REST api.
 *
 * @author gmacdonald, cedmunds
 * @version 1.2.0
 * @since 1.2.0
 */
@Slf4j
public class SecurityCommandsClient implements AppClientBasePost<RestResponse> {

    /**
     * Constant that is re-used in several places
     */
    public static final String METRIC_NAME = "MetricName";

    /**
     * The rest utility used to connect to the Payment Security app
     */
    private final RestUtil restUtil;

    /**
     * The mapper used to de-serialise the JSON string to the various objects
     */
    private final ObjectMapper mapper;

    /**
     * Holds a map of headers that can be configured and sent as part of the request.
     */
    private final Map<String, Object> headers;

    /**
     * The object used to make up the JSON body when making a POST request.
     */
    private Object postRequestResource;

    /**
     * Constructs an instance of this class with the supplied values
     *
     * @param restUtil The rest utility used to connect and transfer data to / from the app
     * @param mapper   The mapper used to serialise / de-serialise various objects to / from JSON
     */
    public SecurityCommandsClient(RestUtil restUtil, ObjectMapper mapper) {
        this.restUtil = restUtil;
        this.mapper = mapper;
        this.headers = new HashMap<>();
    }

    /**
     * Allows an invalid header to be added to the list of headers on the request. Both the name of the header and the
     * value to be supplied with it should be given.
     *
     * @param invalidHeaderKey   the name of the header to add
     * @param invalidHeaderValue the invalid value to give to the header
     * @return This instance of {@link SecurityCommandsClient}
     */
    @Override
    public SecurityCommandsClient invalidHeader(String invalidHeaderKey, Object invalidHeaderValue) {
        headers.put(invalidHeaderKey, invalidHeaderValue);
        return this;
    }

    /**
     * Adds the given X-Request-ID to the headers of the request.
     *
     * @param xRequestId the X-Request-ID value.
     * @return This instance of {@link SecurityCommandsClient}
     */
    public SecurityCommandsClient xRequestIdHeader(final String xRequestId) {
        headers.put(RestUtil.REQUEST_ID_HEADER, xRequestId);
        return this;
    }

    /**
     * Adds the given X-Correlation-ID to the headers of the request.
     *
     * @param xCorrelationId the X-Correlation-ID value.
     * @return This instance of {@link SecurityCommandsClient}
     */
    public SecurityCommandsClient xCorrelationIdHeader(final String xCorrelationId) {
        headers.put(RestUtil.CORRELATION_ID_HEADER, xCorrelationId);
        return this;
    }

    /**
     * Adds the given X-Tenant-ID to the headers of the request.
     *
     * @param xTenantId the X-Tenant-ID value.
     * @return This instance of {@link SecurityCommandsClient}
     */
    public SecurityCommandsClient xTenantId(final String xTenantId) {
        headers.put(RestUtil.TENANT_ID_HEADER, xTenantId);
        return this;
    }

    /**
     * Adds the given Authorization the headers of the request.
     *
     * @param authorization the Authorization value.
     * @return This instance of {@link SecurityCommandsClient}
     */
    public SecurityCommandsClient authorization(final String authorization) {
        headers.put(RestUtil.AUTHORIZATION_HEADER, "Bearer " + authorization);
        return this;
    }

    /**
     * Adds the given Content-Type to the headers of the request.
     *
     * @param contentType the Content-Type of the request.
     * @return This instance of {@link SecurityCommandsClient}
     */
    public SecurityCommandsClient contentType(final String contentType) {
        headers.put("Content-Type", contentType);
        return this;
    }

    /**
     * Allows a {@link SecurityCommandRequestResource} resource to be supplied as the body of this POST request to the
     * application.
     *
     * @param postSecurityCommand the security-command resource to send to the application
     * @return This instance of {@link SecurityCommandsClient}
     */
    public SecurityCommandsClient with(SecurityCommandRequestResource postSecurityCommand) {
        postRequestResource = postSecurityCommand;
        return this;
    }

    /**
     * Allows any object to be supplied as the body of this request to the application. This allows for negative testing
     * to be performed by supplying bodies that don't match the required types at all.
     *
     * @param invalidPayload the invalid payload to send to the application
     * @return This instance of {@link SecurityCommandsClient}
     */
    @Override
    public SecurityCommandsClient withInvalidPayload(Object invalidPayload) {
        postRequestResource = invalidPayload;
        return this;
    }

    /**
     * Performs a POST operation on the security-commands REST resource.
     *
     * @return The {@link RestResponse} returned by the application that's called.
     */
    @Override
    public RestResponse submitPost() {
        log.debug("Post a new Security Commands payload to the app under test");
        Metrics metrics = new Metrics("REST");
        metrics.getParams().put(METRIC_NAME, "PostSecurityCommands");
        final RestResponse response =
                restUtil.post(SECURITY_COMMANDS_PATH, postRequestResource, mapper, headers, null, metrics);
        metrics.send();
        return response;
    }

}
