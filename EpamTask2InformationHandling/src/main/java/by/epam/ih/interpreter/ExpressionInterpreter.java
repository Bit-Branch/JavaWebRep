package by.epam.ih.interpreter;

import by.epam.ih.interpreter.impl.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ExpressionInterpreter {
    private ArrayList<Expression> listExpression;
    private String BLANK = "\\p{Blank}+";

    public ExpressionInterpreter(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split(BLANK)) {
            if (lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(new TerminalExpressionAdd());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionSub());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                case '|':
                    listExpression.add(new TerminalExpressionOr());
                    break;
                case '^':
                    listExpression.add(new TerminalExpressionXor());
                    break;
                case '&':
                    listExpression.add(new TerminalExpressionAnd());
                    break;
                case '<':
                    listExpression.add(new TerminalExpressionLeftShift());
                    break;
                case '>':
                    listExpression.add(new TerminalExpressionRightShift());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(new NonTerminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

    public ArrayList<Expression> getListExpression() {
        return listExpression;
    }

    public void setListExpression(ArrayList<Expression> listExpression) {
        this.listExpression = listExpression;
    }
}

