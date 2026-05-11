package com.artem.task2.parser.impl;

import com.artem.task2.entity.TextComponent;
import com.artem.task2.entity.TextComponentType;
import com.artem.task2.entity.TextComposite;
import com.artem.task2.exception.TextParseException;
import com.artem.task2.parser.AbstractParser;

public class LexemeParser extends AbstractParser {
    public static final String SPACE = "\\s+";

    @Override
    public void parse(String content, TextComponent parent) throws TextParseException {
        try {
            String[] lexemes = content.split(SPACE);
            for (String lex : lexemes) {
                TextComponent lexeme = new TextComposite(TextComponentType.LEXEME);
                parent.add(lexeme);

                if (next != null) {
                    next.parse(lex, lexeme);
                }
            }

        } catch (TextParseException e) {
            throw new TextParseException("Error parsing text", e);
        }
    }
}