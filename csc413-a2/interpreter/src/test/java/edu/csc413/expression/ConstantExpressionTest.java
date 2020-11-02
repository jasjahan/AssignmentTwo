package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantExpressionTest {

    @Test
    void evaluate() {
        ProgramState programState = new ProgramState();
        ConstantExpression test = new ConstantExpression(6);

        assertEquals(6, test.evaluate(programState));
    }
}