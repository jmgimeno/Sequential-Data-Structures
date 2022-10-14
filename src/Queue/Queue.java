package Queue;


/**
 * First-In-First-Out (FIFO) collection. In other words, a collection in which the elements are processed in order of arrival.
 *
 * <p> Methods are provided to insert an element in the collection and to obtain or to obtain and remove the head of the queue.</p>
 *
 * @author Juan Enrique and Juan Manuel
 *
 * @param <E> defines the type of the elements in the Queue
 */
public interface Queue<E> {
    boolean add(E e);
    E element();
    boolean offer (E e);
    E peek();
    E poll();
    E remove();
}
