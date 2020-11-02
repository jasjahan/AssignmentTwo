package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;

public class VariableExpression extends Expression{
    private String variableName;

    public VariableExpression(String variableName){
        if (!variableName.matches(VARIABLE_NAME_PATTERN.pattern())) {
            throw new RuntimeException("Invalid variable name provided: " + variableName);
        }
        this.variableName= variableName;
    }

    @Override
    public int evaluate(ProgramState programState) {
        return programState.getVariable(variableName);
    }
}
