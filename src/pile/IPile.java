package pile;

public interface IPile<T> {

    void push(T obj) throws Exception;
    T pop () throws Exception;
    T top () throws Exception;
    int size() throws Exception;
    boolean empty();
    void release();
    boolean isFull();

}
