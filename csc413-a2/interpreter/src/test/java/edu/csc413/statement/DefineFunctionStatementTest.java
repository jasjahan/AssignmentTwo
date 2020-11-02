package edu.csc413.statement;

import edu.csc413.expression.ArithmeticExpression;
import edu.csc413.expression.Expression;
import edu.csc413.interpreter.ProgramState;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefineFunctionStatementTest {

    @Test
    void run() {
        ProgramState programState = new ProgramState();

        String functionName = "sum";

        Expression lhs = Expression.create("2");
        Expression rhs = Expression.create("3");
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(ArithmeticExpression.Operator.ADD,lhs,rhs);
        ReturnStatement returnStatement = new ReturnStatement(arithmeticExpression);
        List<Statement> statementList = new ArrayList<>();
        statementList.add(returnStatement);

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");

        DefineFunctionStatement functionStatement = new DefineFunctionStatement(functionName, statementList, stringList);

        functionStatement.run(programState);
        List<Statement> statementList1 = programState.getFunctionStatements(functionName);
        assertEquals(statementList1, statementList );

        List<String> stringList1 = programState.getFunctionParameters(functionName);
        assertEquals(stringList, stringList1);
    }
}