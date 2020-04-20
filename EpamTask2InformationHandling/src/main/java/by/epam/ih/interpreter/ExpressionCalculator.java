package by.epam.ih.interpreter;

import by.epam.ih.interpreter.context.Context;

import java.util.List;

public class ExpressionCalculator {
    public Number calculate(List<Expression> listExpression) {
        Context context = new Context();
        for (Expression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue(); }
    }
