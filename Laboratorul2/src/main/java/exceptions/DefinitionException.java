package exceptions;

public class DefinitionException extends Exception {

    public DefinitionException(String message) {
        super(message);
    }

    public DefinitionException(String message, Throwable throwable){
        super(message, throwable);
    }
}
