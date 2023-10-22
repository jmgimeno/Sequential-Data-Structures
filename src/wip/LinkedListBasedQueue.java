package wip;

import java.util.*;

/**
 * Implementation of the {@link Queue} interface backed by a {@link LinkedList} and
 * not allowing {@code null} elements.
 *
 * <p>
 * This implementation also shows how to use the abstract classes provided in the Java Collections
 * Framework to simplify the implementation of a concrete class.
 *
 * @param <E> defines the type of the elements in the ArrayListBasedQueue
 * @author Juan Manuel Gimeno
 */
public class LinkedListBasedQueue<E> extends AbstractQueue<E> implements Queue<E> {

    /**
     * Underlying {@link LinkedList} for the elements of the queue
     */
    private final LinkedList<E> elements;

    /**
     * Cre
     */
    public LinkedListBasedQueue() {
        elements = new LinkedList<>();
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
        elements.addLast(e);
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
        return elements.pollFirst();
    }
    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E peek() {
        return elements.peek();
    }

    /**
     * Returns the number of elements in this collection.
     * @return the number of elements in this collection
     */
    @Override
    public int size() {
        return elements.size();
    }

    /**
     * Returns an iterator over the elements contained in this collection.
     *
     * @return an iterator over the elements contained in this collection
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final Iterator<E> iterator = elements.iterator();
            @Override
            public boolean hasNext() {
                    return iterator.hasNext();
            }

            @Override
            public E next() {
                return iterator.next();
            }
        };
    }
}
