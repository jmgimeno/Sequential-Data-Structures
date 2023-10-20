package wip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayBasedQueueIteratorsTest {

    Queue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new ArrayBasedQueue<>(5);
    }

    @Test
    void fullIteration() {
        // 0 --- head --- tail --- size --- capacity
        var elems = List.of(1, 2, 3, 4, 5);
        elems.forEach(queue::offer);
        var iteration = new ArrayList<>(queue);
        assertEquals(elems, iteration);
    }

    @Test
    void removedPrefixIteration() {
        var elems = List.of(1, 2, 3, 4, 5);
        elems.forEach(queue::offer);
        queue.poll();
        queue.poll();
        var iteration = new ArrayList<>(queue);
        assertEquals(List.of(3, 4, 5), iteration);
    }

    @Test
    void removedPrefixAndAddedFullIteration() {
        var elems = List.of(1, 2, 3, 4, 5);
        elems.forEach(queue::offer);
        queue.poll();
        queue.poll();
        queue.offer(6);
        queue.offer(7);
        var iteration = new ArrayList<>(queue);
        assertEquals(List.of(3, 4, 5, 6, 7), iteration);
    }
}
