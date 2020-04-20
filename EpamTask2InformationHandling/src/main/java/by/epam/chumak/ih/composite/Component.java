package by.epam.chumak.ih.composite;

import by.epam.chumak.ih.exception.NoSuchOperationException;

public interface Component<T> {
    void add(Component c) throws NoSuchOperationException;
    void remove(Component c) throws NoSuchOperationException;
    T getChild ();
    SentenceToken getTokenType() throws NoSuchOperationException;
}
