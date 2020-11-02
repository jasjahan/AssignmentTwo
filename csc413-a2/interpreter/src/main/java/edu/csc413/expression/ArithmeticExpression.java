package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;

/** An Expression representing the combination of two smaller expressions, combined with an arithmetic operator. */
public class ArithmeticExpression extends Expression {

    /** The various operators that can be used to combine smaller expressions into an ArithmeticOperator. */
    public enum Operator {
        ADD("+", 1),
        SUBTRACT("-", 1),
        MULTIPLY("*", 2),
        DIVIDE("/", 2),
        REMAINDER("%", 2),
        POWER("^", 3),
        EQUALS("==", 0),
        NOT_EQUALS("!=", 0),
        LESS_THAN("<", 0),
        LESS_THAN_EQUALS("<=", 0),
        GREATER_THAN(">", 0),
        GREATER_THAN_EQUALS(">=", 0);

        private final String symbol;
        private final int precedence;

        Operator(String symbol, int precedence) {
            this.symbol = symbol;
            this.precedence = precedence;
        }

        String getSymbol() {
            return symbol;
        }

        int getPrecedence() {
            return precedence;
        }
    }

    private Operator operator;
    private Expression lhs;
    private Expression rhs;

    public ArithmeticExpression(Operator operator, Expression lhs, Expression rhs){
        this.operator = operator;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public int evaluate(ProgramState programState) {

        int lhsValue = lhs.evaluate(programState);
        int rhsValue = rhs.evaluate(programState);

        return switch(operator){
            case ADD -> lhsValue + rhsValue;
            case SUBTRACT -> lhsValue - rhsValue;
            case MULTIPLY -> lhsValue * rhsValue;
            case DIVIDE -> lhsValue / rhsValue;
            case REMAINDER -> lhsValue % rhsValue;
            case POWER -> lhsValue ^ rhsValue;
            case EQUALS -> asInt(lhsValue == rhsValue);
            case NOT_EQUALS -> asInt(lhsValue != rhsValue);
            case LESS_THAN -> asInt(lhsValue < rhsValue);
            case LESS_THAN_EQUALS -> asInt(lhsValue <= rhsValue);
            case GREATER_THAN -> asInt(lhsValue >  rhsValue);
            case GREATER_THAN_EQUALS -> asInt(lhsValue >= rhsValue);

        };

    }
    private int asInt(boolean condition){
        return condition ? 1 :0;
    }
}
