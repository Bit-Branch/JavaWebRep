package by.epam.chumak.ih.interpreter.impl;

import by.epam.chumak.ih.interpreter.Expression;
import by.epam.chumak.ih.interpreter.context.Context;

public class TerminalExpressionSub implements Expression {
    @Override
    public void interpret(Context c) {
        c.pushValue(c.popValue() - c.popValue());
    }
}
