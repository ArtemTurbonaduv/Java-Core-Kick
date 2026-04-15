package com.artem.task1.validator;

public class ArrayValidator {

    private static final String REGEX = "^\\s*-?\\d+(\\s*[,;\\-]\\s*-?\\d+)*\\s*$";

    public boolean isValid(String line) {
        if (line == null || line.isBlank()) {
            return false;
        }
        return line.matches(REGEX);
    }
}