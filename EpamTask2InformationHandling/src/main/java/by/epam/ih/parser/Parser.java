package by.epam.ih.parser;

import by.epam.ih.composite.Component;
import by.epam.ih.composite.Composite;
import by.epam.ih.composite.SentenceToken;

import java.util.List;

public interface Parser {
    Composite parse(Component component , List<String> text, SentenceToken token);

}
