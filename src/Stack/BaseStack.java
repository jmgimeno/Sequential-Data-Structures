package Stack;

public interface Stack<E> {
    public void push(E element);
    public E pop();
    public E top();
    public int size();
    public boolean isEmpty();
}
