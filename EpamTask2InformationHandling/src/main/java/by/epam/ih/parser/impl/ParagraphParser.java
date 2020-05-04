package by.epam.ih.parser.impl;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.Composite;
import by.epam.ih.composite.impl.SentenceType;
import by.epam.ih.composite.impl.Symbol;
import by.epam.ih.exception.ComponentException;
import by.epam.ih.parser.AbstractParser;

public class ParagraphParser implements AbstractParser {
    private static final String PARAGRAPH_PATTERN = "\r{0,}\n\\s{0,4}";

    private static ParagraphParser instance = new ParagraphParser();

    private ParagraphParser(){}
    public static ParagraphParser getInstance() {
        return instance;
    }

    @Override
    public Composite parse(String value) throws ComponentException {
        Composite sentences = new Composite(SentenceType.TEXT);
        String[] paragraphs = value.split(PARAGRAPH_PATTERN);
        for (String paragraph : paragraphs) {
            sentences.add(SentenceParser.getInstance().parse(paragraph));
        }
        return sentences;
    }
}
