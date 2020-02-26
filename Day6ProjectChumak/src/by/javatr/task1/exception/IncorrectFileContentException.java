package by.javatr.task1.exception;

public class IncorrectFileContentException extends Exception {
    private String msg;

    public IncorrectFileContentException(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
