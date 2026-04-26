package com.artem.task1.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidator {
    private static final Logger logger = LogManager.getLogger(ArrayValidator.class);
    private static final String ARRAY_INPUT_REGEX = "^\\s*-?\\d+(\\s*[,;\\-]?\\s*-?\\d+)*\\s*$";

    public boolean isValid(String line) {
        logger.info("Validating line: {}", line);
        boolean valid = line != null && !line.isBlank() && line.matches(ARRAY_INPUT_REGEX);
        logger.info("Validation result: {}", valid);
        return valid;
    }
}