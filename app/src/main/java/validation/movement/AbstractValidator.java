package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;
import tile.Position;

import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractValidator implements MovementValidator {

    private boolean jumper;
    private int limit;
    private int direction;

    public AbstractValidator(boolean jumper, int limit, int direction) {
        this.jumper = jumper;
        this.limit = limit;
        this.direction = direction;
    }

    public AbstractValidator(boolean jumper, int limit) {
        this.jumper = jumper;
        this.limit = limit;
        this.direction = 0;
    }

    public Response validateTile(Move move, Board board) throws OffLimitsException {
        if (board.isTileEmpty(move.getTo())) {
            return new Response(true);
        } else if (!board.isTileEmpty(move.getTo()) && move.getTo().getPiece().getColor() != move.getFrom().getPiece().getColor()) {
            return new Response(
                    true,
                    new ArrayList<>(Collections.singleton(board.getTile(new Position(move.getTo().column(), move.getTo().row())).getPiece())));
        }
        return new Response(false);
    }

    public boolean isJumper() {
        return jumper;
    }

    public int getLimit() {
        return limit;
    }

    public int getDirection() {
        return direction;
    }
}
