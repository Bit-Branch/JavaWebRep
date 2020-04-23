package by.epam.ih.composite;

import by.epam.ih.exception.NoSuchOperationException;

public interface Component<T> {
    void add(Component<T> c) throws NoSuchOperationException;
    void remove(Component<T> c) throws NoSuchOperationException;
    T getChild ();
    SentenceToken getTokenType() throws NoSuchOperationException;
}
