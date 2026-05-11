package com.artem.task2.parser.impl;

import com.artem.task2.entity.TextComponent;
import com.artem.task2.entity.TextComponentType;
import com.artem.task2.entity.TextComposite;
import com.artem.task2.exception.TextParseException;
import com.artem.task2.parser.AbstractParser;

public class ParagraphParser extends AbstractParser {
    public static final String PARAGRAPH = "\\n+";

    @Override
    public void parse(String content, TextComponent parent) throws TextParseException {
        if (content == null || content.isBlank()) {
            throw new TextParseException("Text is null");
        }

        try {
            String[] paragraphs = content.split(PARAGRAPH);

            for (String p : paragraphs) {
                TextComponent paragraph = new TextComposite(TextComponentType.PARAGRAPH);
                parent.add(paragraph);

                if (next != null) {
                    next.parse(p.trim(), paragraph);
                }
            }

        } catch (TextParseException e) {
            throw new TextParseException("Error parsing text", e);
        }
    }
}