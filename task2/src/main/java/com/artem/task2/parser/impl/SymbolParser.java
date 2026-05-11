package com.artem.task2.parser.impl;

import com.artem.task2.entity.*;
import com.artem.task2.exception.TextParseException;
import com.artem.task2.parser.AbstractParser;

public class SymbolParser extends AbstractParser {

    @Override
    public void parse(String content, TextComponent parent) throws TextParseException {

        if (content == null) {
            throw new TextParseException("Input text is null");
        }

        if (parent == null) {
            throw new TextParseException("Parent component is null");
        }

        for (char c : content.toCharArray()) {
            parent.add(new Symbol(c));
        }
    }
}