package edu.csc413.interpreter;

import edu.csc413.expression.ArithmeticExpression;
import edu.csc413.expression.Expression;
import edu.csc413.statement.AssignStatement;
import edu.csc413.statement.ReturnStatement;
import edu.csc413.statement.Statement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ProgramStateTest {

    @Test
    void getAndSetVariable() {
        ProgramState programState = new ProgramState();
        programState.setVariable("csc", 6);
        assertEquals(programState.getVariable("csc"), 6);

    }


    @Test
    void getAndSetFunctionParameters() {
        ProgramState programState = new ProgramState();
        String functionName = "sum";
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        programState.setFunctionParameters(functionName, stringList);
        List<String> var =  programState.getFunctionParameters(functionName);
        assertThat(var, both(hasSize(2)).and(contains("a","b")));
    }


    @Test
    void getAndSetFunctionStatements() {
        ProgramState programState = new ProgramState();
        Expression lhs = Expression.create("2");
        Expression rhs = Expression.create("3");
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(ArithmeticExpression.Operator.ADD,lhs,rhs);
        AssignStatement assignStatement = new AssignStatement("var", arithmeticExpression);
        ReturnStatement returnStatement = new ReturnStatement(arithmeticExpression);
        String functionName = "sum";
        List<Statement> statementList = new ArrayList<>();
        statementList.add(returnStatement);
        statementList.add(assignStatement);
        programState.setFunctionStatements(functionName,statementList);
        List<Statement> list = programState.getFunctionStatements(functionName);
        assertThat(list, both(hasSize(2)).and(contains(returnStatement,assignStatement)));


    }


    @Test
    void addAndRemoveCallFrame() {
        ProgramState programState = new ProgramState();
        programState.addNewCallFrame();
        programState.setVariable("var", 10);
        assertEquals(programState.getVariable("var"), 10);
        programState.removeCurrentCallFrame();
        assertFalse(programState.hasKey("var"));
    }


    @Test
    void hasAndClearReturnValue() {
        ProgramState programState = new ProgramState();
        programState.setReturnValue(10);
        assertTrue(programState.hasReturnValue());
        programState.clearReturnValue();
        assertFalse(programState.hasReturnValue());
    }

    @Test
    void getAndSetReturnValue() {
        ProgramState programState = new ProgramState();
        programState.setReturnValue(10);
        assertEquals(programState.getReturnValue(), 10);
    }


}