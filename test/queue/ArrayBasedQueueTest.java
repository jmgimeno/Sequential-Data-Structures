package queue;

import org.junit.jupiter.api.BeforeEach;

class ArrayBasedQueueTest extends AbstractQueueTest {

    @BeforeEach
    public void setUp() {
        queue = new ArrayBasedQueue<>();
    }

}