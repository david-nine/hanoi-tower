package pile;

import java.util.Arrays;

public class ContiguousPile<T> implements IPile<T> {

    private int counter = -1;
    private static final int DEFAULT_SIZE = 10;
    private T[] vet;

    public ContiguousPile(int size) {
        this.vet = (T[]) new Object[size];
    }

    public ContiguousPile() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void push(T obj) {
        if (this.counter < this.vet.length && !isFull()) {
            this.vet[++this.counter] = obj;
        }
    }

    @Override
    public T pop() {
        if (this.empty()) {
            return null;
        }
        return this.vet[this.counter--];
    }

    public T top() {
        if (this.empty()) {
            return null;
        }
        return this.vet[this.counter];
    }

    public int size() {
        if (this.empty()) {
            return 0;
        }
        return this.counter + 1;
    }

    @Override
    public boolean empty() {
        return this.counter == -1;
    }

    @Override
    public void release() {
        if (!this.empty()) {
            this.vet = null;
            this.counter = -1;
        }
    }

    @Override
    public boolean isFull() {
        return counter == vet.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.counter; i++) {
            stringBuilder.append(this.vet[i].toString());
        }
        return stringBuilder.toString();
    }
}
