package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The unique id of the cryptographic key to use for the command. The key must be of type ZEK.
 *
 * @author vradulescu, nong, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class ApplicationCryptogramKeyDto {

    /**
     * The unique id of a cryptographic key.
     */
    private String id;

}
