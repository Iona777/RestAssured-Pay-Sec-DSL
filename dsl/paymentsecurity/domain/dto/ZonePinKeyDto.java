package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * The zone PIN key.
 *
 * @author vradulescu, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class ZonePinKeyDto {

    /**
     * The unique id of a cryptographic key.
     */
    private String id;

}
