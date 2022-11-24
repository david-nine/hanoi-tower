package pile;

import model.KnotList;

public class DynamicPile<T> implements IPile<T> {

    private KnotList<T> first;
    private KnotList<T> last;
    private int counter;

    public DynamicPile() {
        this.counter = 0;
        this.first = new KnotList<>();
        this.last = new KnotList<>();
    }

    @Override
    public void push(T obj) throws Exception {
        if (this.counter == 0) {
            this.first.setObj(obj);
            this.last = this.first;
        } else {
            this.last.setNext(new KnotList<>(obj, null));
            this.last = this.last.getNext();
        }
        this.counter++;
    }

    @Override
    public T pop() throws Exception {
        T returnElement = this.first.getObj();
        if (this.counter <= 1) {
            this.first = null;
            this.last = null;
        } else {
            KnotList<T> obj = this.first;
            while (obj.getNext() != this.last) {
                obj = obj.getNext();
            }
            returnElement = obj.getNext().getObj();
            this.last = obj;
            this.last.setNext(null);
        }
        this.counter--;
        return returnElement;
    }

    @Override
    public T top() throws Exception {
        if (this.last != null) {
            return this.last.getObj();
        }
        return null;
    }

    @Override
    public int size() throws Exception {
        return this.counter;
    }

    @Override
    public boolean empty() {
        return this.counter == 0;
    }

    @Override
    public void release() {
        this.counter = 0;
        this.first = new KnotList<>();
        this.last = new KnotList<>();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
