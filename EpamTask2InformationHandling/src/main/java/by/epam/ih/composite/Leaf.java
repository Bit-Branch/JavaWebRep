package by.epam.ih.composite;

import by.epam.ih.exception.NoSuchOperationException;

public class Leaf implements Component<String> {
    private String component;
    private SentenceToken token;

    public Leaf(String component, SentenceToken type) {
        this.component = component;
        this.token = type;
    }

    public SentenceToken getToken() {
        return token;
    }

    @Override
    public String getChild() {
        return component;
    }

    @Override
    public void add(Component c) throws NoSuchOperationException {
        throw new NoSuchOperationException();
    }

    @Override
    public void remove(Component c) throws NoSuchOperationException {
        throw new NoSuchOperationException();
    }

    @Override
    public String toString() {
        return component;
    }

    @Override
    public SentenceToken getTokenType() throws NoSuchOperationException {
        return token;
    }
}