package ADT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import Exception.MyException;
public class MyHeap<V> implements MyIHeap<V>{

    private HashMap<Integer , V> dict;
    private int nextPosition;

    public MyHeap () {
        this.dict = new HashMap <>();
        this.nextPosition = 0;
    }

    @Override
    public void put ( V value ) {
        this.nextPosition += 1;
        this.dict.put( this.nextPosition , value);
    }

    @Override
    public Collection elements ( ) {
        return this.dict.values();
    }

    @Override
    public V get ( int key ) {
        return this.dict.get(key);
    }

    @Override
    public boolean isEmpty ( ) {
        return this.dict.isEmpty();
    }

    @Override
    public Collection < Integer > keys ( ) {
        return this.dict.keySet();
    }

    @Override
    public V remove ( int key ) {
        return this.dict.remove(key);
    }

    @Override
    public int size ( ) {
        return this.dict.size();
    }

    @Override
    public boolean contains ( int key ) {
        return this.dict.containsKey(key);
    }

    @Override
    public int getLastPosition ( ) {
        return this.nextPosition;
    }

    @Override
    public void explicitPut ( int key , V value ) {
        this.dict.put(key , value);
    }

    @Override
    public Map<Integer , V> entrySet ( ) {
        return this.dict;
    }

    @Override
    public int generateNextPosition ( ) {
        this.nextPosition ++;
        return this.nextPosition;
    }

    @Override
    public void addEntrySet ( Map newEntrySet ) throws MyException {
        if(!(newEntrySet instanceof HashMap ))
            throw new MyException("addEntrySet used not with a hashmap");
        this.dict = (HashMap<Integer , V>) newEntrySet;
    }

    @Override
    public String toString() {
        String result = "";
        Iterator <Integer> it = (Iterator< Integer>) this.dict.keySet().iterator();
        while (it.hasNext()){
            Integer key = it.next();
            V value = this.dict.get(key);
            result += key.toString() + " -> " + value.toString() + "\n";
        }
        return result;
    }

}
