package by.epam.chumak.ih.parser;

import by.epam.chumak.ih.composite.Component;
import by.epam.chumak.ih.composite.Composite;
import by.epam.chumak.ih.composite.SentenceToken;

import java.util.List;

public class TextParser {

    Composite parse(Component component , List<String> text, SentenceToken token) {
        return new Composite(token);
    }
}
