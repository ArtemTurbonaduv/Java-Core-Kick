package com.artem.task1.parser.impl;

import com.artem.task1.parser.ArrayParser;

import java.util.Arrays;

public class ArrayParserImpl implements ArrayParser {
    private static final String DELIMITER_LINE_REGEX = "[,;\\s]+";

    @Override
    public int[] parse(String line) {
        if (line == null || line.isBlank()) {
            return new int[0];
        }

        String[] tokens = line.strip().split(DELIMITER_LINE_REGEX);

        int[] result = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }
}