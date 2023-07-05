package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Further limitations on the usage of the encryption key.
 *
 * @author vradulescu, gmacdonald, cedmunds
 * @version 1.2.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class ScopeDto {

    /**
     * Zone in which the encryption key may be used.
     */
    private String zone;

    /**
     * A predefined group for the key. For example each fulfilment house with which secure data is exchanged might have
     * a specific group.
     */
    private String group;

    /**
     * Bank Identifier Number (first 6 digits) and up to 2 further digits (segments) of the PAN for which the key is
     * applicable.
     */
    private String bin;

}
