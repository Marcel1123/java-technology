package exceptions;

public class DuplicateWordException extends Exception {

    public DuplicateWordException(String message) {
        super(message);
    }

    public DuplicateWordException(String message, Throwable throwable){
        super(message, throwable);
    }
}
