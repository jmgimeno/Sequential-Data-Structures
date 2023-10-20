package queue;

import java.util.NoSuchElementException;

public abstract class AbstractQueue<E> implements Queue<E> {
    /**
     * Tests if the queue is empty.
     *
     * @return {@code true} if the queue does not contain items. Otherwise, {@code false}.
     */
    public boolean isEmpty() {
        return size() == 0;
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
