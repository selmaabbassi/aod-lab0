package se.hig.aod.lab0;


/**
 * A Java Interface for the generic Abstract Data Type<code>Stack</code>.
 *
 * @param <E> Elements that the Stack stores.
 * @author Anders Jackson
 */

public interface Stack<E> {
        /**
         * Removes all elements from this stack and writes
         * a message on {@link System}.out).
         */
        public void clear();

        /**
         * Checks if this stack is empty.
         *
         * @return true if stack is empty, false otherwise.
         */
        public boolean isEmpty();

        /**
         * Checks if this stack is full.
         *
         * @return true if stack is full, false otherwise.
         */
        public boolean isFull();

        /**
         * Adds an element on the top of this stack.
         *
         * @param element - the object added on the top of the stack.
         * @throws @{@link StackFullException} if the stack is full.
         */
        public void push(E element);

        /**
         * Removes the top element of this stack. Will throw
         * {@link StackEmptyException} if the stack is empty.
         *
         * @return top element of the stack.
         * @throws StackEmptyException if stack empty
         */
        public E pop();

        /**
         * Returns the top element of this stack, without removing it.
         * Will throw {@link StackEmptyException} if the stack is empty.
         *
         * @return top element of the stack.
         * @throws StackEmptyException if empty stack
         */
        public E peek();

}
