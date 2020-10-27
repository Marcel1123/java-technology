package exceptions;

public class WordException extends Exception {

    public WordException(String message) {
        super(message);
    }

    public WordException(String message, Throwable throwable){
        super(message, throwable);
    }
}