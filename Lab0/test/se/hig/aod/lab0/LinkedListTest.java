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

class LinkedListTest {

        private LinkedList<Integer> listUnderTest;
        private final int[] fixture = {1, 2, 3, 4, 5};

        /**
         * Resets list to a new empty LinkedList-instance
         * before each test method is executed.
         *
         * @throws Exception
         */
        @BeforeEach
        void setUp() throws Exception {
                listUnderTest = new LinkedList<Integer>();
        }

        /**
         * Sets list to null after each test method is executed.
         *
         * @throws Exception
         */
        @AfterEach
        void tearDown() throws Exception {
                listUnderTest = null;
        }

        /**
         * Test method for {@link LinkedList#isEmpty()}.
         */
        @Test
        void testEmptyListIsEmpty() {
                assertTrue(listUnderTest.isEmpty(), "An empty list instance should not contain any item");
                assertEquals(0, listUnderTest.numberOfElements());
        }

        /**
         * Test method for {@link LinkedList#isEmpty()}.
         */
        @Test
        void testInitializedListIsNotEmpty() {
                initializeList();

                assertFalse(listUnderTest.isEmpty(), "A list instance containing elements should not be empty");
                assertEquals(5, listUnderTest.numberOfElements());
        }

        /**
         * Test method for {@link LinkedList#clear()}.
         */
        @Test
        void testClearOnEmptyList() {
                listUnderTest.clear();

                assertTrue(listUnderTest.isEmpty(), "An empty list instance that is cleared should not contain any item");
                assertEquals(0, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#clear()}
         */
        @Test
        void testClearInitializedList() {
                initializeList();
                listUnderTest.clear();

                assertTrue(listUnderTest.isEmpty(), "An list that is cleared should not contain any item");
                assertEquals(0, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#numberOfElements()}
         */
        @Test
        void testNumberOfElements() {
                initializeList();
                listUnderTest.insertFirst(6);

                assertEquals(6, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#insertFirst(Object)}
         */
        @Test
        void testInsertFirstOnEmptyList() {
                listUnderTest.insertFirst(1);

                assertEquals(1, listUnderTest.getFirst());
                assertEquals(1, listUnderTest.getLast());
                assertEquals(1, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#insertFirst(Object)}
         */
        @Test
        void testInsertFirstOnInitializedList() {
                initializeList();
                listUnderTest.insertFirst(0);

                assertEquals(0, listUnderTest.getFirst());
                assertEquals(6, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#insertLast(Object)}
         */
        @Test
        void testInsertLastOnEmptyList() {
                listUnderTest.insertLast(1);

                assertEquals(1, listUnderTest.getFirst());
                assertEquals(1, listUnderTest.getLast());
                assertEquals(1, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#insertLast(Object)}
         */
        @Test
        void testInsertLastOnInitializedList() {
                initializeList();
                listUnderTest.insertLast(6);

                assertEquals(6, listUnderTest.getLast());
                assertEquals(6, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#removeFirst()}
         */
        @Test
        void testRemoveFirstOnEmptyList() {
                assertThrows(ListEmptyException.class, () -> listUnderTest.removeFirst(), "RemoveFirst() on empty list should throw ListEmptyException");
        }

        /**
         * Test method for @{@link LinkedList#removeFirst()}
         */
        @Test
        void testRemoveFirstOnInitializedList() {
                initializeList();

                Integer headData = listUnderTest.removeFirst();
                assertEquals(2, headData);
                assertEquals(4, listUnderTest.numberOfElements());
        }

        /**
         * Test method for @{@link LinkedList#removeLast()}
         */
        @Test
        void testRemoveLastOnEmptyList() {
                assertThrows(ListEmptyException.class, () -> listUnderTest.removeLast(), "RemoveLast() on empty list should throw ListEmptyException");
        }

        /**
         * Test method for @{@link LinkedList#removeLast()}
         */
        @Test
        void testRemoveLastOnInitializedList() {
                initializeList();

                Integer lastData = listUnderTest.removeLast();
                assertEquals(4, lastData);
                assertEquals(4, listUnderTest.numberOfElements());
        }

        /**
         * Test method for {@link LinkedList#getFirst()}.
         */
        @Test
        void testGetFirstOnEmptyList() {
                assertThrows(ListEmptyException.class, () -> listUnderTest.getFirst(), "GetFirst() on empty list should throw ListEmptyException");
        }

        /**
         * Test method for {@link LinkedList#getFirst()}.
         */
        @Test
        void testGetFirstOnInitializedList() {
                initializeList();
                assertEquals(1, listUnderTest.getFirst(), "GetFirst() should return first element in list");
        }

        /**
         * Test method for @{@link LinkedList#getLast()}
         */
        @Test
        void testGetLastOnEmptyList() {
                assertThrows(ListEmptyException.class, () -> listUnderTest.getLast(), "GetLast() on empty list should throw ListEmptyException");
        }

        /**
         * Test method for @{@link LinkedList#getLast()}
         */
        @Test
        void testGetLastOnInitializedList() {
                initializeList();
                assertEquals(5, listUnderTest.getLast(), "GetLast() should return last element in list");
        }

        /**
         * Test method for @{@link LinkedList#toStringRecursive()}
         */
        @Test
        void testToStringRecursiveOnEmptyList() {
                String listAsString = listUnderTest.toStringRecursive();
                assertEquals("[]", listAsString);
        }

        /**
         * Test method for @{@link LinkedList#toStringRecursive()}
         */
        @Test
        void testToStringRecursiveOnInitializedList() {
                initializeList();

                String listAsString = listUnderTest.toStringRecursive();
                assertEquals("[1,2,3,4,5]", listAsString);
        }

        /**
         * Test method for @{@link LinkedList#toStringReverseRecursive()}
         */
        @Test
        void testToStringReverseRecursiveOnEmptyList() {
                String listAsString = listUnderTest.toStringReverseRecursive();
                assertEquals("[]", listAsString);
        }

        /**
         * Test method for @{@link LinkedList#toStringReverseRecursive()}
         */
        @Test
        void testToStringReverseRecursiveOnInitializedList() {
                initializeList();

                String listAsString = listUnderTest.toStringReverseRecursive();
                assertEquals("[5,4,3,2,1]", listAsString);
        }

        private void initializeList() {
                for (int i = 0; i < fixture.length; i++) {
                        listUnderTest.insertLast(fixture[i]);
                }

                assertEquals(5, listUnderTest.numberOfElements());
        }

}
