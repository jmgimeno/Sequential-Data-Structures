package queue;

import org.junit.jupiter.api.BeforeEach;

class LinkedListBasedQueueTest extends AbstractQueueTest {

    @BeforeEach
    public void setUp() {
        queue = new LinkedListBasedQueue<>();
    }
}