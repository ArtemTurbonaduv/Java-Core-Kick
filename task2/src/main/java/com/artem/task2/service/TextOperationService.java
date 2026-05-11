package com.artem.task2.service;

import com.artem.task2.entity.TextComponentType;
import com.artem.task2.entity.Symbol;
import com.artem.task2.entity.TextComponent;

import java.util.*;

public class TextOperationService {

    public int maxSentencesWithSameWords(TextComponent root) {

        Map<String, Integer> wordCount = new HashMap<>();

        for (TextComponent paragraph : root.getChildren()) {
            for (TextComponent sentence : paragraph.getChildren()) {

                Set<String> wordsInSentence = new HashSet<>();
                for (TextComponent lexeme : sentence.getChildren()) {

                    String word = extractWord(lexeme);
                    if (!word.isEmpty()) {
                        wordsInSentence.add(word.toLowerCase());
                    }
                }
                for (String word : wordsInSentence) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        int max = 0;
        for (int count : wordCount.values()) {
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    public List<TextComponent> sortSentencesByLetter(TextComponent root, char letter) {

        List<TextComponent> sentences = new ArrayList<>();
        for (TextComponent paragraph : root.getChildren()) {
            sentences.addAll(paragraph.getChildren());
        }

        sentences.sort(Comparator.comparingInt(s -> countLetterInSentence(s, letter)));
        return sentences;
    }

    public void swapFirstLastLexemes(TextComponent root) {

        for (TextComponent paragraph : root.getChildren()) {
            for (TextComponent sentence : paragraph.getChildren()) {

                List<TextComponent> lexemes = sentence.getChildren();
                if (lexemes.size() < 2) {
                    continue;
                }

                int lastIndex = lexemes.size() - 1;
                TextComponent first = lexemes.getFirst();
                TextComponent last = lexemes.get(lastIndex);
                // swap
                lexemes.set(0, last);
                lexemes.set(lastIndex, first);
            }
        }
    }

    private String extractWord(TextComponent lexeme) {

        StringBuilder sb = new StringBuilder();

        for (TextComponent sym : lexeme.getChildren()) {
            Symbol s = (Symbol) sym;

            if (s.getType() == TextComponentType.LETTER) {
                sb.append(s.getSymbol());
            }
        }

        return sb.toString();
    }

    private int countLetterInSentence(TextComponent sentence, char letter) {

        int count = 0;
        char target = Character.toLowerCase(letter);

        for (TextComponent lexeme : sentence.getChildren()) {
            for (TextComponent sym : lexeme.getChildren()) {

                Symbol s = (Symbol) sym;

                if (s.getType() == TextComponentType.LETTER) {

                    char c = Character.toLowerCase(s.getSymbol());

                    if (c == target) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}