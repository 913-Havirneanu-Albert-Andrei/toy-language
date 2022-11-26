package Domain.Statement;

import ADT.MyIDictionary;
import Domain.Expressions.Expression;
import Domain.ProgramState.PrgState;
import Domain.Types.IntType;
import Domain.Types.StringType;
import Domain.Values.IntValue;
import Domain.Values.StringValue;
import Domain.Values.Value;
import Exception.MyException;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements IStmt{

    Expression exp;
    String variableName;

    public ReadFile ( Expression exp , String variableName ) {
        this.exp = exp;
        this.variableName = variableName;
    }

    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary<String , Value > symTable = state.getSymTable();
        MyIDictionary < StringValue, BufferedReader > fileTable = state.getFileTable();
        if (!symTable.checkIfKeyExists(this.variableName))
            throw new MyException("Variable " + this.variableName + " is not declared!");
        Value val = symTable.getValue(this.variableName);
        if ( !val.getType().equals(new IntType() ))
            throw new MyException("Variable " + this.variableName + " is not int type!");
        Value stringValue = this.exp.eval(symTable);
        if (!stringValue.getType().equals(new StringType ()))
            throw new MyException("Variable " + this.exp + "is not string!");
        StringValue strVal = (StringValue) stringValue;
        if (!fileTable.checkIfKeyExists( strVal ))
            throw new MyException("File " + strVal + " does not exist!");
        BufferedReader bufferedReader = fileTable.getValue(strVal);
        try {
            String line = bufferedReader.readLine();
            Value intValue;
            if( line == null ) {
                intValue = new IntValue(0);
            } else {
                intValue = new IntValue(Integer.parseInt(line));
            }
            symTable.add(this.variableName , intValue);
        }catch(IOException e) {
            throw new MyException("Could not read from file");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Read " + this.variableName + " from " + this.exp;
    }

}
