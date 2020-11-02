package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableExpressionTest {

    @Test
    void evaluate() {
        ProgramState programState = new ProgramState();
        VariableExpression test = new VariableExpression("var");
        programState.setVariable("var", 6);

        assertEquals(6, test.evaluate(programState));
    }
}