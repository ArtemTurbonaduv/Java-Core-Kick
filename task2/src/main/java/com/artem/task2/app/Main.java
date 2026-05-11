package com.artem.task2.app;

import com.artem.task2.entity.*;
import com.artem.task2.exception.TextParseException;
import com.artem.task2.parser.*;
import com.artem.task2.parser.impl.*;
import com.artem.task2.reader.TextReader;
import com.artem.task2.service.TextAnalyseService;
import com.artem.task2.service.TextOperationService;
import com.artem.task2.reader.impl.TextReaderImpl;
import java.util.List;

public class Main {
    static void main() throws TextParseException {
        try {
            TextComponent root = getTextComponent();

            System.out.println("===== RESTORED TEXT =====");
            System.out.println(root.toString());
            System.out.println();

            TextAnalyseService analyse = new TextAnalyseService();
            TextOperationService operation = new TextOperationService();

            int letters = analyse.countLetters(root);
            int symbols = analyse.countSymbols(root);

            System.out.println("===== ANALYSIS =====");
            System.out.println("Letters: " + letters);
            System.out.println("Symbols: " + symbols);
            System.out.println();

            int max = operation.maxSentencesWithSameWords(root);

            System.out.println("===== TASK 1 =====");
            System.out.println("Max sentences with same word: " + max);
            System.out.println();

            System.out.println("===== TASK 2 (sorted by 'a') =====");

            List<TextComponent> sorted = operation.sortSentencesByLetter(root, 'a');

            for (TextComponent s : sorted) {
                System.out.println(s.toString());
            }

            System.out.println();

            operation.swapFirstLastLexemes(root);

            System.out.println("===== TASK 3 (swap lexemes) =====");
            System.out.println(root.toString());

        } catch (TextParseException e) {
            throw new TextParseException("Error in main");
        }
    }

    private static TextComponent getTextComponent() throws TextParseException {
        TextReader reader = new TextReaderImpl();
        String text = reader.readFile("data/Input.txt");
        TextComponent root = new TextComposite(TextComponentType.TEXT);

        TextParser paragraphParser = new ParagraphParser();
        TextParser sentenceParser = new SentenceParser();
        TextParser lexemeParser = new LexemeParser();
        TextParser symbolParser = new SymbolParser();

        paragraphParser.setNext(sentenceParser);
        sentenceParser.setNext(lexemeParser);
        lexemeParser.setNext(symbolParser);

        paragraphParser.parse(text, root);
        return root;
    }
}