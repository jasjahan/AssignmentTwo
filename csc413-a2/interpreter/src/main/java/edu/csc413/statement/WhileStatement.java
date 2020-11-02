package edu.csc413.statement;

import edu.csc413.expression.Condition;
import edu.csc413.interpreter.ProgramState;
import java.util.List;

public class WhileStatement extends LoopStatement {

    public WhileStatement(List<Statement> statements, Condition condition) {
        super(statements, condition);
    }

    @Override
    protected void runInitialization(ProgramState programState) {

    }

    @Override
    protected void runUpdate(ProgramState programState) {

    }
}
