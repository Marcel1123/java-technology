package exceptions;

public class LanguageException  extends Exception {

    public LanguageException(String message) {
        super(message);
    }

    public LanguageException(String message, Throwable throwable){
        super(message, throwable);
    }

}
