package edu.csc413.statement;

import edu.csc413.expression.Condition;
import edu.csc413.expression.ConstantExpression;
import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForStatementTest {

    @Test
    void runForStatement() {

        ProgramState programState = new ProgramState();

        String variableName = "var";

        ConstantExpression constantExpression = new ConstantExpression(0);
        AssignStatement  initializeStatement = new AssignStatement(variableName,constantExpression) ;

        ConstantExpression constantExpression1 = new ConstantExpression(4);
        AssignStatement  updateStatement= new AssignStatement(variableName,constantExpression1) ;


        AssignStatement assignStatement = new AssignStatement(variableName,constantExpression);
        List<Statement> statementList = new ArrayList<>();
        statementList.add(assignStatement);

        Condition condition =  Condition.create("var < 3");

        ForStatement forStatement = new ForStatement(statementList,condition, initializeStatement, updateStatement);
        forStatement.run(programState);

        assertEquals(programState.getVariable(variableName),4);


    }

}