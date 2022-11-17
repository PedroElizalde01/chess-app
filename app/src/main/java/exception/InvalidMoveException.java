package exception;

public class InvalidMoveException extends Exception {

    public InvalidMoveException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidMoveException() {
        super("Can't do that");
    }
}

