package queue;

import java.util.NoSuchElementException;

/**
 * First-In-First-Out (FIFO) collection. In other words, a collection in which the elements
 * are processed in order of arrival.
 * <p>
 * Methods are provided to insert an element in the collection (as last) and to obtain or
 * to obtain and remove the head of the queue.
 *
 * @param <E> defines the type of the elements in the Queue
 * @author Juan Enrique and Juan Manuel
 */
public interface Queue<E> {

    /**
     * Inserts the specified element into the queue, returning {@code true} upon success.
     * If there is no space available, it throws an {@code IllegalStateException}.
     *
     * @param e the element to be inserted.
     * @return true if the element has been added to this queue.
     * @throws IllegalStateException if the item cannot be added due to capacity restrictions.
     */
    boolean add(E e);

    /**
     * Inserts the specified element into the queue, returning {@code true} upon success.
     *
     * @param e the element to be inserted.
     * @return true if the element has been added to this queue, else false.
     */
    boolean offer(E e);

    /**
     * Returns, but does not remove, the head of this queue.
     * If the queue is empty, the method throws a {@code NoSuchElementException}.
     *
     * @return the head of this queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    E element();

    /**
     * Returns, but does not remove, the head of this queue.
     * If the queue is empty, the method returns null.
     *
     * @return the head of this queue. If the queue is empty, the method returns null.
     */
    E peek();

    /**
     * Returns and removes the head of this queue.
     * If the queue is empty, the method returns null.
     *
     * @return the head of this queue. If the queue is empty, the method returns null.
     */
    E poll();

    /**
     * Returns and removes the head of this queue.
     * If the queue is empty, it throws a {@code NoSuchElementException}.
     *
     * @return the head of this queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    E remove();

    /**
     * Tests if the queue is empty.
     *
     * @return {@code true} if the queue does not contain items. Otherwise, {@code false}.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the queue.
     *
     * @return the number of items in the queue.
     */
    int size();
}
