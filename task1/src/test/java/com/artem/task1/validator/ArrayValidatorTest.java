package com.artem.task1.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayValidatorTest {
    private static final String VALID_LINE = "1; 2 - -4, 8";
    private static final String INVALID_LINE = "1 _ 2p, 4, 8";

    private final ArrayValidator arrayValidator = new ArrayValidator();

    @Test
    void isValidPositive() {
        boolean result = arrayValidator.isValid(VALID_LINE);

        assertTrue(result);
    }

    @Test
    void isValidNegative() {
        boolean result = arrayValidator.isValid(INVALID_LINE);

        assertFalse(result);
    }
}
