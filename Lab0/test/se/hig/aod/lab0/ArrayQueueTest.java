package se.hig.aod.lab0;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Selma Abbassi
 */
class ArrayQueueTest {
        ArrayQueue<Integer> queueTest;
        private final int maxSize = 5;
        private final int[] fixture = {1, 2, 3, 4, 5};

        /**
         * Resets queue to a new empty ArrayQueue-instance
         * before each test method is executed.
         */
        @BeforeEach
        void setUp() {
                queueTest = new ArrayQueue<>(maxSize);
        }

        /**
         * Sets queue to null after each test method is executed.
         */
        @AfterEach
        void tearDown() {
                queueTest = null;
        }

        /**
         * Test method for @{@link ArrayQueue#clear()}
         */
        @Test
        void testClearQueueOnEmptyQueue() {
                queueTest.clear();

                assertEquals(0, queueTest.getQueueSize());
        }

        /**
         * Test method for @{@link ArrayQueue#clear()}
         */
        @Test
        void testClearQueueOnInitializedQueue() {
                initializeQueue();
                queueTest.clear();

                assertEquals(0, queueTest.getQueueSize());
        }

        /**
         * Test method for @{@link ArrayQueue#isEmpty()} on empty queue should be true
         */
        @Test
        void testIsEmptyOnEmptyQueue() {
                assertTrue(queueTest.isEmpty());
        }

        /**
         * Test method for @{@link ArrayQueue#isEmpty()} on initialized queue should be false
         */
        @Test
        void testIsEmptyOnInitializedQueue() {
                initializeQueue();
                assertFalse(queueTest.isEmpty());
        }

        /**
         * Test method for @{@link ArrayQueue#isFull()} on empty queue should be false
         */
        @Test
        void testIsFullOnEmptyQueue() {
                assertFalse(queueTest.isFull());
        }

        /**
         * Test method for @{@link ArrayQueue#isFull()} on full queue should be true
         */
        @Test
        void testIsFullOnInitializedQueue() {
                initializeQueue();
                assertTrue(queueTest.isFull());
        }

        /**
         * Test method for @{@link ArrayQueue#enqueue(Object)} should append elements to back of queue
         */
        @Test
        void testEnqueueAppendsElementToBack() {
                queueTest.enqueue(1);
                queueTest.enqueue(2);

                assertEquals(1, queueTest.getFront());
                assertEquals(2, queueTest.getBack());
        }

        /**
         * Test method for @{@link ArrayQueue#enqueue(Object)} should throw @{@link QueueFullException} on full queue
         */
        @Test
        void testEnqueueOnFullQueue() {
                initializeQueue();
                assertThrows(QueueFullException.class, () -> queueTest.enqueue(6), "Enqueue() on full list should throw QueueFullException");
        }

        /**
         * Test method for @{@link ArrayQueue#dequeue()} should remove elements from front of queue
         */
        @Test
        void testDequeueRemovesElementFromFront() {
                initializeQueue();

                assertEquals(1, queueTest.getFront());

                Integer removedElement = queueTest.dequeue();

                assertEquals(1, removedElement);
                assertEquals(2, queueTest.getFront());
        }

        /**
         * Test method for @{@link ArrayQueue#dequeue()} should throw @{@link QueueEmptyException} on empty queue
         */
        @Test
        void testDequeueOnEmptyList() {
                assertThrows(QueueEmptyException.class, () -> queueTest.dequeue(), "Dequeue() on empty list should throw QueueEmptyException");
        }

        /**
         * Test method for @{@link ArrayQueue#getFront()} should return first element in queue
         */
        @Test
        void testGetFront() {
                initializeQueue();
                assertEquals(1, queueTest.getFront());
        }

        private void initializeQueue() {
                for (int i = 0; i < maxSize; i++) {
                        queueTest.enqueue(fixture[i]);
                }
                assertEquals(maxSize, queueTest.getQueueSize());
        }
}