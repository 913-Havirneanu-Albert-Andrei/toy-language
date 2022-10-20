package Domain.Statement;

import Domain.ProgramState.PrgState;
import Exception.MyException;
public interface IStmt {
    PrgState execute(PrgState state) throws MyException;
}
