package by.halatsevich.array.task1.exception;

/**
 * Custom exception
 *
 * @author Vladislav Halatsevich
 */
public class InputDataException extends Exception {
    public InputDataException() {
    }

    public InputDataException(String message) {
        super(message);
    }

    public InputDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputDataException(Throwable cause) {
        super(cause);
    }
}