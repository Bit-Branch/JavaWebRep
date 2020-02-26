package by.javatr.task2.exception;

public class NullArrayException extends Exception{
    private String msg;

    public NullArrayException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
