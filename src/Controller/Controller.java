package Controller;

import ADT.MyIStack;
import Domain.ProgramState.PrgState;
import Domain.Statement.IStmt;
import Repository.IRepository;
import Exception.MyException;

public class Controller {
    private IRepository repo;

    public Controller(IRepository r) {
        this.repo = r;
    }

    public IRepository getRepo() {
        return this.repo;
    }

    public PrgState executeOneStep(PrgState program) throws MyException {
        MyIStack<IStmt> exeStack = this.repo.getCrtPrg ().getExecutionStack ();
        if (exeStack.isEmpty ()){
            throw new MyException ("Stack empty!");
        }
        IStmt nextInstruction = exeStack.pop ();
        nextInstruction.execute (program);
        return program;
    }

    public void allStep() throws MyException{
        PrgState program = this.repo.getCrtPrg ();
        while(!program.getExecutionStack ().isEmpty ()){
            program =  executeOneStep (program);
        }
    }

}
