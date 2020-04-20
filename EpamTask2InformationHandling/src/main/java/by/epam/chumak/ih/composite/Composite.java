package by.epam.chumak.ih.composite;

import by.epam.chumak.ih.exception.NoSuchOperationException;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component<List<Component>> {
    private List<Component> components = new ArrayList<>();
    private SentenceToken token;

    public Composite(SentenceToken type) {
        this.token = type;
    }

    public Composite(Component component) throws NoSuchOperationException {
        this.components = (List<Component>) component.getChild();
        this.token = component.getTokenType();
    }

    public SentenceToken getToken() {
        return token;
    }

    @Override
    public List<Component> getChild() {
        return components;
    }

    @Override
    public void add(Component c) {
        components.add(c);
    }

    @Override
    public void remove(Component c) {
        components.remove(c);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Component comp: components
             ) {
            s.append(comp.toString());
        }
        return s.toString();
    }

    @Override
    public SentenceToken getTokenType() throws NoSuchOperationException {
        throw new NoSuchOperationException();
    }
}

