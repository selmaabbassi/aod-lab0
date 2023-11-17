package se.hig.aod.lab0;

/**
 * A LinkedList implementation of the Abstract Data Type @{@link List}
 *
 * @author Selma Abbassi
 */
public class LinkedList<T> implements PrintableList<T> {

        ListNode<T> head;
        private int numOfElements;

        public LinkedList() {
                this.head = null;
                this.numOfElements = 0;
        }

        @Override
        public boolean isEmpty() {
                return numOfElements == 0;
        }

        @Override
        public void clear() {
                if (!isEmpty()) {
                        removeFirst();
                }
                numOfElements = 0;
        }

        @Override
        public int numberOfElements() {
                return numOfElements;
        }

        @Override
        public void insertFirst(T t) {
                if (isEmpty()) {
                        this.head = new ListNode<>(t, null);
                } else {
                        this.head = new ListNode<>(t, head);
                }
                numOfElements++;
        }

        @Override
        public void insertLast(T t) {
                if (isEmpty()) {
                        insertFirst(t);
                } else {
                        ListNode<T> current = head;
                        while (current.next != null) {
                                current = current.next;
                        }

                        current.next = new ListNode<>(t, null);
                        numOfElements++;
                }
        }

        @Override
        public T removeFirst() {
                if (isEmpty()) {
                        throw new ListEmptyException("Removing first element from an empty list is not allowed");
                } else {
                        head = head.next;
                        numOfElements--;
                        return head.data;
                }
        }

        @Override
        public T removeLast() {
                if (isEmpty()) {
                        throw new ListEmptyException("Removing last element from an empty list is not allowed");
                } else if (numOfElements == 1) {
                        return removeFirst();
                } else {
                        ListNode<T> current = head;
                        while (current.next != null) {
                                current = current.next;
                                if (current.next.next == null) {
                                        current.next = null;
                                }
                        }
                        numOfElements--;
                        return current.data;
                }
        }

        @Override
        public T getFirst() {
                if (isEmpty()) {
                        throw new ListEmptyException("List is empty");
                }
                return head.data;
        }

        @Override
        public T getLast() {
                if (isEmpty()) {
                        throw new ListEmptyException("List is empty");
                } else {
                        ListNode<T> current = head;
                        while (current.next != null) {
                                current = current.next;
                        }
                        return current.data;
                }
        }

        @Override
        public String toStringRecursive() {
                StringBuilder builder = new StringBuilder();

                if (!isEmpty()) {
                        builder = head.toStringNodeRecursive(builder);
                }

                builder.insert(0, "[");
                builder.append("]");
                return builder.toString();
        }

        @Override
        public String toStringReverseRecursive() {
                StringBuilder builder = new StringBuilder();

                if (!isEmpty()) {
                        builder = head.toStringNodeRecursive(builder);
                        builder.reverse();
                }

                builder.insert(0, "[");
                builder.append("]");

                return builder.toString();
        }

        /**
         * Nested class @{@link ListNode} that stores data of generic type D and points to the next @{@link ListNode} in the @{@link LinkedList}
         *
         * @param <D>
         * @author Selma Abbassi
         */
        static class ListNode<D> {
                D data;
                ListNode<D> next;

                public ListNode(D data, ListNode<D> next) {
                        this.data = data;
                        this.next = next;
                }

                /**
                 * Loops recursively from current node to all succeeding nodes and prints their data
                 *
                 * @return A string representation of the nodes
                 */
                public StringBuilder toStringNodeRecursive(StringBuilder builder) {
                        if (next == null) {
                                return builder.append(data);
                        } else {
                                builder.append(data).append(",");
                                data = next.data;
                                next = next.next;
                                return toStringNodeRecursive(builder);
                        }
                }
        }
}
