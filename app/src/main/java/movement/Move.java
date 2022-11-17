package movement;

import tile.Tile;
import validation.movement.MovementValidator;

public class Move {
    private final Tile from;
    private final Tile to;
    private final MovementValidator movementValidator;

    public Move(Tile from, Tile to) {
        this.from = from;
        this.to = to;
        this.movementValidator = getFrom().getPiece().getMovementValidator();
    }

    public Tile getFrom() {
        return from;
    }

    public Tile getTo() {
        return to;
    }

    public MovementValidator getValidator() {
        return movementValidator;
    }
}
