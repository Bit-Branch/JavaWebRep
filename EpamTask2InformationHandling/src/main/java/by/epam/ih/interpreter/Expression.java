package by.epam.ih.interpreter;

import by.epam.ih.interpreter.context.Context;

public interface Expression {
    void interpret(Context context);
}
