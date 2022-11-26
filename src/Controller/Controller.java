package Controller;
import ADT.MyIStack;
import Domain.ProgramState.PrgState;
import Domain.Statement.IStmt;
import Repository.IRepository;

import java.io.BufferedReader;
import java.io.IOException;
import Exception.MyException;
public class Controller {
    private IRepository repository;

    public Controller(IRepository repo) {
        this.repository = repo;
    }

    public PrgState oneStep( PrgState state) throws MyException {
        MyIStack < IStmt > stack = state.getStack();
        if (stack.isEmpty()) {
            throw new MyException("Stack is empty");
        }
        IStmt currentStmt = stack.pop();
        return currentStmt.execute(state);
    }

    public void allStep() throws MyException, IOException {
        PrgState prg = repository.getCrtPrg();
        repository.printPrgState(prg);
        //System.out.println(prg);

        while (!prg.getStack().isEmpty()) {
            try {
                oneStep(prg);
                //System.out.println(prg);
                repository.printPrgState(prg);
            } catch (MyException exception) {
                throw new MyException(exception.getMessage());
            }
        }
    }

}
