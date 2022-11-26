package Domain.Statement;

import ADT.MyIDictionary;
import ADT.MyIStack;
import Domain.Expressions.Expression;
import Domain.ProgramState.PrgState;
import Domain.Types.Type;
import Domain.Values.BoolValue;
import Domain.Values.Value;
import Exception.MyException;

public class IfStatement implements IStmt{

    Expression expression;
    IStmt ifStatement , elseStatement;

    public IfStatement(Expression e1 , IStmt ifStmt , IStmt elseStmt) {
        this.expression = e1;
        this.ifStatement = ifStmt;
        this.elseStatement = elseStmt;
    }

    @Override
    public String toString() {
        return "if (" + this.expression + " ) " +  "{ " +
                  this.ifStatement  + " } " + "else" + "{" +
                this.elseStatement  + "}";
    }

    @Override
    public PrgState execute ( PrgState state ) throws MyException {
        MyIDictionary<String , Value > table = state.getSymTable ();
        MyIStack<IStmt> exeStack = state.getStack ();
        BoolValue expressionResult = (BoolValue) this.expression.eval (table);
        if (expressionResult.getValue ()) {
            exeStack.push (this.ifStatement);
        }
        else {
            exeStack.push (this.elseStatement);
        }
        return state;
    }
}
