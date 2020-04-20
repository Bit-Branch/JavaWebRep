package by.epam.chumak.ih.interpreter.impl;

import by.epam.chumak.ih.interpreter.Expression;
import by.epam.chumak.ih.interpreter.context.Context;

public class NonTerminalExpressionNumber implements Expression {
    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}
