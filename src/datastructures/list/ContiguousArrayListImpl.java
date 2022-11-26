package datastructures.list;

public class ContiguousArrayListImpl<T> implements IList<T> {

    private T[] instance;
    private boolean resizable;
    private int initialCapacity;
    private final static int DEFAULT_CAPACITY = 10;
    private int counter = 0;

    public ContiguousArrayListImpl() {
        this(DEFAULT_CAPACITY, true);
    }

    public ContiguousArrayListImpl(int size) {
        this(size, true);
    }

    public ContiguousArrayListImpl(int size, boolean resizable) {
        this.instance = (T[]) new Object[size];
        this.resizable = resizable;
        this.initialCapacity = size;
    }

    public boolean isFull() {
        return this.counter == this.instance.length && !this.resizable;
    }

    @Override
    public int size() {
        return this.counter;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(T compare) {
        for (T object : this.instance) {
            if (object == compare) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T obj) {
        this.instance[this.counter] = obj;
        this.counter++;
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public void clear() {
        if (this.resizable) {
            this.instance = (T[]) new Object[this.initialCapacity];
        }
        this.counter = 0;
    }

    @Override
    public T get(int index) {
        return this.instance[index];
    }

    @Override
    public T set(int index, T element) {
        if ((index - this.counter) < 1) {
            T objectToSubtract = this.instance[index];
            this.instance[index] = element;
            if (index == this.counter + 1) {
                this.counter++;
            }
            return objectToSubtract;
        }
        throw new IndexOutOfBoundsException(String.format("Index %s out of bounds for length %s", index, this.size()));
    }

    @Override
    public void add(int index, T element) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public T remove(int index) {
        if (index <= this.counter) {
            T itemToRemove = this.instance[index];
            for (int i = 0; i <= this.counter; i++) {
                this.instance[i] = this.instance[i + 1];
            }
            this.instance[this.counter] = null;
            this.counter--;
            return itemToRemove;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object compare) {
        for (int i = 0; i < this.instance.length; i++) {
            if (this.instance[i] == compare) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object compare) {
        for (int i = this.counter; i > -1; i--) {
            if (this.instance[i] == compare) {
                return i;
            }
        }
        return -1;
    }
}
