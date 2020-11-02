package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.statement.DefineFunctionStatement;
import edu.csc413.statement.ReturnStatement;
import edu.csc413.statement.Statement;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionExpressionTest {

    @Test
    void evaluate1() {
        ProgramState programState = new ProgramState();
        String functionName = "sum";
        Expression lhs = Expression.create("2");
        Expression rhs = Expression.create("3");
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(ArithmeticExpression.Operator.ADD,lhs,rhs);


        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");

        ReturnStatement returnStatement = new ReturnStatement(arithmeticExpression);
        List<Statement> statementList = new ArrayList<>();
        statementList.add(returnStatement);

        DefineFunctionStatement functionStatement = new DefineFunctionStatement(functionName, statementList, stringList);
        functionStatement.run(programState);

        List<Expression> expressionList = new ArrayList<>();
        expressionList.add(new ConstantExpression(2));
        expressionList.add(new  ConstantExpression(3)) ;

        FunctionExpression test = new FunctionExpression("sum", expressionList);
        assertEquals(5, test.evaluate(programState));
    }
}