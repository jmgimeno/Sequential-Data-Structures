package Stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementation of the {@link Stack} interface using contiguous memory positions
 * through an {@link ArrayList}.
 * <p>
 * Methods are provided to insert an element in the top of the stack, to obtain or to obtain and
 * remove
 * the top of the stack, to know if the stack is empty and, to know the number of elements
 * in the collection.
 *
 * @param <E> defines the type of the elements in the ArrayListStack
 * @author Juan Enrique and Juan Manuel
 */
public class ArrayListStack<E> implements Stack<E> {

    /**
     * The ArrayList in which the elements of the stack are stored.
     */
    private final ArrayList<E> elements;


    /**
     * Constructs an empty ArrayListStack.
     */
    public ArrayListStack() {
        elements = new ArrayList<>();
    }

    /**
     * Pushes an item in the top of the stack. If there is no space, it throws an {@code
     * IllegalStateException}.
     *
     * @throws IllegalStateException if the item cannot be pushed due to capacity restrictions.
     */
    @Override
    public void push(E element) {
        elements.add(element);
    }

    /**
     * Returns and eliminates the item which is in the top of the stack.
     *
     * @return the element which is in the top of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Stack");
        }
        int lastPos = elements.size() - 1;
        E res = elements.get(lastPos);
        elements.remove(lastPos);
        return res;
    }

    /**
     * Returns the element which is in the top of the stack.
     *
     * @return the element which is in the top of the stack.
     * @throws NoSuchElementException if this stack is empty.
     */
    @Override
    public E top() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Stack");
        }
        return elements.get(elements.size() - 1);
    }

    /**
     * Tests if the stack is empty.
     *
     * @return {@code true} if the stack does not contain items. Otherwise, {@code false}.
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the number of items in the stack.
     *
     * @return the number of items in the stack.
     */
    @Override
    public int size() {
        return elements.size();
    }
}
