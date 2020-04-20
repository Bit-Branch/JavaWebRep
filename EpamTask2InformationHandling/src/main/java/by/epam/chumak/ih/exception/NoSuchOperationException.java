package by.epam.chumak.ih.exception;

public class NoSuchOperationException extends Exception{
    public NoSuchOperationException(){
        super();
    }

    public NoSuchOperationException(String message){
        super(message);
    }

    public NoSuchOperationException(Exception e){
        super(e);
    }

    public NoSuchOperationException(String message, Exception e){
        super(message,e);
    }
}
