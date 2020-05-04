package by.epam.ih.composite;

import by.epam.ih.composite.impl.SentenceType;
import by.epam.ih.exception.ComponentException;

public interface TextComponent<T> {
    void add(TextComponent<T> c) throws ComponentException;
    void remove(TextComponent<T> c) throws ComponentException;
    T getChild ();
    SentenceType getSentenceType() throws ComponentException;
}
