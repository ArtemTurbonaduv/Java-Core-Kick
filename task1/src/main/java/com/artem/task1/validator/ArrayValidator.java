package com.artem.task1.validator;

import java.util.regex.Pattern;

public class ArrayValidator {

    private static final String REGEX = "^\\s*-?\\d+(\\s*[,;\\-]\\s*-?\\d+)*\\s*$";

    public boolean isValid(String line) {
        if (line == null || line.isBlank()) {
            return false;
        }
        return Pattern.matches(REGEX, line);
    }
}