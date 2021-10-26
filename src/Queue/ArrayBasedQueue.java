package Queue;

import java.util.NoSuchElementException;

public class ArrayBasedQueue<E> implements Queue<E> {
    private Object[] elements;  // Array in which the elements of the queue are stored
    private int head = 0; // The index of the head
    private int size = 0; // Number of elements in the queue

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayBasedQueue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayBasedQueue(int capacity) {
        elements = new Object[(capacity < 1) ? 1 : capacity];
    }

    @Override
    public boolean add(E e) {
        if(!offer(e))
            throw new IllegalStateException("No free space");

        return true;
    }

    @Override
    public boolean offer(E e) {
        if(size == elements.length)
            return false;
        else {
            elements[(head + size) % elements.length] = e;
            size++;
        }

        return true;
    }

    @Override
    public E remove() {
        E e = poll();
        if(e == null)
            throw new NoSuchElementException();

        return e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E poll() {
        if(size == 0)
            return null;
        else {
            E e = (E) elements[head];
            elements[head] = null;
            head = (head + 1) % elements.length;
            size--;
            return e;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E element() {
        E e = peek();
        if(e == null)
            throw new NoSuchElementException();

        return (E) elements[head];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if(size == 0)
            return null;

        return (E) elements[head];
    }

}
