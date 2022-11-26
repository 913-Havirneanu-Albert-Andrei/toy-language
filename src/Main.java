import ADT.MyDictionary;
import ADT.MyIStack;
import ADT.MyList;
import ADT.MyStack;
import Controller.Controller;
import Domain.Expressions.*;
import Domain.ProgramState.PrgState;
import Domain.Statement.*;
import Domain.Types.IntType;
import Domain.Types.StringType;
import Domain.Values.IntValue;
import Domain.Values.StringValue;
import Domain.Values.Value;
import Exception.MyException;
import Repository.IRepository;
import Repository.Repository;
import View.ExitCommand;
import View.RunExample;
import View.TextMenu;

import java.io.BufferedReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, MyException {
        MyIStack< IStmt > stack1 = new MyStack<>();
        MyIStack <IStmt> stack2 = new MyStack <>();
        MyIStack<IStmt> stack3 = new MyStack<>();
        MyIStack<IStmt> stack4 = new MyStack<>();


        IStmt example_1 = new CompStmt(
                new VariableDeclaration("x", new IntType()),
                new CompStmt(
                        new VariableAssignment("x", new ValueExpression(new IntValue(17))),
                        new PrintStatement(new VariableExpression("x"))
                )
        );

        PrgState prg1 = new PrgState(stack1, new MyDictionary <String, Value >(),  new MyList <Value>(),  new MyDictionary< StringValue, BufferedReader>() , example_1 );
        IRepository repo1 = new Repository(prg1, "log1.txt");
        Controller ctr1 = new Controller(repo1);

        IStmt example_2 = new CompStmt(
                new VariableDeclaration("x" , new IntType()),
                new CompStmt(new VariableAssignment("x", new ArithmeticExpression(
                        new ValueExpression(new IntValue(3)),
                        new ArithmeticExpression(
                                new ValueExpression(new IntValue(5)), new ValueExpression(new IntValue(7)), '*'
                        ),
                        '+'
                )
                ),
                        new PrintStatement(new VariableExpression("x"))
                )
        );
        PrgState prg2= new PrgState(stack2, new MyDictionary<String, Value>(),  new MyList<Value>() , new MyDictionary<StringValue, BufferedReader>() , example_2);
        IRepository repo2 = new Repository(prg2, "log2.txt");
        Controller ctr2 = new Controller(repo2);
        /*
        IStmt example_3 = new CompStmt(
                new VariableDeclaration("s" , new BoolType()),
                new CompStmt(new VariableDeclaration("x", new IntType()),
                        new CompStmt(
                                new VariableAssignment("s", new ValueExpression(new BoolValue(true))),
                                new CompStmt(
                                        new IfStatement(
                                                new VariableExpression("s"),
                                                new VariableAssignment("x", new ValueExpression(new IntValue(20))),
                                                new VariableAssignment("x", new ValueExpression(new IntValue(2)))
                                        ),
                                        new PrintStatement(new VariableExpression("x"))
                                )
                        )
                )
        );
        */
        IStmt example_3 = new CompStmt(new VariableDeclaration("a", new IntType()),
                new CompStmt(new VariableDeclaration("v", new IntType()), new CompStmt(new VariableAssignment("a", new ValueExpression(new IntValue(10))),
                        new CompStmt(new IfStatement(new ComparisonExpression(new VariableExpression("a"),new VariableExpression("v"), "<"),
                                new VariableAssignment("v", new ValueExpression(new IntValue(2))), new VariableAssignment("v", new ValueExpression(new IntValue(3)))),
                                new PrintStatement(new VariableExpression("v"))))));

        PrgState prg3 = new PrgState(stack3, new MyDictionary<String, Value>(),  new MyList<Value>(), new MyDictionary<StringValue, BufferedReader>() , example_3 );
        IRepository repo3 = new Repository(prg3, "log3.txt");
        Controller ctr3 = new Controller(repo3);

        IStmt example_4 = new CompStmt(
                new VariableDeclaration("fileName", new StringType()),
                new CompStmt(new VariableAssignment("fileName", new ValueExpression(new StringValue("test.txt"))),
                        new CompStmt(new OpenRFile(new VariableExpression("fileName")),
                                new CompStmt(new VariableDeclaration("x", new IntType()),
                                        new CompStmt(new ReadFile(new VariableExpression("fileName"), "x"),
                                                new CompStmt(new PrintStatement(new VariableExpression("x")),
                                                        new CompStmt(new ReadFile(new VariableExpression("fileName"), "x"),
                                                                new CompStmt(new PrintStatement(new VariableExpression("x")),
                                                                        new CloseFile(new VariableExpression("fileName"))))))))));

        PrgState prg4 = new PrgState(stack4, new MyDictionary<String, Value>(),  new MyList<Value>() , new MyDictionary<StringValue, BufferedReader>() , example_4);
        IRepository repo4 = new Repository(prg4, "log4.txt");
        Controller ctr4 = new Controller(repo4);

        TextMenu menu = new TextMenu();

        repo1.addState(prg1);
        repo2.addState(prg2);
        repo3.addState(prg3);
        repo4.addState(prg4);


        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",example_1.toString(),ctr1));
        menu.addCommand(new RunExample("2",example_2.toString(),ctr2));
        menu.addCommand(new RunExample("3",example_3.toString(),ctr3));
        menu.addCommand(new RunExample("4",example_4.toString(),ctr4));
        menu.show();
    }
}