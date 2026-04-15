package com.artem.task1.reader;

import com.artem.task1.reader.impl.ArrayReaderImpl;
import com.artem.task1.exception.ArrayException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ArrayReaderTest {
    private static final String VALID_PATH = "data/input.txt";
    private static final String INVALID_PATH = "data/invalid.txt";

    private final ArrayReaderImpl arrayReader = new ArrayReaderImpl();

    @Test
    void readLinesPositive() throws ArrayException {
        List<String> lines = arrayReader.readLines(VALID_PATH);

        assertAll(
                ()->assertNotNull(lines),
                ()->assertFalse(lines.isEmpty())
        );
    }

    @Test
    void readLinesNegative() {
        assertThrows(ArrayException.class, ()->arrayReader.readLines(INVALID_PATH));
    }
}

