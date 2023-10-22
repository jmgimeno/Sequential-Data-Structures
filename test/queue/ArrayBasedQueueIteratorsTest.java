package queue;

import org.junit.jupiter.api.BeforeEach;

class ArrayBasedQueueIteratorsTest extends QueueIteratorAbstractTest {

    @BeforeEach
    public void setUp() {
        queue = new ArrayBasedQueue<>(5);
    }

}
