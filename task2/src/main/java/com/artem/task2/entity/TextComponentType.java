package com.artem.task2.entity;

public enum TextComponentType {
    TEXT("\n"),
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(""),
    SYMBOL(""),
    LETTER(""),
    PUNCTUATION("");

    private final String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
