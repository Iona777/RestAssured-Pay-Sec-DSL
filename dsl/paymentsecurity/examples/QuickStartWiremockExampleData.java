package com.pps.dsl.paymentsecurity.examples;

import static org.apache.http.HttpHeaders.CONTENT_TYPE;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.pps.dsl.paymentsecurity.domain.EncryptionKeyResponseResource;
import com.pps.dsl.paymentsecurity.domain.SecurityCommandRequestResource;
import com.pps.dsl.paymentsecurity.domain.SecurityCommandResponseResource;
import com.pps.dsl.paymentsecurity.domain.dto.ApplicationCryptogramKeyDto;
import com.pps.dsl.paymentsecurity.domain.dto.AuditDto;
import com.pps.dsl.paymentsecurity.domain.dto.EncryptedKeyValueDto;
import com.pps.dsl.paymentsecurity.domain.dto.ManagementKeyDto;
import com.pps.dsl.paymentsecurity.domain.dto.Method;
import com.pps.dsl.paymentsecurity.domain.dto.Scheme;
import com.pps.dsl.paymentsecurity.domain.dto.ScopeDto;
import com.pps.dsl.paymentsecurity.domain.dto.StatusDto;
import com.pps.dsl.paymentsecurity.domain.dto.TypeDto;
import com.pps.dsl.paymentsecurity.domain.dto.ZonePinBlockFormatDto;
import com.pps.dsl.paymentsecurity.domain.dto.ZonePinKeyDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.EncryptPinCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.GenerateArpcCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.VerifyArqcCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.EncryptPinCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.GenerateArpcCommandResponseDto;
import com.pps.dsl.paymentsecurity.domain.dto.response.VerifyArqcCommandResponseDto;
import com.pps.dsl.rest.ErrorResponse;
import com.pps.dsl.rest.JsonMappers;
import com.pps.dsl.rest.PagedResult;
import com.pps.dsl.wiremock.AttributeMatcher;
import com.pps.dsl.wiremock.bodypattern.BodyPattern;
import com.pps.dsl.wiremock.bodypattern.BodyPatternEqualTo;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * A class containing a lot of objects and values created that are then used in the QuickStartWiremock file in order to
 * show how requests/responses can be built and passed into the Wiremock dsl framework for the Payment Security mock.
 *
 * @author cedmunds
 * @version 1.2.0
 * @since 1.2.0
 */
@SuppressWarnings("unused")
public class QuickStartWiremockExampleData {

    /*
     * Constants that are re-used in several places
     */
    public static final String APPLICATION_JSON_HEADER_VALUE = "application/json";
    public static final String X_CORRELATION_ID_VALUE = UUID.randomUUID().toString();
    public static final String X_REQUEST_ID_HEADER_KEY = "X-Request-ID";
    public static final String X_CORRELATION_ID_HEADER_KEY = "X-Correlation-ID";
    public static final String X_TENANT_ID_HEADER_KEY = "X-Tenant-ID";
    public static final String LIMIT_QUERY_PARAM_KEY = "limit";

    @SuppressWarnings("java:S1075")
    public static final String DUMMY_URL_PATH = "/api/v1/dummy.*";
    public static final String EXAMPLE_PAN = "1234567890123456";
    public static final String EXAMPLE_AQRC = "5466C071B4E3BC0B";
    public static final String EXAMPLE_APP_CRYPTO_KEY_ID = "f3a010e3-110c-44fa-aaef-b6030ba76da0";
    public static final String EXAMPLE_ENCRYPTED_KEY_CHECK_VALUE = "4EAD23";

    /**
     * A pre-configured Gson instance that can be used in the quick start examples
     */
    static final Gson gson = JsonMappers.defaultGson();

    /**
     * The base path of the wiremock server to be called
     */
    static final String WIREMOCK_BASE_URI = "http://localhost:12681";

    /**
     * An example of a WiremockBodyPattern object that can be passed into the requests requiring criteria matchers.
     */
    static final BodyPattern EXAMPLE_BODY_PATTERN = BodyPatternEqualTo.builder()
            .equalToJson("{ \"someJsonProperty\": \"someJsonValue\"}")
            .build();

    /**
     * An example of a list of WiremockBodyPattern objects that can be passed into the requests requiring criteria
     * matchers.
     */
    static final List<BodyPattern> EXAMPLE_BODY_PATTERNS = Collections.singletonList(EXAMPLE_BODY_PATTERN);

    /**
     * An example of an Attribute Matcher object which is what is used to define query parameters or headers in the
     * request section of a stub mapping or criteria request. The Attribute Matcher can match in several ways: equalTo,
     * contains, matches, doesNotMatch - See the class for further details.
     */
    static final AttributeMatcher EXAMPLE_LIMIT_QUERY_PARAMETER = AttributeMatcher.builder().equalTo(String.valueOf(5))
            .build();

    /**
     * An example of a Map of query parameters that can be passed into the requests requiring criteria matchers.
     */
    static final Map<String, AttributeMatcher> EXAMPLE_QUERY_PARAMS = Stream.of(
                    new AbstractMap.SimpleEntry<>(LIMIT_QUERY_PARAM_KEY, EXAMPLE_LIMIT_QUERY_PARAMETER),
                    new AbstractMap.SimpleEntry<>("offset", AttributeMatcher.builder()
                            .equalTo(String.valueOf(1)).build()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    /**
     * An example of an Attribute Matcher object which is what is used to define query parameters or headers in the
     * request section of a stub mapping or criteria request. The Attribute Matcher can match in several ways: equalTo,
     * contains, matches, doesNotMatch - See the class for further details.
     */
    static final AttributeMatcher EXAMPLE_CONTENT_TYPE_HEADER = AttributeMatcher.builder()
            .equalTo(APPLICATION_JSON_HEADER_VALUE)
            .build();

    /**
     * An example of a Map of headers that can be passed into the requests requiring criteria matchers.
     */
    static final Map<String, AttributeMatcher> EXAMPLE_HEADERS = Stream.of(
                    new AbstractMap.SimpleEntry<>("Example-Header", AttributeMatcher.builder()
                            .equalTo("Some-Value").build()),
                    new AbstractMap.SimpleEntry<>(CONTENT_TYPE, EXAMPLE_CONTENT_TYPE_HEADER))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    /**
     * An example of a Map of headers that can be returned as part of the response section of a stub mapping.
     */
    static final Map<String, Object> EXAMPLE_RESPONSE_HEADERS = Stream.of(
                    new AbstractMap.SimpleEntry<>(X_CORRELATION_ID_HEADER_KEY, "3024374c-3df4-46a0-984d-b57ef294eb79"),
                    new AbstractMap.SimpleEntry<>(CONTENT_TYPE, APPLICATION_JSON_HEADER_VALUE))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private QuickStartWiremockExampleData() {
    }

    /**
     * Example of a method that can be used to build up the structures required to mock a request to the POST:
     * /security-commands endpoint. Uses the chaining ability that the objects provide, although setter methods can also
     * be used if that's preferred for verbosity. This example shows how an ARQC validation can be requested.
     *
     * @return An example {@link SecurityCommandRequestResource} object that can be passed into the dsl framework to
     * represent an expected request.
     */
    public static SecurityCommandRequestResource createSecurityCommandRequestResourceARQCValidation() {
        return new SecurityCommandRequestResource()
                .verifyArqcs(Collections.singletonList(
                                new VerifyArqcCommandRequestDto()
                                        .pan(EXAMPLE_PAN)
                                        .panSequenceNumber("00")
                                        .scheme(Scheme.EMV_OPTION_A_CKD_CSK.name())
                                        .arqc(EXAMPLE_AQRC)
                                        .atc("0001")
                                        .transactionData(
                                                "000000000001000000000000015600800460000156140701001E78E9BC7D00024003A04002")
                                        .applicationCryptogramKey(new ApplicationCryptogramKeyDto()
                                                .id(EXAMPLE_APP_CRYPTO_KEY_ID)
                                        )
                        )
                );
    }

    /**
     * Example of a method that can be used to build up the structures required to mock a request to the POST:
     * /security-commands endpoint. Uses the chaining ability that the objects provide, although setter methods can also
     * be used if that's preferred for verbosity. This example shows how an ARPC generation can be requested.
     *
     * @return An example {@link SecurityCommandRequestResource} object that can be passed into the dsl framework to
     * represent an expected request.
     */
    public static SecurityCommandRequestResource createSecurityCommandRequestResourceARPCGeneration() {
        return new SecurityCommandRequestResource()
                .generateArpcs(Collections.singletonList(
                                new GenerateArpcCommandRequestDto()
                                        .pan(EXAMPLE_PAN)
                                        .panSequenceNumber("00")
                                        .scheme(Scheme.EMV_OPTION_A_CKD_CSK.name())
                                        .method(Method.DPAS_METHOD_1.name())
                                        .applicationCryptogramKey(new ApplicationCryptogramKeyDto()
                                                .id(EXAMPLE_APP_CRYPTO_KEY_ID)
                                        )
                                        .arqc(EXAMPLE_AQRC)
                                        .atc("0001")
                                        .csu("0318")
                        )
                );
    }

    /**
     * Example of a method that can be used to build up the structures required to mock a request to the POST:
     * /security-commands endpoint. Uses the chaining ability that the objects provide, although setter methods can also
     * be used if that's preferred for verbosity. This example shows how a PIN encryption under a specific ZPK can be
     * requested.
     *
     * @return An example {@link SecurityCommandRequestResource} object that can be passed into the dsl framework to
     * represent an expected request.
     */
    public static SecurityCommandRequestResource createSecurityCommandRequestResourceZPK() {
        return new SecurityCommandRequestResource()
                .encryptPins(Arrays.asList(
                                new EncryptPinCommandRequestDto()
                                        .pan("588562348396417872")
                                        .pin("5889")
                                        .zonePinBlockFormat(ZonePinBlockFormatDto.ISO_ANSI_FORMAT_0.name())
                                        .zonePinKey(new ZonePinKeyDto()
                                                .id("011424fa-67e5-4d99-9176-1c5242860763")
                                        ),
                                new EncryptPinCommandRequestDto()
                                        .pan("12589674657947691")
                                        .pin("9093")
                                        .zonePinBlockFormat(ZonePinBlockFormatDto.ISO_ANSI_FORMAT_0.name())
                                        .zonePinKey(new ZonePinKeyDto()
                                                .id("67c17efb-c88a-4b4e-96d7-ba59931ce79a")
                                        ),
                                new EncryptPinCommandRequestDto()
                                        .pan("271208180562705602")
                                        .pin("1136")
                        )
                );
    }

    /**
     * Example of a method that can be used to build up the structures required to mock a response to a call to the
     * POST: /security-commands endpoint. Uses the chaining ability that the objects provide, although setter methods
     * can also be used if that's preferred for verbosity. This example shows how an ARQC validation can be responded
     * to.
     *
     * @return An example {@link SecurityCommandResponseResource} object that can be passed into the dsl framework to
     * represent the response.
     */
    public static SecurityCommandResponseResource createSecurityCommandResponseResourceARQCValidation() {
        return new SecurityCommandResponseResource()
                .verifyArqcs(Collections.singletonList(
                                new VerifyArqcCommandResponseDto()
                                        .pan(EXAMPLE_PAN)
                                        .panSequenceNumber("00")
                                        .scheme(Scheme.EMV_OPTION_A_CKD_CSK.name())
                                        .arqc(EXAMPLE_AQRC)
                                        .atc("0001")
                                        .transactionData(
                                                "000000000001000000000000015600800460000156140701001E78E9BC7D00024003A04002")
                                        .applicationCryptogramKey(new ApplicationCryptogramKeyDto()
                                                .id(EXAMPLE_APP_CRYPTO_KEY_ID)
                                        )
                                        .result("OK")
                        )
                );
    }

    /**
     * Example of a method that can be used to build up the structures required to mock a response to a call to the
     * POST: /security-commands endpoint. Uses the chaining ability that the objects provide, although setter methods
     * can also be used if that's preferred for verbosity. This example shows how an ARPC generation can be responded
     * to.
     *
     * @return An example {@link SecurityCommandResponseResource} object that can be passed into the dsl framework to
     * represent the response.
     */
    public static SecurityCommandResponseResource createSecurityCommandResponseResourceARPCGeneration() {
        return new SecurityCommandResponseResource()
                .generateArpcs(Collections.singletonList(
                                new GenerateArpcCommandResponseDto()
                                        .pan(EXAMPLE_PAN)
                                        .panSequenceNumber("00")
                                        .scheme(Scheme.EMV_OPTION_A_CKD_CSK.name())
                                        .method(Method.DPAS_METHOD_1.name())
                                        .applicationCryptogramKey(new ApplicationCryptogramKeyDto()
                                                .id(EXAMPLE_APP_CRYPTO_KEY_ID)
                                        )
                                        .arqc(EXAMPLE_AQRC)
                                        .atc("0001")
                                        .csu("0318")
                                        .arpc("ADE43F70189C61A3")
                        )
                );
    }

    /**
     * Example of a method that can be used to build up the structures required to mock a response to a call to the
     * POST: /security-commands endpoint. Uses the chaining ability that the objects provide, although setter methods
     * can also be used if that's preferred for verbosity. This example shows how a PIN encryption under a specific ZPK
     * can be responded to.
     *
     * @return An example {@link SecurityCommandResponseResource} object that can be passed into the dsl framework to
     * represent the response.
     */
    public static SecurityCommandResponseResource createSecurityCommandResponseResourceZPK() {
        return new SecurityCommandResponseResource()
                .encryptPins(Arrays.asList(
                                new EncryptPinCommandResponseDto()
                                        .pinBlock("91346")
                                        .pin("5889")
                                        .pan("588562348396417872")
                                        .zonePinBlockFormat(ZonePinBlockFormatDto.ISO_ANSI_FORMAT_0.name())
                                        .zonePinKey(new ZonePinKeyDto()
                                                .id("011424fa-67e5-4d99-9176-1c5242860763")
                                        )
                                        .zonePinBlock("CAA1371918980D03"),
                                new EncryptPinCommandResponseDto()
                                        .pinBlock("02046")
                                        .pin("9093")
                                        .pan("12589674657947691")
                                        .zonePinBlockFormat(ZonePinBlockFormatDto.ISO_ANSI_FORMAT_0.name())
                                        .zonePinKey(new ZonePinKeyDto()
                                                .id("67c17efb-c88a-4b4e-96d7-ba59931ce79a")
                                        )
                                        .zonePinBlock("07032D0D0FD52F16"),
                                new EncryptPinCommandResponseDto()
                                        .pinBlock("77551")
                                        .pin("1136")
                                        .pan("271208180562705602")
                        )
                );
    }

    /**
     * Example of a method that can be used to build up the structures required to mock a response to a call to the GET:
     * /encryption-cases endpoint. Uses the chaining ability that the objects provide, although setter methods can also
     * be used if that's preferred for verbosity.
     *
     * @return An example {@link PagedResult<EncryptionKeyResponseResource>} object that can be passed into the dsl
     * framework to represent the response.
     */
    static PagedResult<EncryptionKeyResponseResource> getEncryptionKeysPagedResultResponse() {
        PagedResult<EncryptionKeyResponseResource> accountPagedResult = new PagedResult<>();
        accountPagedResult.offset(0L);
        accountPagedResult.limit(100L);
        accountPagedResult.hasNext(false);
        accountPagedResult.items(Arrays.asList(
                new EncryptionKeyResponseResource()
                        .id("ddd3197c-bb42-4307-94d9-2a5694492631")
                        .audit(new AuditDto()
                                .createdDateTime(Instant.now().toString())
                                .updatedDateTime(Instant.now().toString()))
                        .code("hsmCvkKeys")
                        .index(0)
                        .name("Magstripe CVC")
                        .description("Card verification key")
                        .status(StatusDto.ACTIVE)
                        .scope(new ScopeDto()
                                .zone("Card")
                                .group("CVK"))
                        .type(TypeDto.CVK)
                        .algorithm("2DES")
                        .encryptedKeyValue(new EncryptedKeyValueDto()
                                .checkValue(EXAMPLE_ENCRYPTED_KEY_CHECK_VALUE)),
                new EncryptionKeyResponseResource()
                        .id("ddd3197c-bb42-4307-94d9-2a5694492632")
                        .audit(new AuditDto()
                                .createdDateTime(Instant.now().toString())
                                .updatedDateTime(Instant.now().toString()))
                        .code("hsmChipCvkKeys")
                        .index(0)
                        .name("Chip CVC")
                        .description("Card verification key")
                        .status(StatusDto.ACTIVE)
                        .scope(new ScopeDto()
                                .zone("Card")
                                .group("CVK"))
                        .type(TypeDto.CVK)
                        .algorithm("2DES")
                        .encryptedKeyValue(new EncryptedKeyValueDto()
                                .checkValue(EXAMPLE_ENCRYPTED_KEY_CHECK_VALUE)),
                new EncryptionKeyResponseResource()
                        .id("fff3197c-bb42-4307-94d9-2a5645492613")
                        .audit(new AuditDto()
                                .createdDateTime(Instant.now().toString())
                                .updatedDateTime(Instant.now().toString()))
                        .code("PANKey")
                        .index(0)
                        .name("Zek")
                        .description("Encryption key")
                        .status(StatusDto.ACTIVE)
                        .scope(new ScopeDto()
                                .zone("AccountManagement")
                                .group("Encryption"))
                        .type(TypeDto.ZEK)
                        .algorithm("3DES")
                        .encryptedKeyValue(new EncryptedKeyValueDto()
                                .checkValue("62D017")
                                .managementKey(new ManagementKeyDto()
                                        .id("c3be4b32-fe86-473d-9166-da1d77a4a96b"))),
                new EncryptionKeyResponseResource()
                        .id("4b5a2016-4d75-4229-9f1d-6eac4b548663")
                        .audit(new AuditDto()
                                .createdDateTime(Instant.now().toString())
                                .updatedDateTime(Instant.now().toString()))
                        .code("hsmChipCvkKeys")
                        .index(0)
                        .name("PVK")
                        .description("Pin verification key")
                        .status(StatusDto.ACTIVE)
                        .scope(new ScopeDto()
                                .zone("AccountManagement")
                                .group("Fulfilment"))
                        .type(TypeDto.PVK)
                        .algorithm("2DES")
                        .encryptedKeyValue(new EncryptedKeyValueDto()
                                .checkValue(EXAMPLE_ENCRYPTED_KEY_CHECK_VALUE))
        ));

        return accountPagedResult;
    }

    /**
     * Builds an example PPS styled error response object to demonstrate the kind of response returned when mocking an
     * error.
     *
     * @return A PPS styled ErrorResponse object
     */
    static ErrorResponse exampleBadRequestResponse() {
        return ErrorResponse.builder()
                .code("BAD_REQUEST")
                .message("Pan should be between 12 and 19 characters long.")
                .build();
    }

    /**
     * This class is purely here for demo purposes for examples in QuickStartWiremock. This is not to be used for
     * anything else.
     */
    @Data
    @Accessors(fluent = true)
    public static class SomeClass {

        @SerializedName("someStringProperty")
        private String someStringProperty;

        @SerializedName("someIntProperty")
        private int someIntProperty;

    }

}
