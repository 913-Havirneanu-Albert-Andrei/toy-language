package ADT;

import java.util.Stack;

public class MyStack < T > implements MyIStack < T > {
    Stack < T > myStack;

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
}
