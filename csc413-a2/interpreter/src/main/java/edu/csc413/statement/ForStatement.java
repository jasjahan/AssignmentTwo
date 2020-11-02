package edu.csc413.statement;
import edu.csc413.expression.Condition;
import edu.csc413.interpreter.ProgramState;
import java.util.List;

public class ForStatement extends LoopStatement{

    private Statement initializeStatement;
    private Statement updateStatement;

    public ForStatement(List<Statement> statements,
                        Condition condition,
                        Statement initializeStatement,
                        Statement updateStatement) {

        super(statements,condition);
        this.initializeStatement= initializeStatement;
        this.updateStatement = updateStatement;
    }



    @Override
    protected void runInitialization(ProgramState programState) {
        initializeStatement.run(programState);

    }

    @Override
    protected void runUpdate(ProgramState programState) {
        updateStatement.run(programState);
    }
}
