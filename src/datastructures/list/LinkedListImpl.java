package datastructures.list;

import model.KnotList;

public class LinkedListImpl<T> implements IList<T> {

    private KnotList<T> first;
    private KnotList<T> last;
    private int counter;

    public LinkedListImpl() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public boolean contains(T obj) {
        KnotList<T> temp = this.first;
        while (temp != null && temp.getObj() != obj) {
            temp = temp.getNext();
        }
        return temp != null && temp.getObj() != null;
    }

    @Override
    public boolean add(T t) {
        if (isEmpty()) {
            this.first = new KnotList<>(t, null);
            this.last = this.first;
        } else {
            this.last.setNext(new KnotList<>(t, null));
            this.last = this.last.getNext();
        }
        this.counter++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public T get(int index) {
        if (index >= counter || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == counter - 1) {
            return this.last.getObj();
        }

        KnotList<T> aux = this.first;
        for (int i = 0; i < this.size(); i++) {
            if (index == i) {
                return aux.getObj();
            }
            aux = aux.getNext();
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index > counter && index >= 0) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            this.add(element);
        } else if (index == 0) {
            first = new KnotList<>(element, first);
            counter++;
        } else {
            KnotList<T> temp = this.first;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(new KnotList<>(element, temp.getNext()));
            if (index == counter) {
                last = temp.getNext();
            }
            counter++;
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int indexOf(Object obj) {
        int count = 0;

        KnotList<T> temp = this.first;
        while (temp.getNext() != null) {
            if (temp.getObj() == obj) {
                return count;
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int count = 0;
        int lastIndex = -1;
        KnotList<T> temp = this.first;
        while (temp.getNext() != null) {
            if (temp.getObj() == obj) {
                lastIndex = count;
            }
            temp = temp.getNext();
            count++;
        }
        return lastIndex;
    }
}
