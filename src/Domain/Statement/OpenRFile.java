package Domain.Statement;

import ADT.MyIDictionary;
import Domain.Expressions.Expression;
import Domain.ProgramState.PrgState;
import Domain.Types.StringType;
import Domain.Values.StringValue;
import Domain.Values.Value;
import Exception.MyException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class OpenRFile implements IStmt{

    Expression exp;

    public OpenRFile ( Expression exp ) {
        this.exp = exp;
    }

    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary < String, Value > symTable = state.getSymTable( );
        Value val = this.exp.eval( symTable );
        if( ! val.getType( ).equals( new StringType( ) ) ) {
            throw new MyException( "Expression is not a string!" );
        }
        MyIDictionary < StringValue, BufferedReader > fileTable = state.getFileTable( );
        StringValue stringVal = (StringValue) val;
        if( fileTable.checkIfKeyExists( stringVal ) )
            throw new MyException( "The file is already in use" );
        try {
            Reader reader = new FileReader( stringVal.getValue( ) );
            BufferedReader bufferedReader = new BufferedReader( reader );
            fileTable.add( stringVal , bufferedReader );
        } catch (FileNotFoundException e) {
            throw new MyException( e.getMessage( ) );
        }
        return null;
    }

    @Override
    public String toString() {
        return "open " + this.exp;
    }

}
