package com.pps.dsl.paymentsecurity.resources;

import static com.pps.dsl.paymentsecurity.util.ResourcePaths.ENCRYPTION_KEYS_BY_KEY_PATH_GENERATOR;
import static com.pps.dsl.paymentsecurity.util.ResourcePaths.ENCRYPTION_KEYS_PATH;

import com.pps.dsl.paymentsecurity.domain.EncryptionKeyRequestResource;
import com.pps.dsl.paymentsecurity.domain.dto.EncryptionKeyUpdateResource;
import com.pps.dsl.rest.RestResponse;
import com.pps.dsl.rest.RestUtil;
import com.pps.dsl.upgraded.AppClientBaseDelete;
import com.pps.dsl.upgraded.AppClientBaseGet;
import com.pps.dsl.upgraded.AppClientBasePatch;
import com.pps.dsl.upgraded.AppClientBasePost;
import com.pps.qa.reporting.Metrics;
import io.restassured.mapper.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Manages various HTTP operations on the encryptionKeys resource in the Payment Security app REST api.
 *
 * @author gmacdonald
 * @version 1.2.0
 * @since 1.2.0
 */
@Slf4j
public class EncryptionKeysClient implements AppClientBasePost<RestResponse>, AppClientBaseGet<RestResponse>,
        AppClientBaseDelete<RestResponse>, AppClientBasePatch<RestResponse> {

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
     * Holds the request query parameters that can be configured.
     */
    private final EncryptionKeysQueryParamsManager queryParamsManager;

    /**
     * Holds a map of headers that can be configured and sent as part of the request.
     */
    private final Map<String, Object> headers;

    /**
     * The object used to make up the JSON body when making a POST request.
     */
    private Object postRequestResource;

    /**
     * The object used to make up the JSON body when making a PATCH request.
     */
    private Object patchRequestResource;

    /**
     * Constructs an instance of this class with the supplied values
     *
     * @param restUtil The rest utility used to connect and transfer data to / from the app
     * @param mapper   The mapper used to serialise / de-serialise various objects to / from JSON
     */
    public EncryptionKeysClient(RestUtil restUtil, ObjectMapper mapper) {
        this.restUtil = restUtil;
        this.mapper = mapper;
        this.queryParamsManager = new EncryptionKeysQueryParamsManager(this);
        this.headers = new HashMap<>();
    }

    /**
     * Returns the {@link EncryptionKeysQueryParamsManager} instance to add query parameters to the request.
     *
     * @return A {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager queryParams() {
        return queryParamsManager;
    }

    /**
     * Allows an invalid header to be added to the list of headers on the request. Both the name of the header and the
     * value to be supplied with it should be given.
     *
     * @param invalidHeaderKey   the name of the header to add
     * @param invalidHeaderValue the invalid value to give to the header
     * @return This instance of {@link EncryptionKeysClient}
     */
    @Override
    public EncryptionKeysClient invalidHeader(String invalidHeaderKey, Object invalidHeaderValue) {
        headers.put(invalidHeaderKey, invalidHeaderValue);
        return this;
    }

    /**
     * Adds the given X-Request-ID to the headers of the request.
     *
     * @param xRequestId the X-Request-ID value.
     * @return This instance of {@link EncryptionKeysClient}
     */
    public EncryptionKeysClient xRequestIdHeader(final String xRequestId) {
        headers.put(RestUtil.REQUEST_ID_HEADER, xRequestId);
        return this;
    }

    /**
     * Adds the given X-Correlation-ID to the headers of the request.
     *
     * @param xCorrelationId the X-Correlation-ID value.
     * @return This instance of {@link EncryptionKeysClient}
     */
    public EncryptionKeysClient xCorrelationIdHeader(final String xCorrelationId) {
        headers.put(RestUtil.CORRELATION_ID_HEADER, xCorrelationId);
        return this;
    }

    /**
     * Adds the given X-Tenant-ID to the headers of the request.
     *
     * @param xTenantId the X-Tenant-ID value.
     * @return This instance of {@link EncryptionKeysClient}
     */
    public EncryptionKeysClient xTenantId(final String xTenantId) {
        headers.put(RestUtil.TENANT_ID_HEADER, xTenantId);
        return this;
    }

    /**
     * Adds the given Authorization the headers of the request.
     *
     * @param authorization the Authorization value.
     * @return This instance of {@link EncryptionKeysClient}
     */
    public EncryptionKeysClient authorization(final String authorization) {
        headers.put(RestUtil.AUTHORIZATION_HEADER, "Bearer " + authorization);
        return this;
    }

    /**
     * Adds the given Content-Type to the headers of the request.
     *
     * @param contentType the Content-Type of the request.
     * @return This instance of {@link EncryptionKeysClient}
     */
    public EncryptionKeysClient contentType(final String contentType) {
        headers.put("Content-Type", contentType);
        return this;
    }

    /**
     * Allows a {@link EncryptionKeyRequestResource} resource to be supplied as the body of this POST request to the
     * application.
     *
     * @param postEncryptionKeyPayload the encryptionKeys payload resource to send to the application
     * @return This instance of {@link EncryptionKeysClient}
     */
    public EncryptionKeysClient with(EncryptionKeyRequestResource postEncryptionKeyPayload) {
        postRequestResource = postEncryptionKeyPayload;
        return this;
    }

    /**
     * Allows a {@link EncryptionKeyUpdateResource} resource to be supplied as the body of this PATCH request to the
     * application.
     *
     * @param patchEncryptionKeyPayload the encryptionKeys payload resource to send to the application
     * @return This instance of {@link EncryptionKeysClient}
     */
    public EncryptionKeysClient with(EncryptionKeyUpdateResource patchEncryptionKeyPayload) {
        patchRequestResource = patchEncryptionKeyPayload;
        return this;
    }

    /**
     * Allows any object to be supplied as the body of this request to the application. This allows for negative testing
     * to be performed by supplying bodies that don't match the required types at all.
     *
     * @param invalidPayload the invalid payload to send to the application
     * @return This instance of {@link EncryptionKeysClient}
     */
    @Override
    public EncryptionKeysClient withInvalidPayload(Object invalidPayload) {
        postRequestResource = invalidPayload;
        patchRequestResource = invalidPayload;
        return this;
    }

    /**
     * Performs a POST operation on the encryptionKeys REST resource.
     *
     * @return The {@link RestResponse} returned by the application that's called.
     */
    @Override
    public RestResponse submitPost() {
        log.debug("Post a new Encryption Keys payload to the app under test");
        Metrics metrics = new Metrics("REST");
        metrics.getParams().put(METRIC_NAME, "PostEncryptionKey");
        final RestResponse response =
                restUtil.post(ENCRYPTION_KEYS_PATH, postRequestResource, mapper, headers,
                        queryParamsManager.queryParams(), metrics);
        metrics.send();
        return response;
    }

    /**
     * Performs a GET operation on the encryptionKeys REST resource.
     *
     * @return The {@link RestResponse} returned by the application that's called.
     */
    @Override
    public RestResponse submitGet() {
        log.debug("Get all Encryption keys from the app under test");
        Metrics metrics = new Metrics("REST");
        metrics.getParams().put(METRIC_NAME, "GetEncryptionKeys");
        final RestResponse response =
                restUtil.get(ENCRYPTION_KEYS_PATH, mapper, queryParamsManager.queryParams(), headers, metrics);
        metrics.send();
        return response;
    }

    /**
     * Performs a GET operation with a String parameter on the encryptionKeys REST resource.
     *
     * @return The {@link RestResponse} returned by the application that's called.
     */
    @Override
    public RestResponse submitGet(final String encryptionKeyId) {
        log.debug("Get a unique Encryption Key from the app under test with ID: {}", encryptionKeyId);
        Metrics metrics = new Metrics("REST");
        metrics.getParams().put(METRIC_NAME, "GetUniqueEncryptionKey");
        final RestResponse response =
                restUtil.get(ENCRYPTION_KEYS_BY_KEY_PATH_GENERATOR.apply(encryptionKeyId), mapper,
                        queryParamsManager.queryParams(), headers, metrics);
        metrics.send();
        return response;
    }

    /**
     * Performs a DELETE operation on the encryptionKeys REST resource.
     *
     * @return The {@link RestResponse} returned by the application that's called.
     */
    @Override
    public RestResponse submitDelete() {
        return null;
    }

    @Override
    public RestResponse submitDelete(final String encryptionKeyId) {
        log.debug("Delete a unique Encryption Key from the app under test with ID: {}", encryptionKeyId);
        Metrics metrics = new Metrics("REST");
        metrics.getParams().put(METRIC_NAME, "DeleteUniqueEncryptionKey");
        final RestResponse response =
                restUtil.delete(ENCRYPTION_KEYS_BY_KEY_PATH_GENERATOR.apply(encryptionKeyId), metrics, headers);
        metrics.send();
        return response;
    }

    @Override
    public RestResponse submitPatch() {
        return null;
    }

    @Override
    public RestResponse submitPatch(final String encryptionKeyId) {
        log.debug("Encryption keys PATCH request with encryptionKey parameter to to the app under test");
        Metrics metrics = new Metrics("REST");
        metrics.getParams().put(METRIC_NAME, "PatchEncryptionKey");
        final RestResponse response =
                restUtil.patch(ENCRYPTION_KEYS_PATH, patchRequestResource, mapper, headers,
                        queryParamsManager.queryParams(), metrics);
        metrics.send();
        return response;
    }
}
