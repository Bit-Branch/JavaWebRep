package by.epam.shape.exception;

public class ReadFromFileException extends Exception {
    public ReadFromFileException(){
        super();
    }

    public ReadFromFileException(String message){
        super(message);
    }

    public ReadFromFileException(Exception e){
        super(e);
    }

    public ReadFromFileException(String message, Exception e){
        super(message,e);
    }
}
