package by.epam.xmlparser.exception;


public class ElementNotPresentException extends Exception {
    public ElementNotPresentException(){
        super();
    }

    public ElementNotPresentException(String message){
        super(message);
    }

    public ElementNotPresentException(Exception e){
        super(e);
    }

    public ElementNotPresentException(String message, Exception e){
        super(message,e);
    }
}
