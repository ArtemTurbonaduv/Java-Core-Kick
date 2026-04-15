package com.artem.task1.reader;

import com.artem.task1.exception.ArrayException;

import java.util.List;

public interface ArrayReader {
    public List<String> readLines(String path) throws ArrayException;
}
