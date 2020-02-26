package by.javatr.task1.exception;

public class NegativeSizeException extends Exception{
    private String msg;

    public NegativeSizeException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Invalid Argument: " + msg;
    }
}