package Domain.Statement;

import ADT.MyIDictionary;
import Domain.Expressions.Expression;
import Domain.ProgramState.PrgState;
import Domain.Types.RefType;
import Domain.Values.Value;
import Exception.MyException;

import java.util.Objects;

public class AllocateStatement implements IStmt{

    private String variableName;

    private Expression exp;

    public AllocateStatement ( String variableName , Expression exp ) {
        this.variableName = variableName;
        this.exp = exp;
    }


    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary<String , Value > symTable = state.getSymTable();
        if(!symTable.checkIfKeyExists(this.variableName)) {
            throw new MyException("Variable does not exist!");
        }
        Value val = symTable.getValue(this.variableName);
        if(!val.getType().equals(new RefType())){
            throw new MyException("It is not a reference type!");
        }
        
    }
}
