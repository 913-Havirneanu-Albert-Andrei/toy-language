package Domain.Statement;
import Exception.MyException;
import ADT.MyIStack;
import Domain.ProgramState.PrgState;

public class CompStmt implements IStmt{
    private IStmt first;
    private IStmt second;

    public CompStmt(IStmt f , IStmt s){
        this.first = f;
        this.second = s;
    }

    public String toString() {
        return  '(' + this.first.toString() + ';' + this.second.toString() + ')';
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> exeStack = state.getExecutionStack();
        exeStack.push(second);
        exeStack.push(first);
        return state;
    }
}
