package se.hig.aod.lab0;

/**
 * Exception class that signals if an operation that is not allowed has been
 * done on a full list.
 *
 * @author Selma Abbassi
 */
public class StackFullException extends RuntimeException {
        /**
         * A constructor that takes a message about which error has been generated.
         * This can be written to the user when the exception is caught.
         */
        public StackFullException(String message) {
                // Call the parents constructor.
                super(message);
        }
}
