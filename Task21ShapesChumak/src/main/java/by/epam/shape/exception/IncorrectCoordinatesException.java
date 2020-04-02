package by.epam.shape.exception;

public class IncorrectCoordinatesException extends Exception{

    public IncorrectCoordinatesException(){
        super();
    }

    public IncorrectCoordinatesException(String message){
        super(message);
    }

    public IncorrectCoordinatesException(Exception e){
        super(e);
    }

    public IncorrectCoordinatesException(String message, Exception e){
        super(message,e);
    }
}
