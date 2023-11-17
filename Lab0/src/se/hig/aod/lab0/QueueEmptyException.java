package se.hig.aod.lab0;

/**
 * Exception class that signals if an operation that is not allowed has been
 * done on an empty queue.
 *
 * @author Selma Abbassi
 */
public class QueueEmptyException extends RuntimeException {

        /**
         * A constructor that takes a message about which error has been generated.
         * This can be written to the user when the exception is caught.
         */
        public QueueEmptyException(String message) {
                // Call the parents constructor.
                super(message);
        }

}
