package ADT;

public interface MyIList<T> {
    void addFinal(T elem);

    boolean containsElem(T elem);

    T getElemPos(int position);

    void removeFromPosition(int index);

    int size();
}
