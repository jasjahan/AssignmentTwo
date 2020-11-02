package edu.csc413.expression;
import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticExpressionTest {

    @Test
    public void evaluate(){

        ProgramState programState = new ProgramState();
        Expression lhs = Expression.create("2");
        Expression rhs = Expression.create("4");
        ArithmeticExpression test = new ArithmeticExpression(ArithmeticExpression.Operator.ADD, lhs, rhs);

        assertEquals(6, test.evaluate(programState));

    }
}