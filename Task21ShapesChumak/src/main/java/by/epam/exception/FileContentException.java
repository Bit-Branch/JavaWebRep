package by.epam.exception;

public class FileContentException extends Exception {
    public FileContentException(){
        super();
    }

    public FileContentException(String message){
        super(message);
    }

    public FileContentException(Exception e){
        super(e);
    }

    public FileContentException(String message, Exception e){
        super(message,e);
    }
}
