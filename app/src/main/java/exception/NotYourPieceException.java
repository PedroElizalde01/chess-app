package exception;

public class NotYourPieceException extends Exception {

    public NotYourPieceException(String errorMessage) {
        super(errorMessage);
    }

    public NotYourPieceException() {
        super("This piece is not yours!");
    }
}

