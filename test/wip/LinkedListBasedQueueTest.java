package wip;

import org.junit.jupiter.api.BeforeEach;

class LinkedListBasedQueueTest extends QueueAbstractTest {

    @BeforeEach
    void setUp() {
        queue = new LinkedListBasedQueue<>();
    }
}
