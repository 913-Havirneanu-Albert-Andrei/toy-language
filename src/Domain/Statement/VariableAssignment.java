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
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary<String , Value > table = state.getSymbolTable ();
        Value updatedValue = this.expression.eval (table);
        Value oldValue = table.getValue (this.name);
        if (!(table.checkIfKeyExists (this.name))){
            throw new MyException ("Assignment error: Variable used but not defined");
        }
        if (!(oldValue.getType ().equals (updatedValue.getType ()))){
            throw new MyException ("Assignment error: Tried to assign "
                    + updatedValue.getType () + " to " + oldValue.getType ());
        }
        table.add (this.name , updatedValue );
        return state;
    }
}
