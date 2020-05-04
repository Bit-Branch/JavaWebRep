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
                    listExpression.add(new AddTerminalExpression());
                    break;
                case '-':
                    listExpression.add(new SubTerminalExpression());
                    break;
                case '*':
                    listExpression.add(new MultiplyTerminalExpression());
                    break;
                case '/':
                    listExpression.add(new DivideTerminalExpression());
                    break;
                case '|':
                    listExpression.add(new OrTerminalExpression());
                    break;
                case '^':
                    listExpression.add(new XorTerminalExpression());
                    break;
                case '&':
                    listExpression.add(new AndTerminalExpression());
                    break;
                case '<':
                    listExpression.add(new LeftShiftTerminalExpression());
                    break;
                case '>':
                    listExpression.add(new RightShiftTerminalExpression());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(new NumberNonTerminalExpression(scan.nextInt()));
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

