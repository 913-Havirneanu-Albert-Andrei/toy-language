package ADT;

import java.util.Iterator;
import java.util.LinkedList;

public class MyList < T > implements MyIList < T > {

    private LinkedList < T > myList;

    public MyList ( ) {
        this.myList = new LinkedList < T > ( );
    }

    @Override
    public void addFinal ( T elem ) {
        this.myList.addLast ( elem );
    }

    @Override
    public boolean containsElem ( T elem ) {
        return this.myList.contains ( elem );
    }

    @Override
    public T getElemPos ( int position ) {
        return this.myList.get ( position );
    }

    @Override
    public void removeFromPosition ( int index ) {
        this.myList.remove ( index );
    }

    @Override
    public int size ( ) {
        return this.myList.size ( );
    }

    @Override
    public String toString() {
        String result = "";

        Iterator<T> it = (Iterator<T>) this.myList.iterator ();
        while (it.hasNext ()){
            result += it.next ().toString () + " ";
        }
        return result;
    }
}
