package edu.csc413.statement;

import edu.csc413.expression.Condition;
import edu.csc413.expression.ConstantExpression;
import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WhileStatementTest {

    @Test
    void runWhileStatement() {
        ProgramState programState = new ProgramState();

        String variableName = "var";

        ConstantExpression constantExpression = new ConstantExpression(0);
        AssignStatement assignStatement= new AssignStatement(variableName, constantExpression);
        assignStatement.run(programState);

        ConstantExpression constantExpression1 = new ConstantExpression(10);
        AssignStatement assignStatement1 = new AssignStatement(variableName,constantExpression1);
        List<Statement> statementList = new ArrayList<>();
        statementList.add(assignStatement1);


        Condition condition =  Condition.create("var < 3");
        WhileStatement whileStatement = new WhileStatement(statementList,condition);

        whileStatement.run(programState);
        assertEquals(programState.getVariable(variableName),10);
    }


}