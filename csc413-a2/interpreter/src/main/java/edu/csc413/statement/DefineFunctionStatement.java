package edu.csc413.statement;

import edu.csc413.interpreter.ProgramState;

import java.util.List;

public class DefineFunctionStatement extends Statement {
    private String functionName;
    private List<Statement> functionStatements;
    private List<String> parameterNames;

    public DefineFunctionStatement(String functionName,List<Statement> functionStatements, List<String> parameterNames) {
        this.functionName = functionName;
        this.functionStatements = functionStatements;
        this.parameterNames = parameterNames;
    }

    @Override
    public void run(ProgramState programState) {
          programState.setFunctionParameters(functionName, parameterNames);
          programState.setFunctionStatements(functionName,functionStatements);
    }
}
