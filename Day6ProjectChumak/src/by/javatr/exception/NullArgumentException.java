package by.javatr.exception;

public class NullArgumentException extends Exception {
    private String msg;

    public NullArgumentException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Null Argument: " + msg;
    }
}
