package stack;

import java.util.NoSuchElementException;

/**
 * A linear collection that only supports element insertion and removal at the top of it.
 * Concretely, it is a last-in-first-out (LIFO) stack of objects.
 * <p>
 * Methods are provided to insert an element in the top, to obtain or to obtain and remove
 * the top of the stack, to know if the stack is empty and, to know the number of elements
 * in the collection.
 *
 * @param <E> defines the type of the elements in the Stack
 * @author Juan Enrique and Juan Manuel
 */

public interface Stack<E> {

    /**
     * Pushes an item in the top of the stack.
     * If there is no space, it throws an {@code IllegalStateException}.
     *
     * @param element the element to be added.
     * @throws IllegalStateException if the item cannot be pushed due to capacity restrictions.
     */
    void push(E element);

    /**
     * Returns and eliminates the item which is in the top of the stack.
     * If the stack is empty, it throws a {@code NoSuchElementException}.
     *
     * @return the element which is in the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    E pop();

    /**
     * Returns the element which is in the top of the stack.
     * If the stack is empty, it throws a {@code NoSuchElementException}.
     *
     * @return the element which is in the top of the stack.
     * @throws NoSuchElementException if this stack is empty.
     */
    E top();

    /**
     * Tests if the stack is empty.
     *
     * @return {@code true} if the stack does not contain items. Otherwise, {@code false}.
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the stack.
     *
     * @return the number of items in the stack.
     */
    int size();
}
