package datastructures.pile;

import model.KnotList;

public class DynamicPile<T> implements IPile<T> {

    private KnotList<T> first;
    private KnotList<T> last;
    private int counter;

    public DynamicPile() {
        this.counter = 0;
        this.first = new KnotList<>();
        this.last = this.first;
    }

    @Override
    public void push(T obj) {
        if (this.isEmpty()) {
            this.first.setObj(obj);
            this.last = this.first;
        } else {
            this.last.setNext(new KnotList<>(obj, null));
            this.last = this.last.getNext();
        }
        this.counter++;
    }

    @Override
    public T pop() {
        T returnElement = this.last.getObj();
        if (this.counter <= 1) {
            this.clear();
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
    public T top() {
        return this.last.getObj();
    }

    @Override
    public int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return this.counter == 0;
    }

    @Override
    public void clear() {
        this.counter = 0;
        this.first = new KnotList<>();
        this.last = this.first;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        DynamicPile<String> stringPile = new DynamicPile<>();
        if (this.counter != 0) {
            KnotList<T> obj = this.first;
            while (obj.getNext() != null) {
                stringPile.push(obj.getObj().toString() + "\n");
                obj = obj.getNext();
            }
            stringPile.push(obj.getObj().toString() + "\n");
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (stringPile.top() != null) {
            stringBuilder.append(stringPile.pop());
        }
        return stringBuilder.toString();
    }
}
