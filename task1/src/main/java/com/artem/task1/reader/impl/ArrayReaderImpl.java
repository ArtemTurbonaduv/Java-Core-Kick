package com.artem.task1.reader.impl;

import com.artem.task1.exception.ArrayException;
import com.artem.task1.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    private static final Logger logger = LogManager.getLogger(ArrayReaderImpl.class);

    @Override
    public List<String> readLines(String path) throws ArrayException {
        logger.info("Reading file from path: {}", path);

        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            logger.info("Successfully read {} lines from file: {}", lines.size(), path);
            return lines;
        } catch (IOException e) {
            logger.error("Error reading file: {}", path, e);
            throw new ArrayException("Error reading file", e);
        }
    }
}