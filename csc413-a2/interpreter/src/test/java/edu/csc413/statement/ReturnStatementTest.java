package edu.csc413.statement;

import edu.csc413.expression.ConstantExpression;
import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReturnStatementTest {

    @Test
    void run() {
        ProgramState programState = new ProgramState();

        int value = 10;
        ConstantExpression constantExpression = new ConstantExpression(10);
        ReturnStatement returnStatement = new ReturnStatement(constantExpression);

        returnStatement.run(programState);
        int returnVal = programState.getReturnValue();

        assertTrue(programState.hasReturnValue());
        assertEquals(returnVal, 10);
    }
}