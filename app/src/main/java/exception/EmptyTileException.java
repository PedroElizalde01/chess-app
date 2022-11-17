package exception;

public class EmptyTileException extends Exception {

    public EmptyTileException(String errorMessage) {
        super(errorMessage);
    }

    public EmptyTileException() {
        super("This tile is empty");
    }
}

