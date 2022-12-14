package ADT;

import Domain.Statement.IStmt;

import java.util.Stack;

public class MyStack < T > implements MyIStack < T > {
    Stack < T > myStack;

    public MyStack( T e ) {
        this.myStack = new Stack<> ();
        this.myStack.push ( e );
    }

    public MyStack ( ) {
        this.myStack = new Stack < T > ( );
    }

    @Override
    public void push ( T elem ) {
        this.myStack.push ( elem );
    }

    @Override
    public T pop ( ) {
        return this.myStack.pop ( );
    }

    @Override
    public boolean isEmpty ( ) {
        return this.myStack.isEmpty ( );
    }

    @Override
    public String toString() {
        String str = "";
        for (T element : this.myStack) {
            str += element;
        }
        return str.toString ();
    }

}
