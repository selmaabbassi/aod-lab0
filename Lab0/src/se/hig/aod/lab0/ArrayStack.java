package se.hig.aod.lab0;

import java.util.ArrayList;

/**
 * An @{@link ArrayList} implementation of the Abstract Data Type @{@link Stack} using a LIFO-based implementation</p>
 *
 * @author Selma Abbassi
 */
public class ArrayStack<E> implements Stack<E> {

        ArrayList<E> arrayList;
        int maxSize;

        public ArrayStack(int size) {
                this.arrayList = new ArrayList<>(size);
                this.maxSize = size;
        }

        @Override
        public void clear() {
                arrayList.clear();
                System.out.println("Stack was successfully cleared");
        }

        @Override
        public boolean isEmpty() {
                return arrayList.isEmpty();
        }

        @Override
        public boolean isFull() {
                return arrayList.size() == maxSize;
        }

        @Override
        public void push(E element) {
                if (isFull()) {
                        throw new StackFullException("Stack is full!");
                } else {
                        arrayList.add(0, element);
                }
        }

        @Override
        public E pop() {
                if (isEmpty()) {
                        throw new StackEmptyException("Stack is empty!");
                } else {
                        return arrayList.remove(0);
                }
        }

        @Override
        public E peek() {
                if (isEmpty()) {
                        throw new StackEmptyException("Stack is empty!");
                } else {
                        return arrayList.get(0);
                }
        }

        protected int getStackSize() {
                return arrayList.size();
        }
}
