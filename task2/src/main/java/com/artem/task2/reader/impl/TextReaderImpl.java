package com.artem.task2.reader.impl;

import com.artem.task2.exception.TextParseException;
import com.artem.task2.reader.TextReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReaderImpl implements TextReader {
    public String readFile(String path) throws TextParseException {
        try {
            return Files.readString(Path.of(path));

        } catch (IOException e) {
            throw new TextParseException("Cannot read file", e);
        }
    }
}
