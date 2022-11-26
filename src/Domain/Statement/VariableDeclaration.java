package Domain.Statement;

import Domain.Expressions.ArithmeticExpression;
import Exception.MyException;
import ADT.MyIDictionary;
import Domain.ProgramState.PrgState;
import Domain.Types.Type;
import Domain.Values.Value;

public class VariableDeclaration implements IStmt{

    String name;
    Type type;
    public VariableDeclaration(String n , Type t){
        this.name = n;
        this.type = t;
    }


    public String getId() {
        return this.name;
    }

    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary<String , Value > table = state.getSymTable ();
        if  (table.checkIfKeyExists (this.name)){
            throw new MyException ("Variable is already declared!");
        }
        table.add ( this.name , type.defaultValue ());
        return state;
    }

    @Override
    public String toString() {
        return this.type + " " + this.name;

    }

}