package by.epam.exception;

public class NullPointException extends Exception {
    public NullPointException(){
        super();
    }

    public NullPointException(String message){
        super(message);
    }

    public NullPointException(Exception e){
        super(e);
    }

    public NullPointException(String message, Exception e){
        super(message,e);
    }
}
