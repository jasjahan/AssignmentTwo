package edu.csc413.statement;
import edu.csc413.expression.Condition;
import edu.csc413.interpreter.ProgramState;
import java.util.List;

public class IfStatement extends BlockStatement {

    private Condition condition;

    public IfStatement(List<Statement> statements, Condition condition) {
        super(statements);
        this.condition = condition;
    }

    @Override
    public void run(ProgramState programState) {
          if(condition.evaluate(programState)){
              runBlock(programState);
          }
    }
}





