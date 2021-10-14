package Stack;

public interface Stack<E> {
    public void push(E element);
    public E pop();
    public E peek();
    public boolean empty();
    public int search(Object o);
}
