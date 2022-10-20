package Domain.ProgramState;
import ADT.*;
import Domain.Statement.IStmt;
import Domain.Values.Value;

public class PrgState {
    private MyIStack<IStmt> executionStack;
    private MyIDictionary<String , Value> symbolTable;
    private MyIList<String> output;
    private IStmt originalProgram;

    public PrgState(MyIStack<IStmt> exeStack , MyIDictionary<String , Value> symTable , MyIList<String> out , IStmt original){
        this.executionStack = exeStack;
        this.symbolTable = symTable;
        this.output = out;
        this.originalProgram = original;
    }

    public MyIStack<IStmt> getExecutionStack(){
        return this.executionStack;
    }

    public MyIDictionary<String , Value> getSymbolTable(){
        return this.symbolTable;
    }

    public MyIList<String> getOutput(){
        return this.output;
    }

    public IStmt getOriginalProgram(){
        return this.originalProgram;
    }

    public boolean programFinished(){
        return this.executionStack.isEmpty();
    }



}
