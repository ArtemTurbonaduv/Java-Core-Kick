package com.artem.task2.parser;

import com.artem.task2.entity.TextComponent;
import com.artem.task2.exception.TextParseException;

public interface TextParser {

    void setNext(TextParser next);

    void parse(String text, TextComponent parent) throws TextParseException;
}