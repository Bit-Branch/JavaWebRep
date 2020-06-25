package by.epam.committiee.exception;

public class HasherException extends Exception{
    public HasherException() {
        super();
    }

    public HasherException(String message) {
        super(message);
    }

    public HasherException(String message, Throwable cause) {
        super(message, cause);
    }

    public HasherException(Throwable cause) {
        super(cause);
    }
}
