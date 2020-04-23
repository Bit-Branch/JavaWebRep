package by.epam.ih.parser.impl;

import by.epam.ih.composite.Component;
import by.epam.ih.composite.Composite;
import by.epam.ih.composite.SentenceToken;
import by.epam.ih.composite.Symbol;
import by.epam.ih.exception.NoSuchOperationException;
import by.epam.ih.parser.AbstractParser;

public class WordParser implements AbstractParser {
    private final String WORD_PATTERN = " ";
    private static WordParser instance = new WordParser();

    public static WordParser getInstance() {
        return instance;
    }

    @Override
    public Component parse(String text) {
        Component components = new Composite(SentenceToken.WORD);
        String[] words = text.split(WORD_PATTERN);
        for (String word : words) {
            if (word.length() > 0) {
                try {
                    components.add(new Symbol(word,SentenceToken.WORD));
                } catch (NoSuchOperationException e) {
                    e.printStackTrace();
                }
            }
        }
        return components;
    }
}
