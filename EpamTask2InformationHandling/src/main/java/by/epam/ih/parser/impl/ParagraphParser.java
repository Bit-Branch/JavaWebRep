package by.epam.ih.parser.impl;

import by.epam.ih.composite.Component;
import by.epam.ih.composite.Composite;
import by.epam.ih.composite.SentenceToken;
import by.epam.ih.composite.Symbol;
import by.epam.ih.exception.NoSuchOperationException;
import by.epam.ih.parser.AbstractParser;

public class ParagraphParser implements AbstractParser {

    private static ParagraphParser instance = new ParagraphParser();

    public static ParagraphParser getInstance() {
        return instance;
    }

    @Override
    public Component parse(String text) {
        Component components = new Composite(SentenceToken.PARAGRAPH);
        String[] paragraphs = text.split(System.getProperty("line.separator"));
        for (String paragraph : paragraphs) {
            if (paragraph.length() > 0) {
                try {
                    components.add(new Symbol(paragraph,SentenceToken.PARAGRAPH));
                } catch (NoSuchOperationException e) {
                    e.printStackTrace();
                }
            }
        }
        return components;
    }
}
