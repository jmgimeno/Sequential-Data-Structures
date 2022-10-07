package Stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayListStack<E> implements Stack<E> {
    private final ArrayList<E> elements;

    public ArrayListStack() {
        elements = new ArrayList<>();
    }

    @Override
    public void push(E element) {
        elements.add(element);
    }

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

    @Override
    public E top() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Stack");
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }
}
