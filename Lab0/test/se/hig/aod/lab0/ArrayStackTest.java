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
class ArrayStackTest {

        private ArrayStack<Integer> stackTest;

        /**
         * Resets stack to a new empty ArrayStack-instance
         * before each test method is executed.
         */
        @BeforeEach
        void setUp() {
                int maxSize = 6;
                stackTest = new ArrayStack<Integer>(maxSize);
        }

        /**
         * Sets stack to null after each test method is executed.
         */
        @AfterEach
        void tearDown() {
                stackTest = null;
        }

        /**
         * Test method for @{@link ArrayStack#clear()}
         */
        @Test
        void testClearStack() {
                initializeList();
                stackTest.clear();

                assertTrue(stackTest.isEmpty());
        }

        /**
         * Test method for @{@link ArrayStack#isEmpty()} when stack is empty should return true
         */
        @Test
        void testIsEmptyOnEmptyStack() {
                assertTrue(stackTest.isEmpty());
        }

        /**
         * Test method for @{@link ArrayStack#isEmpty()} when stack is initialized should return false
         */
        @Test
        void testIsEmptyOnInitializedStack() {
                initializeList();
                assertFalse(stackTest.isEmpty());
        }

        /**
         * Test method for @{@link ArrayStack#isFull()} when stack is empty should return false
         */
        @Test
        void testIsFullOnEmptyStack() {
                assertFalse(stackTest.isFull());
        }

        /**
         * Test method for @{@link ArrayStack#isFull()} when stack is full should return true
         */
        @Test
        void testIsFullOnFullStack() {
                initializeList();
                stackTest.push(6);

                assertTrue(stackTest.isFull());
        }

        /**
         * Test method for @{@link ArrayStack#push(Object)} should insert element on top of the stack
         */
        @Test
        void testPushStack() {
                initializeList();
                stackTest.push(0);

                assertEquals(0, stackTest.peek());
                assertEquals(6, stackTest.getStackSize());
        }

        /**
         * Test method for @{@link ArrayStack#push(Object)} when stack is full should throw @{@link StackFullException}
         */
        @Test
        void testPushToFullStack() {
                initializeList();
                stackTest.push(6);

                assertThrows(StackFullException.class, () -> stackTest.push(7), "Push() on full list should throw StackFullException");
        }

        /**
         * Test method for @{@link ArrayStack#pop()} when stack is empty should throw @{@link StackEmptyException}
         */
        @Test
        void testPopOnEmptyStack() {
                assertThrows(StackEmptyException.class, () -> stackTest.pop(), "Pop() on empty list should throw StackEmptyException");
        }

        /**
         * Test method for @{@link ArrayStack#pop()} on initialized list should remove the top element
         */
        @Test
        void testPopOnInitializedStack() {
                initializeList();
                Integer removedItem = stackTest.pop();
                Integer topElement = stackTest.peek();

                assertEquals(1, removedItem);
                assertEquals(2, topElement);
                assertEquals(4, stackTest.getStackSize());
        }

        /**
         * Test method for @{@link ArrayStack#peek()} when stack is empty should throw StackEmptyException
         */
        @Test
        void testPeekOnEmptyStack() {
                assertThrows(StackEmptyException.class, () -> stackTest.peek(), "Peek() on empty list should throw StackEmptyException");
        }

        /**
         * Test method for @{@link ArrayStack#peek()} should return the top element in the stack
         */
        @Test
        void testPeekOnInitializedStack() {
                initializeList();
                Integer topElement = stackTest.peek();

                assertEquals(1, topElement);
        }

        private void initializeList() {
                final int[] fixture = {5, 4, 3, 2, 1};

                for (int i : fixture) {
                        stackTest.push(i);
                }

                assertEquals(5, stackTest.getStackSize());
        }
}