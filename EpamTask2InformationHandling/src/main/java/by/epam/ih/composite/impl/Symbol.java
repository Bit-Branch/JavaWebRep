package by.epam.ih.composite.impl;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.SentenceType;
import by.epam.ih.exception.ComponentException;

public class Symbol implements TextComponent<String> {
    private String component;
    private SentenceType token;

    public Symbol(String component, SentenceType type) {
        this.component = component;
        this.token = type;
    }

    public SentenceType getToken() {
        return token;
    }

    @Override
    public String getChild() {
        return component;
    }

    @Override
    public void add(TextComponent c) throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public void remove(TextComponent c) throws ComponentException {
        throw new ComponentException();
    }

    @Override
    public String toString() {
        return component;
    }

    @Override
    public SentenceType getSentenceType() throws ComponentException {
        return token;
    }
}