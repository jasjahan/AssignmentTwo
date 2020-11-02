package edu.csc413.statement;

import edu.csc413.expression.Expression;
import edu.csc413.interpreter.ProgramState;

public class ReturnStatement extends Statement{

    private Expression expression;

    public ReturnStatement(Expression expression ){
        this.expression = expression;
    }

    @Override
    public void run(ProgramState programState) {
        int value = expression.evaluate(programState);
        programState.setReturnValue(value);
    }
}
