package queue;

import java.util.NoSuchElementException;

/**
 * Implementation of the {@link queue} interface using non-contiguous memory positions
 * through an array.
 * <p>
 * Methods are provided to insert an element at the end of the queue, to obtain or to obtain and
 * remove
 * the head of the queue, to know if the queue is empty and, to know the number of elements
 * in the collection.
 *
 * @param <E> defines the type of the elements in the ArrayListBasedQueue
 * @author Juan Enrique and Juan Manuel
 */
public class ArrayBasedQueue<E> implements Queue<E> {

    /**
     * Array in which the elements of the queue are stored.
     */
    private final Object[] elements;

    /**
     * Index of the head.
     */
    private int head = 0;

    /**
     * Number of elements in the queue.
     */
    private int size = 0;

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty ArrayBasedQueue with default capacity.
     */
    public ArrayBasedQueue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructs an empty ArrayBasedQueue with the specified capacity.
     *
     * @param capacity the capacity of the ArrayBasedQueue.
     */
    public ArrayBasedQueue(int capacity) {
        elements = new Object[Math.max(capacity, 1)];
    }

    /**
     * Inserts the specified element into the queue, returning {@code true} upon success.
     * If there is no space available, it throws an {@code IllegalStateException}.
     *
     * @param e the element to be inserted.
     * @return true if the element has been added to this queue.
     * @throws IllegalStateException if the item cannot be added due to capacity restrictions.
     */
    @Override
    public boolean add(E e) {
        if (!offer(e))
            throw new IllegalStateException("No free space");

        return true;
    }

    /**
     * Inserts the specified element into the queue, returning {@code true} upon success.
     *
     * @param e the element to be inserted.
     * @return true if the element has been added to this queue, else false.
     */
    @Override
    public boolean offer(E e) {
        if (size == elements.length)
            return false;
        else {
            elements[(head + size) % elements.length] = e;
            size++;
        }

        return true;
    }

    /**
     * Returns, but does not remove, the head of this queue.
     * If the queue is empty, the method throws a {@code NoSuchElementException}.
     *
     * @return the head of this queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public E element() {
        E e = peek();
        if (e == null)
            throw new NoSuchElementException();

        return e;
    }

    /**
     * Returns, but does not remove, the head of this queue.
     * If the queue is empty, the method returns null.
     *
     * @return the head of this queue. If the queue is empty, the method returns null.
     */
    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (size == 0)
            return null;

        return (E) elements[head];
    }

    /**
     * Returns and removes the head of this queue.
     * If the queue is empty, the method returns null.
     *
     * @return the head of this queue. If the queue is empty, the method returns null.
     */
    @Override
    public E poll() {
        if (size == 0)
            return null;
        else {
            @SuppressWarnings("unchecked")
            E e = (E) elements[head];
            elements[head] = null;
            head = (head + 1) % elements.length;
            size--;
            return e;
        }
    }

    /**
     * Returns and removes the head of this queue.
     * If the queue is empty, it throws a {@code NoSuchElementException}.
     *
     * @return the head of this queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    @Override
    public E remove() {
        E e = poll();
        if (e == null)
            throw new NoSuchElementException();

        return e;
    }

}
