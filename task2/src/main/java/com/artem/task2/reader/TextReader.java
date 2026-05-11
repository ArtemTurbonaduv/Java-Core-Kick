package com.artem.task2.reader;

import com.artem.task2.exception.TextParseException;

public interface TextReader {
    String readFile(String path) throws TextParseException;
}
