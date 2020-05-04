package by.epam.ih.composite.impl;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.exception.ComponentException;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TextComponent<List<TextComponent>> {
    private List<TextComponent> textComponents = new ArrayList<>();
    private SentenceType token;

    public Composite(SentenceType type) {
        this.token = type;
    }

    public Composite(TextComponent textComponent) throws ComponentException {
        this.textComponents = (List<TextComponent>) textComponent.getChild();
        this.token = textComponent.getSentenceType();
    }

    public SentenceType getToken() {
        return token;
    }

    @Override
    public List<TextComponent> getChild() {
        return textComponents;
    }

    @Override
    public void add(TextComponent c) {
        textComponents.add(c);
    }

    @Override
    public void remove(TextComponent c) {
        textComponents.remove(c);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (TextComponent comp: textComponents
             ) {
            s.append(comp.toString());
        }
        return s.toString();
    }

    @Override
    public SentenceType getSentenceType() throws ComponentException {
        throw new ComponentException();
    }
}

