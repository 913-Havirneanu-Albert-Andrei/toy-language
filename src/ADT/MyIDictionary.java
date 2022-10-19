package ADT;

import java.util.Collection;

public interface MyIDictionary<K , V> {
    void add (K key , V value);

    Collection<K> getKeys();

    Collection<V> getValues();

    boolean isEmpty();

    V getValue(K key);

    boolean checkIfKeyExists(K key);

    void remove(K key);

    int getSize();
}
