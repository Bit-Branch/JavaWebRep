package by.epam.ih.interpreter.impl;

import by.epam.ih.interpreter.Expression;
import by.epam.ih.interpreter.context.Context;

public class NotTerminalExpression implements Expression {
    @Override
    public void interpret(Context c) {
        c.pushValue(~c.popValue());
    }
}
