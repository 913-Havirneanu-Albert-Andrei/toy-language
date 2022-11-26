package Repository;

import Domain.ProgramState.PrgState;

import java.io.IOException;
import java.util.List;

import Domain.Statement.IStmt;
import Exception.MyException;
public interface IRepository {

    IStmt getOriginalProgram ( );

    void printPrgState( PrgState state) throws IOException, MyException;

    List <PrgState> getPrgList ( );

    PrgState getCrtPrg() throws MyException;

    void addState ( PrgState state );
}
