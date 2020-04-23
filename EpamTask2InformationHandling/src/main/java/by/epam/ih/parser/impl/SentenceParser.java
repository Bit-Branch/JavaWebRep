package by.epam.ih.parser.impl;

import by.epam.ih.composite.Component;
import by.epam.ih.composite.Composite;
import by.epam.ih.composite.SentenceToken;
import by.epam.ih.composite.Symbol;
import by.epam.ih.exception.NoSuchOperationException;
import by.epam.ih.parser.AbstractParser;

public class SentenceParser implements AbstractParser {

    private final String SENTENCE_PATTERN = "^[A-Z]{1}[A-Za-z,;'\"\\s]+[.?!]$";
    private static SentenceParser instance = new SentenceParser();

    public static SentenceParser getInstance() {
        return instance;
    }

    @Override
    public Component parse(String text) {
        Component components = new Composite(SentenceToken.SENTENCE);
        String[] sentences = text.split(SENTENCE_PATTERN);
        for (String sentence : sentences) {
            if (sentence.length() > 0) {
                try {
                    components.add(new Symbol(sentence,SentenceToken.SENTENCE));
                } catch (NoSuchOperationException e) {
                    e.printStackTrace();
                }
            }
        }
        return components;
    }
}
