package by.epam.ih.interpreter.impl;

import by.epam.ih.interpreter.Expression;
import by.epam.ih.interpreter.context.Context;

public class NumberNonTerminalExpression implements Expression {
    private int number;

    public NumberNonTerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}
