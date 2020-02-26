package by.javatr.task1.exception;

public class ZeroSizeException extends Exception {
    private String msg;

    public ZeroSizeException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
