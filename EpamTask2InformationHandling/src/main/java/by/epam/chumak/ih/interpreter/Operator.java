package by.epam.chumak.ih.interpreter;

public enum Operator {
    ADD("+"),
    MULTIPLE("*"),
    SUB ("-"),
    DIVIDE("/"),
    INCREMENT("++"),
    DECREMENT("--"),
    LEFT_BRACKET("("),
    RIGHT_BRACKET(")"),
    SPACE(" "),
    XOR("^"),
    OR("|"),
    AND("&"),
    LEFT_SHIFT("<<"),
    RIGHT_SHIFT(">>");

    Operator(String s) {

    }
}
