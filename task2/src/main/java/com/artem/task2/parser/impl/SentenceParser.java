package com.artem.task2.parser.impl;

import com.artem.task2.entity.TextComponent;
import com.artem.task2.entity.TextComponentType;
import com.artem.task2.entity.TextComposite;
import com.artem.task2.exception.TextParseException;
import com.artem.task2.parser.AbstractParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    public static final String SENTENCE = "[^.!?]+[.!?]";

    @Override
    public void parse(String content, TextComponent parent) throws TextParseException {
        try {
            Pattern pattern = Pattern.compile(SENTENCE);
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                String sentenceText = matcher.group();

                TextComponent sentence = new TextComposite(TextComponentType.SENTENCE);
                parent.add(sentence);

                if (next != null) {
                    next.parse(sentenceText.trim(), sentence);
                }
            }

        } catch (TextParseException e) {
            throw new TextParseException("Error parsing text", e);
        }
    }
}