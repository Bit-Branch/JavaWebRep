package by.epam.ih.parser.impl;

import by.epam.ih.composite.Component;
import by.epam.ih.composite.Composite;
import by.epam.ih.composite.SentenceToken;
import by.epam.ih.composite.Symbol;
import by.epam.ih.exception.NoSuchOperationException;
import by.epam.ih.parser.AbstractParser;

public class PunctuationParser implements AbstractParser {

    private final String PUNCTUATION_PATTERN = "\\.{3}|[\\.!?,]";
    private static LetterParser instance = new LetterParser();

    public static LetterParser getInstance() {
        return instance;
    }

    @Override
    public Component parse(String text) {
        Component components = new Composite(SentenceToken.PUNCTUATION);
        String[] symbols = text.split(PUNCTUATION_PATTERN);
        for (String symbol : symbols) {
            if (symbol.length() > 0) {
                try {
                    components.add(new Symbol(symbol,SentenceToken.PUNCTUATION));
                } catch (NoSuchOperationException e) {
                    e.printStackTrace();
                }
            }
        }
        return components;
    }
}
