package Queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListBasedQueue<E> implements Queue<E>{
    private LinkedList<E> elements;  // LinkedList in which the elements of the queue are stored

    public LinkedListBasedQueue() {
        elements = new LinkedList<>();
    }

    @Override
    public boolean add(E e) {
        return offer(e);
    }

    @Override
    public boolean offer(E e) {
        elements.addLast(e);

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
    public E poll() {
        if(elements.isEmpty())
            return null;
        else
            return elements.removeFirst();
    }

    @Override
    public E element() {
        E e = peek();
        if(e == null)
            throw new NoSuchElementException();

        return e;
    }

    @Override
    public E peek() {
        if(elements.isEmpty())
            return null;

        return elements.getFirst();
    }
}
