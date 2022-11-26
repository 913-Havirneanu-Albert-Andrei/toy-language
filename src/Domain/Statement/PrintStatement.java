package Domain.Statement;

import ADT.MyIDictionary;
import ADT.MyIList;
import Domain.Expressions.Expression;
import Domain.ProgramState.PrgState;
import Domain.Values.Value;
import Exception.MyException;
public class PrintStatement implements IStmt{

    Expression expression;

    public PrintStatement(Expression e1) {
        this.expression = e1;
    }

    @Override
    public String toString() {
        return "print ( " + this.expression.toString () + " )";
    }

    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary<String , Value > table = state.getSymTable ();
        MyIList<Value> output = state.getOutConsole ();
        output.addFinal (this.expression.eval (table));
        return state;
    }
}
