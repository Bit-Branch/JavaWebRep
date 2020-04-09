package by.epam.shape.exception;

public class InvalidIndexException extends Exception {
    public InvalidIndexException(){
        super();
    }

    public InvalidIndexException(String message){
        super(message);
    }

    public InvalidIndexException(Exception e){
        super(e);
    }

    public InvalidIndexException(String message, Exception e){
        super(message,e);
    }
}
