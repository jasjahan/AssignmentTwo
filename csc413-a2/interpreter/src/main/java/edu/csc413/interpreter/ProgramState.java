package edu.csc413.interpreter;

import edu.csc413.statement.Statement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * A class which tracks the state of a running program. ProgramState should maintain a call stack, with each call frame
 * tracking variable names and their corresponding values. ProgramState should also keep track of function definitions,
 * so that when function calls are made, they can be run and evaluated.
 */
public class ProgramState {


    private Map<String, List<String>> functionParametersMap = new HashMap<>();
    private Map<String, List <Statement>> functionStatementsMap = new HashMap<>();
    private Stack<Map<String, Integer>> callFrames = new Stack<>();

    private int returnValue;
    private boolean checkReturnValue;

    public ProgramState(){
           addNewCallFrame();
      }

   public boolean hasKey(String variable){
       return callFrames.peek().containsKey(variable);
   }

    public int getVariable(String variable) {
       // TODO: Implement.
        return callFrames.peek().get(variable);
    }

    public void setVariable(String variable, int value) {
        callFrames.peek().put(variable, value);
        // TODO: Implement.
    }


    public List<String> getFunctionParameters(String functionName) {
        return functionParametersMap.get(functionName);
    }

    public void setFunctionParameters(String functionName, List<String> parameters) {
       functionParametersMap.put(functionName,parameters);
    }

    public List<Statement> getFunctionStatements(String functionName){
       return functionStatementsMap.get(functionName);

    }

    public void setFunctionStatements(String functionName, List<Statement> statements){
       functionStatementsMap.put(functionName,statements);

    }

    public void addNewCallFrame() {
        // TODO: Implement.
        Map<String, Integer> map = new HashMap<>();
        callFrames.push(map);
    }

    public void removeCurrentCallFrame() {
        // TODO: Implement.
        callFrames.pop();
    }


    // TODO: Define and implement methods for setting and retrieving a function's list of parameter names given the
    //       function name, along with the corresponding instance variables.

    // TODO: Define and implement methods for setting and retrieving a function's list of Statements representing its
    //       body given the function name, along with the corresponding instance variables.

    public boolean hasReturnValue() {
        // TODO: Implement.
        return checkReturnValue;
    }

    public int getReturnValue() {
        // TODO: Implement.
        return returnValue;
    }

    public void setReturnValue(int value) {
        // TODO: Implement.
        returnValue = value;
        checkReturnValue = true;
    }

    public void clearReturnValue() {
        checkReturnValue = false;
        // TODO: Implement.
    }
}
