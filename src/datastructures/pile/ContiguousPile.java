package datastructures.pile;

public class ContiguousPile<T> implements IPile<T> {

    private int counter = 0, size;
    private T[] array;

    public ContiguousPile(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
    }

    @Override
    public void push(T obj) {
        if (!isFull()) {
            this.array[counter] = obj;
            counter++;
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            counter--;
            T obj = this.array[counter];
            this.array[counter] = null;
            return obj;
        }
        return null;
    }

    @Override
    public T top() {
        if (isEmpty())
            return null;
        return this.array[counter - 1];
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean isFull() {
        return counter == size;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.array = (T[]) new Object[this.size];
        counter = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.counter - 1; i >= 0; i--) {
            String pile = this.array[i].toString();
            stringBuilder.append(pile);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
