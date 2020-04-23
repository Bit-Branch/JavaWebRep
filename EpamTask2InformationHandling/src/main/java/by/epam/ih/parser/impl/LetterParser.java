package by.epam.ih.parser.impl;

import by.epam.ih.composite.Component;
import by.epam.ih.composite.Composite;
import by.epam.ih.composite.SentenceToken;
import by.epam.ih.composite.Symbol;
import by.epam.ih.exception.NoSuchOperationException;
import by.epam.ih.parser.AbstractParser;

public class LetterParser implements AbstractParser {
    private final String LETTER_PATTERN = "";
    private static LetterParser instance = new LetterParser();

    public static LetterParser getInstance() {
        return instance;
    }

    @Override
    public Component parse(String text) {
        Component components = new Composite(SentenceToken.LETTER);
        String[] letters = text.split(LETTER_PATTERN);
        for (String letter : letters) {
            if (letter.length() > 0) {
                try {
                    components.add(new Symbol(letter,SentenceToken.LETTER));
                } catch (NoSuchOperationException e) {
                    e.printStackTrace();
                }
            }
        }
        return components;
    }
}
