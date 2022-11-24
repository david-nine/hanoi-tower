package model;

public class KnotList<T> {

    private T obj;
    private KnotList<T> next;

    public KnotList() {
    }

    public KnotList(KnotList<T> next) {
        this.next = next;
    }

    public KnotList(T obj, KnotList<T> next) {
        this.obj = obj;
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public KnotList<T> getNext() {
        return next;
    }

    public void setNext(KnotList<T> next) {
        this.next = next;
    }
}
