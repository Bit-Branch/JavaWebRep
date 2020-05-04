package by.epam.ih.exception;

public class ComponentException extends Exception{
    public ComponentException(){
        super();
    }

    public ComponentException(String message){
        super(message);
    }

    public ComponentException(Exception e){
        super(e);
    }

    public ComponentException(String message, Exception e){
        super(message,e);
    }
}
