package by.javatr.task2.exception;

public class NullArrayException extends Exception{

    public NullArrayException(){
        super();
    }

    public NullArrayException(String message){
        super(message);
    }

    public NullArrayException(Exception e){
        super(e);
    }

    public NullArrayException(String message, Exception e){
        super(message,e);
    }
}
