package by.epam.committiee.exception;

public class PoolIsClosedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PoolIsClosedException() {
    }

    public PoolIsClosedException(String message) {
        super(message);
    }

    public PoolIsClosedException(Throwable cause) {
        super(cause);
    }

    public PoolIsClosedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoolIsClosedException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}