package queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class AbstractQueueTest {
    protected Queue<String> queue;

    @Test
    public void testQueueSize() {
        Assertions.assertEquals(0, queue.size());
        queue.offer("Element 1");
        queue.offer("Element 2");
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void testQueueIsEmpty() {
        Assertions.assertTrue(queue.isEmpty());
        queue.offer("Element 1");
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    public void testQueueOfferAndPoll() {
        queue.offer("Element 1");
        queue.offer("Element 2");
        Assertions.assertEquals("Element 1", queue.poll());
        Assertions.assertEquals(1, queue.size());
    }

    // Add more test methods as needed to cover other Queue interface methods
    @Test
    public void testQueuePeek() {
        queue.offer("Element 1");
        queue.offer("Element 2");
        Assertions.assertEquals("Element 1", queue.peek());
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void testQueueElement() {
        queue.offer("Element 1");
        queue.offer("Element 2");
        Assertions.assertEquals("Element 1", queue.element());
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    public void testQueueRemove() {
        queue.offer("Element 1");
        queue.offer("Element 2");
        Assertions.assertEquals("Element 1", queue.remove());
        Assertions.assertEquals(1, queue.size());
    }
}
