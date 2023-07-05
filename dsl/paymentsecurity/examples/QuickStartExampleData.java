package com.pps.dsl.paymentsecurity.examples;

import com.pps.dsl.paymentsecurity.domain.EncryptionKeyRequestResource;
import com.pps.dsl.paymentsecurity.domain.SecurityCommandRequestResource;
import com.pps.dsl.paymentsecurity.domain.dto.ApplicationCryptogramKeyDto;
import com.pps.dsl.paymentsecurity.domain.dto.EncryptedKeyValueDto;
import com.pps.dsl.paymentsecurity.domain.dto.ManagementKeyDto;
import com.pps.dsl.paymentsecurity.domain.dto.ScopeDto;
import com.pps.dsl.paymentsecurity.domain.dto.TypeDto;
import com.pps.dsl.paymentsecurity.domain.dto.ZonePinKeyDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.EncryptPinCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.GenerateArpcCommandRequestDto;
import com.pps.dsl.paymentsecurity.domain.dto.request.VerifyArqcCommandRequestDto;
import java.util.Arrays;
import java.util.Collections;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class QuickStartExampleData {

    /**
     * The base path of the Screening application to be called
     */
    public static final String APP_BASE_URI = "http://localhost:11681";


    /**
     * Constants that are re-used in several places
     */
    static final String EXAMPLE_X_CORRELATION_ID = "EXAMPLE_CORRELATION_ID";
    static final String EXAMPLE_X_REQUEST_ID = "abcd1234-abcd-1234-abcd-abcdef123456";
    static final String EXAMPLE_X_TENANT_ID = "1234567890";
    static final String EXAMPLE_AUTHORISATION_HEADER = "Bearer token";
    static final String EXAMPLE_QUERY_PARAM = "encrypted_key_value";
    static final String EXAMPLE_ENCRYPTION_ID = "dfc136f9-b912-4b91-857f-8497a6aef1ce";

    static final String EXAMPLE_PAN = "5090000000158100";
    static final String EXAMPLE_ZPK = "ZPK_ID_1";
    static final String EXAMPLE_ZONE_PIN_BLOCK_FORMAT = "ISO_FORMAT_1";
    static final String EXAMPLE_CONTENT_TYPE = "application/json; charset=utf-8";
    private static final String EXAMPLE_PAN_SEQUENCE_NO = "00";
    private static final String EXAMPLE_SCHEME = "EMV_OPTION_A_CKD_CSK";
    private static final String EXAMPLE_METHOD = "DPAS_METHOD_1";
    private static final String EXAMPLE_AC_KEY_ID = "011424fa-67e5-4d99-9176-1c5242860763";
    private static final String EXAMPLE_ARQC = "4982EFAFBFDDF4D0";
    private static final String EXAMPLE_ATC = "002E";
    private static final String EXAMPLE_CSU = "0123";
    private static final String EXAMPLE_TRANSACTION_DATA = "0000000021000000000000000076208004E0000986221229000BABDDCA7900002E0105A000030000000100100000000000";


    /**
     * Example of a method that can be used to build up the structures required for a POST:/security-commands call for
     * generating ARPC. Uses the chaining ability that the objects provide, although setter methods can also be used if
     * that's preferred for verbosity.
     * <p>
     * Creates a {@link SecurityCommandRequestResource} object populated with a single Generate Arpc command request
     * with default values
     */
    static SecurityCommandRequestResource createSecurityCommandRequestResourceGenerateArpc() {
        return new SecurityCommandRequestResource()
                .generateArpcs(Arrays.asList(
                        new GenerateArpcCommandRequestDto()
                                .pan(EXAMPLE_PAN)
                                .panSequenceNumber(EXAMPLE_PAN_SEQUENCE_NO)
                                .scheme(EXAMPLE_SCHEME)
                                .method(EXAMPLE_METHOD)
                                .applicationCryptogramKey(new ApplicationCryptogramKeyDto().id(EXAMPLE_AC_KEY_ID))
                                .arqc(EXAMPLE_ARQC)
                                .atc(EXAMPLE_ATC)
                                .csu(EXAMPLE_CSU)
                ));
    }

    /**
     * Example of a method that can be used to build up the structures required for a POST:/security-commands call for
     * verifying ARPC. Uses the chaining ability that the objects provide, although setter methods can also be used if
     * that's preferred for verbosity.
     * <p>
     * Creates a {@link SecurityCommandRequestResource} object populated with a single Verify Arqc command request with
     * default values
     */
    static SecurityCommandRequestResource createSecurityCommandRequestResourceVerifyArqc() {
        return new SecurityCommandRequestResource()
                .verifyArqcs(Arrays.asList(
                        new VerifyArqcCommandRequestDto()
                                .pan(EXAMPLE_PAN)
                                .panSequenceNumber(EXAMPLE_PAN_SEQUENCE_NO)
                                .scheme(EXAMPLE_SCHEME)
                                .applicationCryptogramKey(new ApplicationCryptogramKeyDto().id(EXAMPLE_AC_KEY_ID))
                                .arqc(EXAMPLE_ARQC)
                                .atc(EXAMPLE_ATC)
                                .transactionData(EXAMPLE_TRANSACTION_DATA)

                ));
    }

    /**
     * Example of a method that can be used to build up the structures required for a POST:/security-commands call for
     * verifying ARPC with ARPC generation. Uses the chaining ability that the objects provide, although setter methods
     * can also be used if that's preferred for verbosity.
     * <p>
     * Creates a {@link SecurityCommandRequestResource} object populated with a single Verify Arqc command request with
     * Arpc generation and default values
     */

    public static SecurityCommandRequestResource createSecurityCommandRequestResourceVerifyArqcWithArpcGeneration() {
        return new SecurityCommandRequestResource()
                .verifyArqcs(Arrays.asList(
                        new VerifyArqcCommandRequestDto()
                                .pan(EXAMPLE_PAN)
                                .panSequenceNumber(EXAMPLE_PAN_SEQUENCE_NO)
                                .scheme(EXAMPLE_SCHEME)
                                .applicationCryptogramKey(new ApplicationCryptogramKeyDto().id(EXAMPLE_AC_KEY_ID))
                                .arqc(EXAMPLE_ARQC)
                                .atc(EXAMPLE_ATC)
                                .transactionData(EXAMPLE_TRANSACTION_DATA)
                                .arpcGeneration(EXAMPLE_METHOD)
                                .csu(EXAMPLE_CSU)
                ));
    }


    /**
     * /** * Example of a method that can be used to build up the structures required for a POST:/security-commands call
     * * for encrypting pin. Uses the chaining ability that the objects provide, although setter methods can also be *
     * used if that's preferred for verbosity.
     * <p>
     * Creates a {@link SecurityCommandRequestResource} object populated with a single pin encryption command request.
     *
     * @param zpk                The unique ID of a cryptographic key for this zone PIN key.
     * @param zonePinBlockFormat The PIN block format for the zone.
     * @param includePan         Boolean flag to determine whether a pan should be included in the request.
     */
    public static SecurityCommandRequestResource createEncryptCardPinRequest(String zpk, String zonePinBlockFormat,
            boolean includePan) {
        String randomPan = "123456789123456";
        String randomPin = "1234";

        EncryptPinCommandRequestDto encryptPinCommandRequest
                = createEncryptPinCommandRequest(randomPin, zonePinBlockFormat, zpk);

        if (includePan) {
            encryptPinCommandRequest = createEncryptPinCommandRequest(randomPan, randomPin, zonePinBlockFormat, zpk);
        }

        return new SecurityCommandRequestResource()
                .encryptPins(Collections.singletonList(encryptPinCommandRequest));
    }


    /**
     * An example method that creates a {@link EncryptPinCommandRequestDto} object with the given input values.
     *
     * @param pin                The card PIN value to add to the request.
     * @param zonePinBlockFormat The PIN block format for the zone.
     * @param zpk                The unique ID of a cryptographic key for this zone PIN key.
     * @return A Payment Security {@link EncryptPinCommandRequestDto} object.
     */
    public static EncryptPinCommandRequestDto createEncryptPinCommandRequest(String pin, String zonePinBlockFormat,
            String zpk) {
        return new EncryptPinCommandRequestDto()
                .pin(pin)
                .zonePinBlockFormat(zonePinBlockFormat)
                .zonePinKey(new ZonePinKeyDto().id(zpk));
    }

    /**
     * An example method that creates a {@link EncryptPinCommandRequestDto} object with the given input values.
     *
     * @param pan                The card pan value to add to the request.
     * @param pin                The card PIN value to add to the request.
     * @param zonePinBlockFormat The PIN block format for the zone.
     * @param zpk                The unique ID of a cryptographic key for this zone PIN key.
     * @return A Payment Security {@link EncryptPinCommandRequestDto} object.
     */
    public static EncryptPinCommandRequestDto createEncryptPinCommandRequest(String pan, String pin,
            String zonePinBlockFormat,
            String zpk) {
        return new EncryptPinCommandRequestDto()
                .pan(pan)
                .pin(pin)
                .zonePinBlockFormat(zonePinBlockFormat)
                .zonePinKey(new ZonePinKeyDto().id(zpk));
    }


    public static EncryptionKeyRequestResource createEncryptionKeyOnlyVariantResource() {
        return createEncryptionKeyNoManagementNoValue()
                .scope(createScope().zone("ServicePlatform"))
                .encryptedKeyValue(createEncryptedKeyValueVariantOnly());
    }

    private static EncryptedKeyValueDto createEncryptedKeyValueVariantOnly() {
        return createEncryptedKeyNoValue()
                .variantValue("TCB7460529E808315D8BA45E7E0683A10ED351895E5DF0533")
                .checkValue("62D017");
    }

    private static EncryptedKeyValueDto createEncryptedKeyNoValue() {
        return new EncryptedKeyValueDto()
                .managementKey(new ManagementKeyDto().id("c3be4b32-fe86-473d-9166-da1d77a4a96b"));
    }

    public static EncryptionKeyRequestResource createEncryptionKeyNoManagementNoValue() {
        return new EncryptionKeyRequestResource()
                .code("PanKey")
                .index(1l)
                .name("Pan Encryption Key")
                .description("Pan key rotation as per CM-XXXX")
                .scope(createScope())
                .type(TypeDto.ZEK)
                .algorithm("3DES");
    }

    private static ScopeDto createScope() {
        return new ScopeDto().zone("PACASSO")
                .group("Card Keys")
                .bin("665542");
    }


}
