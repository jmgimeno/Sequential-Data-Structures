package Queue;

public interface Queue<E> {
    boolean add(E e);
    E element();
    boolean offer (E e);
    E peek();
    E poll();
    E remove();
}
