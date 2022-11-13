package View;

import ADT.*;
import Controller.Controller;
import Domain.Expressions.ArithmeticExpression;
import Domain.Expressions.ValueExpression;
import Domain.Expressions.VariableExpression;
import Domain.ProgramState.PrgState;
import Domain.Statement.*;
import Domain.Types.BoolType;
import Domain.Types.IntType;
import Domain.Types.Type;
import Domain.Values.BoolValue;
import Domain.Values.IntValue;
import Domain.Values.Value;
import Repository.Repository;
import Exception.MyException;

import java.util.Scanner;

public class View {

    private MyIStack<IStmt> executionStack;
    private MyIDictionary<String , Value> symTable;
    private MyIList<Value> output;
    private IStmt programToExecute;
    private Repository repo;
    private Controller controller;
    private PrgState programState;

    void chooseProgram() {
        System.out.println ("Choose program you want to execute: " );
        System.out.println ("1 - int; v = 2; Print(v)" );
        System.out.println ("2 - int a; int b; a = 2 + 3 * 5; b = a + 1; Print(b)" );
        System.out.println ("3 - bool a; int v; a = true; (If a Then v = 2 Else v = 3); Print(v)" );
        Scanner s = new Scanner ( System.in );
        int option = s.nextInt ();
        if (option == 1) {
            this.programToExecute = new CompStmt(new VariableDeclaration ("v",new IntType()),
                    new CompStmt(new VariableAssignment ("v",new ValueExpression (new IntValue(2))), new PrintStatement
                            (new VariableExpression ("v"))));
        }
        else if (option == 2) {
            this.programToExecute = new CompStmt( new VariableDeclaration ("a",new IntType()), new CompStmt(new VariableDeclaration ("b",new IntType()),
                    new CompStmt(new VariableAssignment ("a", new ArithmeticExpression ('+',new ValueExpression (new IntValue(2)),new ArithmeticExpression ('*',
                            new ValueExpression (new IntValue(3)), new ValueExpression(new IntValue(5)))) ),  new CompStmt(new VariableAssignment ("b",new ArithmeticExpression ('+',new VariableExpression ("a"),
                            new ValueExpression (new IntValue(1)))), new PrintStatement (new VariableExpression ("b"))))));
        }
        else if (option == 3) {
            this.programToExecute = new CompStmt(new VariableDeclaration ("a",new BoolType ()),
                    new CompStmt(new VariableDeclaration ("v", new IntType()),new CompStmt(new VariableAssignment ("a", new ValueExpression (new BoolValue (false))),
                            new CompStmt(new IfStatement (new VariableExpression ("a"),new VariableAssignment ("v",new ValueExpression (new IntValue(2))), new VariableAssignment ("v", new ValueExpression(new IntValue(3)))),
                                    new PrintStatement (new VariableExpression ("v"))))));
        }
    }

    public View() {
        this.chooseProgram ();
        this.executionStack = new MyStack <> ( this.programToExecute );
        this.symTable = new MyDictionary <> ();
        this.output = new MyList <> ();
        this.programState = new PrgState ( this.executionStack , this.symTable , this.output , this.programToExecute );
        this.repo = new Repository ( programState );
        this.controller = new Controller ( this.repo );
    }

    public static void main ( String[] args ) throws MyException {
        View v = new View ();
        v.controller.allStep ();
        System.out.println (v.output );
    }
}
