package exception;

public class OffLimitsException extends Exception {

    public OffLimitsException(String errorMessage) {
        super(errorMessage);
    }

    public OffLimitsException() {
        super("Can't reach there");
    }
}

