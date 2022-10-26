package Domain.Statement;

import Domain.ProgramState.PrgState;
import Exception.MyException;


public class NopStatement implements IStmt{

    public NopStatement() {}

    @Override
    public String toString() {
        return "NOPE";
    }

    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        return state;
    }
}
