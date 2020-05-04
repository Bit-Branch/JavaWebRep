package by.epam.ih.parser.impl;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.Composite;
import by.epam.ih.composite.impl.SentenceType;
import by.epam.ih.composite.impl.Symbol;
import by.epam.ih.exception.ComponentException;
import by.epam.ih.parser.AbstractParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements AbstractParser {

    private static final String SENTENCE_PATTERN = "[\\.]{3}\\s|[\\.!?]\\s?";
    private static SentenceParser instance = new SentenceParser();

    private SentenceParser(){}
    public static SentenceParser getInstance() {
        return instance;
    }

    @Override
    public Composite parse(String value) throws ComponentException {
        List<String> sentences = new ArrayList<>();
        Composite paragraph = new Composite(SentenceType.PARAGRAPH);
        Pattern patternSentence = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcherSentence = patternSentence.matcher(value);

        int start = 0;
        int end;

        while (matcherSentence.find()) {
            end = matcherSentence.end();
            String sentence = value.substring(start, end).trim();
            start = end;
            sentences.add(sentence);
        }
        for (String sentence : sentences) {
            paragraph.add(WordParser.getInstance().parse(sentence));
        }
        return paragraph;
    }
}
