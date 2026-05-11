package com.artem.task2.service;

import com.artem.task2.entity.*;

public class TextAnalyseService {

    public int countLetters(TextComponent component) {
        int count = 0;

        if (component.getType() == TextComponentType.LETTER) {
            return 1;
        }
        else if (component.getType() == TextComponentType.PUNCTUATION) {
            return 0;
        }

        for (TextComponent child : component.getChildren()) {
            count += countLetters(child);
        }

        return count;
    }

    public int countSymbols(TextComponent component) {
        int count = 0;

        if (component.getType() == TextComponentType.LETTER
                || component.getType() == TextComponentType.PUNCTUATION) {
            return 1;
        }

        for (TextComponent child : component.getChildren()) {
            count += countSymbols(child);
        }

        return count;
    }
}