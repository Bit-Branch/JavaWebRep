package by.javatr.task1.exception;

public class NonexistentIndexException extends Exception {

    public NonexistentIndexException(){
        super();
    }

    public NonexistentIndexException(String message){
        super(message);
    }

    public NonexistentIndexException(Exception e){
        super(e);
    }

    public NonexistentIndexException(String message, Exception e){
        super(message,e);
    }

}
