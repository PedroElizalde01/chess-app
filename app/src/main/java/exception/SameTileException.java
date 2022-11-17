package exception;

public class SameTileException extends Exception {

    public SameTileException(String errorMessage) {
        super(errorMessage);
    }

    public SameTileException() {
        super("Can't choose same tile");
    }
}

