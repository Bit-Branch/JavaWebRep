package by.epam.ih.parser.impl;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.Composite;
import by.epam.ih.composite.impl.SentenceType;
import by.epam.ih.composite.impl.Symbol;
import by.epam.ih.exception.ComponentException;
import by.epam.ih.parser.AbstractParser;

import java.util.regex.Pattern;

public class SymbolParser implements AbstractParser {
    private static final String LETTER_PATTERN = "";
    private static final String PUNCTUATION_PATTERN = "\\.{3}|[\\.!?,]";
    private static SymbolParser instance = new SymbolParser();

    private SymbolParser(){}
    public static SymbolParser getInstance() {
        return instance;
    }

    @Override
    public Composite parse(String value) {
        Composite word = new Composite(SentenceType.WORD);
        String[] letters = value.split(LETTER_PATTERN);
        for (String letter : letters) {
            TextComponent component;
            if (Pattern.matches(PUNCTUATION_PATTERN, letter)) {
                component = new Symbol(letter, SentenceType.PUNCTUATION);
            } else {
                component = new Symbol(letter, SentenceType.LETTER);
            }
            word.add(component);
        }
        return word;
    }
}
