package Domain.Statement;

import ADT.MyIDictionary;
import Domain.Expressions.Expression;
import Domain.ProgramState.PrgState;
import Domain.Values.Value;
import Exception.MyException;

public class VariableAssignment implements IStmt{

    String name;
    Expression expression;

    public VariableAssignment(String n , Expression e) {
        this.name = n;
        this.expression = e;
    }

    @Override
    public String toString() {
        return this.name + " = " + this.expression.toString ();
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symbolTable = state.getSymTable();
        Value newValue = this.expression.eval(symbolTable);
        if(symbolTable.checkIfKeyExists (this.name)){
            Value oldValue = symbolTable.getValue (this.name);
            if( newValue.getType().toString().equals(oldValue.getType().toString())){
                symbolTable.add(this.name, newValue);
            } else throw new MyException("AssignStmt exception: Variable " +  this.name.toString() + " is assigned wrong value type: " + newValue.getType().toString() + "!");
        } else throw new MyException("AssignStmt exception: Variable " + this.name.toString() + " used but not defined!");

        return null;
    }
}
