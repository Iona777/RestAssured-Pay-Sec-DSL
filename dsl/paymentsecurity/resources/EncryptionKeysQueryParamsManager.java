package com.pps.dsl.paymentsecurity.resources;

import com.pps.dsl.upgraded.QueryParameterBase;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * A builder of query parameters for the requests to the encryption-keys resource in the Payment Security app.
 *
 * @author gmacdonald
 * @version 1.2.0
 * @since 1.2.0
 */

public class EncryptionKeysQueryParamsManager extends QueryParameterBase<EncryptionKeysClient> {


    /**
     * Query parameter map for the requests to the screening-case resource.
     */
    @Getter
    @Accessors(fluent = true)
    private final Map<String, Object> queryParams;


    /**
     * Constructs an instance of this class with the supplied values.
     *
     * @param client The caller object that calls (or creates) this object
     */
    protected EncryptionKeysQueryParamsManager(EncryptionKeysClient client) {
        super(client);
        queryParams = new HashMap<>();
    }


    /**
     * Adds the given code value to the query parameter map.
     *
     * @param code The (well known) given identifier of the cryptographic key
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager code(final String code) {
        queryParams.put("code", code);
        return this;
    }

    /**
     * Adds the given status value to the query parameter map.
     *
     * @param status The state of the encryption key to match i.e. specify ACTIVE to ignore all inactive keys
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager status(final String status) {
        queryParams.put("status", status);
        return this;
    }

    /**
     * Adds the given embedded value to the query parameter map.
     *
     * @param embed Some elements are not included unless specifically requested. Elements may be requested by
     *              identifying the elements as a comma-separated list.
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager embed(final String embed) {
        queryParams.put("embed", embed);
        return this;
    }

    /**
     * Adds the given index value to the query parameter map.
     *
     * @param index The index of the key where more than one version of the key exists with the same scope and code.
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager index(final String index) {
        queryParams.put("index", index);
        return this;
    }

    /**
     * Adds the given latest_index_only value to the query parameter map.
     *
     * @param latestIndexOnly For each retrieved key (unique scope and code) retrieve only the latest version i.e. the
     *                          record with the highest index
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager latestIndexOnly(final boolean latestIndexOnly) {
        queryParams.put("latest_index_only", latestIndexOnly);
        return this;
    }

    /**
     * Adds the given zone value to the query parameter map.
     *
     * @param zone A scope defining the zone in which the encryption key may be used where keys are partitioned for
     *             different systems
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager zone(final String zone) {
        queryParams.put("zone", zone);
        return this;
    }

    /**
     * Adds the given group value to the query parameter map.
     *
     * @param group A scope defining the group for the key
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager group(final String group) {
        queryParams.put("group", group);
        return this;
    }

    /**
     * Adds the given bin value to the query parameter map.
     *
     * @param bin A scope defining the Bank Identifier Number (first 6 digits) and up to 2 further digits (segments) of
     *            the PAN for which the key is applicable.
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    public EncryptionKeysQueryParamsManager bin(final String bin) {
        queryParams.put("bin", bin);
        return this;
    }

    /**
     * Adds the given offset value to the query parameter map.
     * <p>
     * Note. Custom query parameters within this file should be specified before these base class query parameters are
     * used!
     *
     * @param offset filter by the given offset value
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    @Override
    public QueryParameterBase<EncryptionKeysClient> offset(Integer offset) {
        queryParams.put(OFFSET, offset);
        return this;
    }

    /**
     * Adds the given offset value to the query parameter map but allows the key to be specified as opposed to just
     * using "offset".
     * <p>
     * Note. Custom query parameters within this file should be specified before these base class query parameters are
     * used!
     *
     * @param key    the specific key to be given for the value in the query parameter map
     * @param offset filter by the given offset value
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    @Override
    public QueryParameterBase<EncryptionKeysClient> offset(String key, Integer offset) {
        queryParams.put(key, offset);
        return this;
    }

    /**
     * Adds the given limit value to the query parameter map.
     * <p>
     * Note. Custom query parameters within this file should be specified before these base class query parameters are
     * used!
     *
     * @param limit filter by the given limit value
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    @Override
    public QueryParameterBase<EncryptionKeysClient> limit(Integer limit) {
        queryParams.put(LIMIT, limit);
        return this;
    }

    /**
     * Adds the given limit value to the query parameter map but allows the key to be specified as opposed to just using
     * "limit".
     * <p>
     * Note. Custom query parameters within this file should be specified before these base class query parameters are
     * used!
     *
     * @param key   the specific key to be given for the value in the query parameter map
     * @param limit filter by the given limit value
     * @return This {@link EncryptionKeysQueryParamsManager} instance
     */
    @Override
    public QueryParameterBase<EncryptionKeysClient> limit(String key, Integer limit) {
        queryParams.put(key, limit);
        return this;
    }

}
