package by.javatr.task1.exception;

public class InvalidIndexException extends Exception{
    private String msg;

    public InvalidIndexException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
