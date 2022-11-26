package Domain.Statement;

import ADT.MyIDictionary;
import Domain.Expressions.Expression;
import Domain.ProgramState.PrgState;
import Domain.Types.StringType;
import Domain.Values.StringValue;
import Domain.Values.Value;
import Exception.MyException;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseFile implements IStmt{

    private Expression exp;

    public CloseFile ( Expression exp ) {
        this.exp = exp;
    }

    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary<String , Value> symTable = state.getSymTable();
        MyIDictionary< StringValue, BufferedReader > fileTable = state.getFileTable();
        Value val = this.exp.eval(symTable);
        if(!val.getType().equals(new StringType() ))
            throw new MyException ("Expression could not be evaluated to String!");
        StringValue strVal = (StringValue) val;
        if (!fileTable.checkIfKeyExists(strVal))
            throw new MyException("File does not exist!");
        BufferedReader bufferedReader = fileTable.getValue(strVal);
        try {
            bufferedReader.close();
        } catch (IOException e) {
           throw new MyException(e.getMessage());
        }
        fileTable.remove(strVal);
        return null;
    }

    @Override
    public String toString() {
        return "Close " + this.exp;
    }

}


