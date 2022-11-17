package validation.movement;

import piece.Piece;
import piece.PieceInterface;

import java.util.Collections;
import java.util.List;

public class Response {
    private boolean isValid;
    private List<PieceInterface> pieces;

    public Response(boolean isValid) {
        this.isValid = isValid;
        this.pieces = Collections.emptyList();
    }

    public Response(boolean isValid, List<PieceInterface> pieces) {
        this.isValid = isValid;
        this.pieces = pieces;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<PieceInterface> getPieces() {
        return pieces;
    }

    public boolean isEmpty() {
        return pieces.isEmpty();
    }

}
