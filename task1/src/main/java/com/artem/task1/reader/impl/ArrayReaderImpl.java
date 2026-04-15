package com.artem.task1.reader.impl;

import com.artem.task1.exception.ArrayException;
import com.artem.task1.reader.ArrayReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {

    @Override
    public List<String> readLines(String path) throws ArrayException {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new ArrayException("Error reading file");
        }
    }
}