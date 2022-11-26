package datastructures.list;

public interface IList<T> {

    int size();

    boolean add(T obj);

    boolean remove(T obj);

    void clear();

    T get(int index);

    T set(int index, T element);

    void add(int index, T element);

    T remove(int index);

    int indexOf(T compare);

    int lastIndexOf(T compare);

    boolean isFull();

    boolean isEmpty();

    boolean contains(T compare);

}
