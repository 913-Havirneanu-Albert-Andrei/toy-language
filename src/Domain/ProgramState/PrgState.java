package Domain.ProgramState;
import ADT.*;
import Domain.Statement.IStmt;
import Domain.Values.StringValue;
import Domain.Values.Value;
import java.io.BufferedReader;

public class PrgState {
    private MyIStack < IStmt > exeStack;

    public void setHeap ( MyIHeap < Value > heap ) {
        this.heap = heap;
    }

    public MyIHeap < Value > getHeap ( ) {
        return heap;
    }

    public PrgState ( MyIStack < IStmt > exeStack , MyIDictionary < String, Value > symTable , MyIList < Value > out , MyIHeap < Value > heap , MyIDictionary < StringValue, BufferedReader > fileTable , IStmt originalProgram ) {
        this.exeStack = exeStack;
        this.symTable = symTable;
        this.out = out;
        this.heap = heap;
        this.fileTable = fileTable;
        this.originalProgram = originalProgram;
    }

    private MyIDictionary <String, Value > symTable;
    private MyIList <Value> out;

    private MyIHeap<Value> heap;

    private MyIDictionary< StringValue, BufferedReader> fileTable;
    private IStmt originalProgram; //optional field, but good to have

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl, MyIList<Value> ot, MyIDictionary<StringValue, BufferedReader> fT, IStmt prg) {
        exeStack = stk;
        symTable = symtbl;
        out = ot;
        fileTable = fT;
        originalProgram = prg;
        stk.push(prg);
    }

    public PrgState( MyStack <IStmt> stack, MyDictionary <String, Value> stringValueMyDictionary, MyList<Value> valueMyList) {
        exeStack = stack;
        symTable = stringValueMyDictionary;
        out = valueMyList;
    }

    public MyIStack<IStmt> getStack() {
        return exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public IStmt getOriginalProgram(){
        return originalProgram;
    }

    public MyIDictionary<StringValue, BufferedReader> getFileTable() {
        return fileTable;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Program state\n");
        str.append("Exe Stack: ").append(exeStack).append(" \n");
        str.append("Sym Table: ").append(symTable).append(" \n");
        str.append("Output Console: ").append(out).append(" \n");
        str.append("File Table: ").append(fileTable).append(" \n");
        str.append("Heap: ").append(heap).append("\n");
        return str.toString();
    }

    public void setExeStack(MyIStack<IStmt> stack) {
        exeStack = stack;
    }

    public void setSymTable(MyIDictionary<String, Value> table) {
        symTable = table;
    }

    public MyIList<Value> getOutConsole() {
        return out;
    }

    public void setOutConsole(MyIList<Value> outConsole) {
        out = outConsole;
    }
}
