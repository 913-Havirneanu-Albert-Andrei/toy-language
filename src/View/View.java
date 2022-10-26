package View;

import ADT.MyDictionary;
import ADT.MyIStack;
import ADT.MyList;
import ADT.MyStack;
import Controller.Controller;
import Domain.Expressions.ValueExpression;
import Domain.Expressions.VariableExpression;
import Domain.ProgramState.PrgState;
import Domain.Statement.*;
import Domain.Types.IntType;
import Domain.Types.Type;
import Domain.Values.IntValue;
import Domain.Values.Value;
import Repository.Repository;

public class View {

    public static void main ( String[] args ) {
        IStmt example = new CompStmt(new VariableDeclaration ( "v" , new IntType () ) ,
                new CompStmt (new VariableAssignment ("v" , new ValueExpression (new IntValue ( 2 )) ) ,
                        new PrintStatement (new VariableExpression ( "v" ) )));
        MyStack<IStmt> s = new MyStack <> ();
        MyDictionary<String , Value> t = new MyDictionary <> ();
        MyList<Value> out = new MyList <> ();
        PrgState program = new PrgState ( s , t , out , example);
        Repository r = new Repository (program);
        Controller c = new Controller (r);
    }
}
