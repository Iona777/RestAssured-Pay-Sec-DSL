package com.pps.dsl.paymentsecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * The encryption algorithm for the key.
 *
 * @author cedmunds
 * @version 1.2.0
 * @since 1.2.0
 */
@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public enum Algorithm {
    TWO_DES("2DES"), THREE_DES("3DES");

    String algorithmType;

}
