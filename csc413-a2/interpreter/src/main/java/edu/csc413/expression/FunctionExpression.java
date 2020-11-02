package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.statement.Statement;

import java.util.ArrayList;
import java.util.List;

public class FunctionExpression extends Expression {

    private final String functionName;
    private final List<Expression> parameterValue;

    public FunctionExpression(String functionName, List<Expression> parameterValue) {
        this.functionName = functionName;
        this.parameterValue = parameterValue;
    }

    @Override
    public int evaluate(ProgramState programState) {


        List<String> parameterNames = programState.getFunctionParameters(functionName);
        List<Statement> functionStatements = programState.getFunctionStatements(functionName);
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < parameterNames.size(); i++) {
            int value = parameterValue.get(i).evaluate(programState);
            values.add(value);
        }

        //push new call frame
        programState.addNewCallFrame();

        //define parameters in program state
        for (int i = 0; i < parameterNames.size(); i++) {
            programState.setVariable(parameterNames.get(i), values.get(i));
        }

        for (Statement statement : functionStatements) {
            statement.run(programState);

            if (programState.hasReturnValue()) {
                //was there a value returned? if so that's the return value for this call
                // to evaluate
                int returnValue = programState.getReturnValue();

                //remove that call frame we pushed
                programState.removeCurrentCallFrame();
                //clear return value
                programState.clearReturnValue();
                //return that previously captured returnValue
                return returnValue;
            }


            //if statement is a ReturnStatement, it will jot down to the value
            // to be returned in ProgramState

        }
       return  0;
    }
}


