package edu.csc413.statement;

import edu.csc413.expression.ConstantExpression;
import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AssignStatementTest {

    @Test
    void run() {
        ProgramState programState = new ProgramState();

        String variableName = "var";
        int value = 10;

        ConstantExpression constantExpression = new ConstantExpression(10);
        AssignStatement assignStatement = new AssignStatement(variableName, constantExpression);
        assignStatement.run(programState);

        assertEquals(programState.getVariable(variableName), 10);
    }
}