package se.hig.aod.lab0;

/**
 * An array implementation of the Abstract Data Type @{@link Queue}
 *
 * @author Selma Abbassi
 */
public class ArrayQueue<E> implements Queue<E> {
        private Object[] array;
        private int frontElement;
        private int backElement;
        private final int maxSize;

        public ArrayQueue(int size) {
                this.array = new Object[size];
                this.frontElement = 0;
                this.backElement = 0;
                this.maxSize = size;
        }

        @Override
        public void clear() {
                array = new Object[maxSize];
                frontElement = 0;
                backElement = 0;
        }

        @Override
        public boolean isEmpty() {
                return backElement == frontElement;
        }

        @Override
        public boolean isFull() {
                return backElement == maxSize;
        }

        @Override
        public void enqueue(E element) {
                if (isFull()) {
                        throw new QueueFullException("Queue is full!");
                } else {
                        array[backElement] = element;
                        backElement++;
                }
        }

        @Override
        public E dequeue() {
                if (isEmpty()) {
                        throw new QueueEmptyException("Queue is empty!");
                } else {
                        Object removedElement = array[frontElement];

                        for (int i = 0; i < backElement - 1; i++) {
                                array[i] = array[i + 1];
                        }

                        backElement--;

                        return (E) removedElement;
                }
        }

        @Override
        public E getFront() {
                return (E) array[frontElement];
        }

        public E getBack() {
                return (E) array[backElement - 1];
        }

        public void toStringQueue() {
                StringBuilder builder = new StringBuilder();
                builder.append("[");
                for (int i = frontElement; i < backElement; i++) {
                        builder.append(array[i].toString()).append(",");
                }
                builder.append("]");
                System.out.println(builder);
        }

        public int getQueueSize() {
                return backElement;
        }
}
