package queue;

import java.util.*;

/**
 * Implementation of the {@link Queue} interface using contiguous memory positions using a
 * fixes size array and not allowing {@code null} elements.
 *
 * <p>
 * This implementation also shows how to use the abstract classes provided in the Java Collections
 * Framework to simplify the implementation of a concrete class.
 *
 * @param <E> defines the type of the elements in the ArrayListBasedQueue
 * @author Juan Enrique Garrido, Juan Manuel Gimeno
 */
public class ArrayBasedQueue<E> extends AbstractQueue<E> implements Queue<E> {

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Array in which the elements of the queue are stored.
     */
    private final Object[] elements;

    /**
     * Index of the head. Position of the element to be retrieved by {@link #poll()}.
     */
    private int head = 0;

    /**
     * Index of the tail. Position of the element to be inserted by {@link #offer(Object)}.
     */
    private int tail = 0;

    /**
     * Number of elements in the queue.
     */
    private int size = 0;


    /**
     * Count of modifications to the queue.
     */
    private int modCount = 0;

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
        elements = new Object[Math.max(1, capacity)];
    }

    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     * {@code false}
     * @throws ClassCastException       if the class of the specified element
     *                                  prevents it from being added to this queue
     * @throws NullPointerException     if the specified element is null and
     *                                  this queue does not permit null elements
     * @throws IllegalArgumentException if some property of this element
     *                                  prevents it from being added to this queue
     */
    @Override
    public boolean offer(E e) {
        Objects.requireNonNull(e, "this queue does not permit null elements");
        if (size == elements.length)
            return false;

        elements[tail] = e;
        tail = tail < elements.length - 1 ? tail + 1 : 0;
        size++;
        modCount++;
        return true;
    }


    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
        if (size == 0)
            return null;

        @SuppressWarnings("unchecked")
        E e = (E) elements[head];
        elements[head] = null;
        head = head < elements.length - 1 ? head + 1 : 0;
        size--;
        modCount++;
        return e;
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if (size == 0)
            return null;

        return (E) elements[head];
    }

    /**
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {

        int diffHead = 0;
        int lastRet = -1;
        int expectedModCount = modCount;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return diffHead != size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (modCount != expectedModCount)
                throw new IllegalStateException("the queue has been modified");
            if (diffHead == size)
                throw new NoSuchElementException();
            int cursor = head + diffHead;
            lastRet = cursor < elements.length ? cursor : cursor - elements.length;
            @SuppressWarnings("unchecked")
            E e = (E) elements[lastRet];
            diffHead++;
            return e;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method
         *                                       has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         */
        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new IllegalStateException("the queue has been modified");
            if (lastRet < 0)
                throw new IllegalStateException("you should call next() before remove()");
            if (head < tail) {
                // 0 <= head  <= lastRet < tail < elements.length
                System.arraycopy(elements, lastRet + 1, elements, lastRet, tail - lastRet - 1);
                elements[tail] = null;
                tail--;
            } else if (head <= lastRet) {
                // 0 <= tail <= head <= lastRet < elements.length
                System.arraycopy(elements, lastRet + 1, elements, lastRet, elements.length - lastRet - 1);
                elements[elements.length - 1] = elements[0];
                System.arraycopy(elements, 1, elements, 0, tail - 1);
                elements[tail] = null;
                tail = tail == 0 ? elements.length - 1 : tail - 1;
            } else {
                // 0 <= lastRet < tail <= head < elements.length
                System.arraycopy(elements, lastRet + 1, elements, lastRet, tail - lastRet - 1);
                elements[tail] = null;
                tail--;
            }
            diffHead--;
            size--;
            lastRet = -1;
            modCount++;
            expectedModCount++;
        }
    }
}
