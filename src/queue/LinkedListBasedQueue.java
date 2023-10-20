package queue;

import java.util.LinkedList;

/**
 * Implementation of the {@link queue} interface using non-contiguous memory positions
 * through a {@link LinkedList}.
 * <p>
 * Methods are provided to insert an element at the end of the queue, to obtain or to obtain and
 * remove
 * the head of the queue, to know if the queue is empty and, to know the number of elements
 * in the collection.
 *
 * @param <E> defines the type of the elements in the LinkedListBasedQueue
 * @author Juan Enrique and Juan Manuel
 */
public class LinkedListBasedQueue<E> extends AbstractQueue<E> implements Queue<E> {
    /**
     * The LinkedList in which the elements of the queue are stored.
     */
    private final LinkedList<E> elements;

    /**
     * Constructs an empty LinkedListBasedQueue.
     */
    public LinkedListBasedQueue() {
        elements = new LinkedList<>();
    }

    /**
     * Inserts the specified element into the queue, returning {@code true} upon success.
     *
     * @param e the element to be inserted.
     * @return true when the element has been added to this queue.
     */
    @Override
    public boolean add(E e) {
        return offer(e);
    }

    /**
     * Inserts the specified element into the queue, returning {@code true} upon success.
     *
     * @param e the element to be inserted.
     * @return true when the element has been added to this queue.
     */
    @Override
    public boolean offer(E e) {
        elements.addLast(e);

        return true;
    }


    /**
     * Returns, but does not remove, the head of this queue.
     * If the queue is empty, the method returns null.
     *
     * @return the head of this queue. If the queue is empty, the method returns null.
     */
    @Override
    public E peek() {
        if (elements.isEmpty())
            return null;

        return elements.getFirst();
    }

    /**
     * Returns and removes the head of this queue.
     * If the queue is empty, the method returns null.
     *
     * @return the head of this queue. If the queue is empty, the method returns null.
     */
    @Override
    public E poll() {
        if (elements.isEmpty())
            return null;
        else
            return elements.removeFirst();
    }

    /**
     * Returns the number of items in the queue.
     *
     * @return the number of items in the queue.
     */
    @Override
    public int size() {
        return elements.size();
    }
}
