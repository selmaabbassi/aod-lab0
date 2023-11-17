package se.hig.aod.lab0;

/**
 * Exception class that signals if an operation that is not allowed has been
 * done on an empty stack.
 *
 * @author Selma Abbassi
 */
public class StackEmptyException extends RuntimeException {
        /**
         * A constructor that takes a message about which error has been generated.
         * This can be written to the user when the exception is caught.
         */
        public StackEmptyException(String message) {
                // Call the parents constructor.
                super(message);
        }
}
