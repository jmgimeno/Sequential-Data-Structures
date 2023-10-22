package queue;

import org.junit.jupiter.api.BeforeEach;

class ArrayBasedQueueTest extends QueueAbstractTest {

    @BeforeEach
    void setUp() {
        queue = new ArrayBasedQueue<>();
    }
}
