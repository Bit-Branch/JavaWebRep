package by.epam.exception;

public class IncorrectTrianglePointsException extends Exception{

    public IncorrectTrianglePointsException(){
        super();
    }

    public IncorrectTrianglePointsException(String message){
        super(message);
    }

    public IncorrectTrianglePointsException(Exception e){
        super(e);
    }

    public IncorrectTrianglePointsException(String message, Exception e){
        super(message,e);
    }
}
