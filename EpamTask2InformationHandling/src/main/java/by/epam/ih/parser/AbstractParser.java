package by.epam.ih.parser;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.Composite;
import by.epam.ih.exception.ComponentException;

public interface AbstractParser {
    Composite parse(String value) throws ComponentException;
}
