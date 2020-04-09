package by.epam.shape.exception;

public class NullArgumentException extends Exception {
    public NullArgumentException(){
        super();
    }

    public NullArgumentException(String message){
        super(message);
    }

    public NullArgumentException(Exception e){
        super(e);
    }

    public NullArgumentException(String message, Exception e){
        super(message,e);
    }
}
