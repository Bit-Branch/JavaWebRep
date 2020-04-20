package by.epam.ih.parser.impl;

import by.epam.ih.composite.Component;
import by.epam.ih.composite.Composite;
import by.epam.ih.composite.SentenceToken;
import by.epam.ih.parser.Parser;

import java.util.List;

public class TextParser implements Parser {

    public Composite parse(Component component , List<String> text, SentenceToken token) {
        return new Composite(token);
    }
}
