package com.artem.task1.validator;

public class ArrayValidator {

    private static final String ARRAY_INPUT_REGEX = "^\\s*-?\\d+(\\s*[,;\\-]\\s*-?\\d+)*\\s*$";

    public boolean isValid(String line) {
        if (line == null || line.isBlank()) {
            return false;
        }
        return line.matches(ARRAY_INPUT_REGEX);
    }
}