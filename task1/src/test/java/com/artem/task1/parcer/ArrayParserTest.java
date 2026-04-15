package com.artem.task1.parcer;

import com.artem.task1.parser.ArrayParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayParserTest {
    private static final String INPUT_STRING = "1 - -2, 4; -8";
    private static final int[] expectedArray = {1, 2, 4, 8};

    private final ArrayParser arrayParser = new ArrayParser();

    @Test
    void parsePositive() {
        int[] result = arrayParser.parse(INPUT_STRING);

        assertArrayEquals(expectedArray, result);
    }
}
