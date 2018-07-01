package com.mycompany.app.frj.app.password.models;

import lombok.Builder;
import lombok.Data;

/**
 * Internal model of fields that will be used/encoded into a password hashing result.
 *
 * @author alecva
 */
@Data
@Builder(toBuilder = true)
public class PasswordHashParams {
    private final AlgorithmType algorithm;
    private final int iterations;
    private final int hashLength;
    private final byte[] salt;
    private final byte[] hash;
}
