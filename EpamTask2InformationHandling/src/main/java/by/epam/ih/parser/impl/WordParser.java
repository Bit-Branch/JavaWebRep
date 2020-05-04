package by.epam.ih.parser.impl;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.Composite;
import by.epam.ih.composite.impl.SentenceType;
import by.epam.ih.exception.ComponentException;
import by.epam.ih.interpreter.ExpressionCalculator;
import by.epam.ih.interpreter.ExpressionInterpreter;
import by.epam.ih.parser.AbstractParser;

import java.util.regex.Pattern;

public class WordParser implements AbstractParser {
    private static final String WORD_PATTERN = " ";
    private static final String DIGIT_PATTERN = "\\d+";
    private static WordParser instance = new WordParser();

    private WordParser(){}
    public static WordParser getInstance() {
        return instance;
    }

    @Override

    public Composite parse(String value){
        Composite sentence = new Composite(SentenceType.SENTENCE);
        Pattern mathExprPattern = Pattern.compile(DIGIT_PATTERN);
        String[] words = value.split(WORD_PATTERN);
        for (String word : words) {
            if(mathExprPattern.matcher(word).find()){
                ExpressionInterpreter expressionInterpreter = new ExpressionInterpreter(word);
                ExpressionCalculator expressionCalculator = new ExpressionCalculator();
                word = expressionCalculator.calculate(expressionInterpreter.getListExpression()).toString();
            }
            sentence.add(SymbolParser.getInstance().parse(word));
        }
        return sentence;
    }
}