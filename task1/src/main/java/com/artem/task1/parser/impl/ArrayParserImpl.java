package com.artem.task1.parser.impl;

import com.artem.task1.parser.ArrayParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {
    private static final Logger logger = LogManager.getLogger(ArrayParserImpl.class);
    private static final String DELIMITER_LINE_REGEX = "[,;\\s]+";

    @Override
    public int[] parse(String line) {
        logger.info("Parsing line: {}", line);

        if (line == null || line.isBlank()) {
            logger.warn("Line is null or blank, returning empty array");
            return new int[0];
        }

        String[] tokens = line.strip().split(DELIMITER_LINE_REGEX);
        logger.info("Split into {} tokens", tokens.length);

        int[] result = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
            logger.debug("Parsed token[{}]: {} -> {}", i, tokens[i], result[i]);
        }

        logger.info("Parsing completed, array length: {}", result.length);
        return result;
    }
}