package edu.csc413.statement;

import edu.csc413.expression.Expression;
import edu.csc413.interpreter.ProgramState;

public class AssignStatement extends Statement{

    private String variableName;
    private Expression expression;

    public  AssignStatement(String variableName, Expression expression){
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void run(ProgramState programState){
        int value = expression.evaluate(programState);
        programState.setVariable(variableName,value);
    }
}
