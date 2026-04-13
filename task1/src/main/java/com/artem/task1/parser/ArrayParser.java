package com.artem.task1.parser;

public class ArrayParser {

    public int[] parse(String line) {
        String cleaned = line.replaceAll("[,;\\-]", " ");
        String strippedLine = cleaned.strip();
        String[] tokens = strippedLine.split("\\s+");

        int[] result = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }

        return result;
    }
}