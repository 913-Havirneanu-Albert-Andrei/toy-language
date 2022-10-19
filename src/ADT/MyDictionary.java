package ADT;
import java.util.Collection;
import java.util.HashMap;

public class MyDictionary<K , V> implements MyIDictionary<K,V> {
    private HashMap<K , V> myDictionary;

    public MyDictionary(){
        this.myDictionary = new HashMap<K , V>();
    }

    @Override
    public Collection<K> getKeys() {
        return this.myDictionary.keySet();
    }

    @Override
    public void add(K key , V value){
        this.myDictionary.put(key , value);
    }

    @Override
    public Collection<V> getValues() {
        return this.myDictionary.values();
    }

    @Override
    public boolean isEmpty() {
        return this.myDictionary.isEmpty();
    }

    @Override
    public V getValue(K key) {
        return this.myDictionary.get(key);
    }

    @Override
    public boolean checkIfKeyExists(K key) {
        return this.myDictionary.containsKey(key);
    }

    @Override
    public void remove(K key) {
        this.myDictionary.remove(key);
    }

    @Override
    public int getSize() {
        return this.myDictionary.size();
    }


}
