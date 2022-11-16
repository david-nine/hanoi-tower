package pile;

import common.KnotList;

public class DynamicPile<T> implements IPile<T> {

    private KnotList<T> first;
    private KnotList<T> last;
    private int counter;

    @Override
    public void push(T obj) throws Exception {

    }

    @Override
    public T pop() throws Exception {
        return null;
    }

    @Override
    public T top() throws Exception {
        return null;
    }

    @Override
    public int size() throws Exception {
        return 0;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public void release() {

    }

    @Override
    public boolean isFull() {
        return false;
    }
}
