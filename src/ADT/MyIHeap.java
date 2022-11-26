package ADT;

import Exception.MyException;
import java.util.Collection;
import java.util.Map;

public interface MyIHeap<V> {
    void put(V value);

    public Collection<V> elements();

    public V get(int key);

    public boolean isEmpty();

    public Collection<Integer> keys();

    public V remove(int key);

    public int size();

    boolean contains(int key);

    int getLastPosition();

    void explicitPut(int key , V value);

    Map <Integer , V> entrySet();

    void addEntrySet(Map<Integer , V> newEntrySet) throws MyException;

    int generateNextPosition();

}
