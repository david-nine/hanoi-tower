package pile;

public interface IPile<T> {

    void push(T obj);

    T pop();

    T top();

    int size();

    boolean empty();

    void release();

    boolean isFull();

}
