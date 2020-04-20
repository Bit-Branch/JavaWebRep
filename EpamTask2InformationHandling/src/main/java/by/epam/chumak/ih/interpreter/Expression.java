package by.epam.chumak.ih.interpreter;

import by.epam.chumak.ih.interpreter.context.Context;

public interface Expression {
    void interpret(Context context);
}
