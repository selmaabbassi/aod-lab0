package se.hig.aod.lab0;

public class LinkedList<T> implements List<T> {

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
            throw new ListEmptyException("List is empty");
        } else {
            head = head.next;
            numOfElements--;
            return head.data;
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
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

    class ListNode<D> {
        D data;
        ListNode<D> next;

        public ListNode(D data, ListNode<D> next) {
            this.data = data;
            this.next = next;
        }
    }
}