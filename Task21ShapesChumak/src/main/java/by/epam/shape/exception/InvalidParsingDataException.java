package by.epam.shape.exception;

public class InvalidParsingDataException extends Exception{
    public InvalidParsingDataException(){
        super();
    }

    public InvalidParsingDataException(String message){
        super(message);
    }

    public InvalidParsingDataException(Exception e){
        super(e);
    }

    public InvalidParsingDataException(String message, Exception e){
        super(message,e);
    }
}
