package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;
import tile.Position;
import tile.Tile;

public class HorizontalMovementValidator extends AbstractValidator {

    public HorizontalMovementValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    public HorizontalMovementValidator(boolean jumper, int limit) {
        super(jumper, limit);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        int fromCol = move.getFrom().column();
        int fromRow = move.getFrom().row();
        int toCol = move.getTo().column();
        int toRow = move.getTo().row();

        boolean inLimit = Math.abs(fromCol - toCol) <= getLimit() && Math.abs(fromRow - toRow) <= getLimit();
        boolean direction = getDirection() == (toCol-fromCol)/Math.abs(fromCol - toCol) || getDirection() == 0;

        if (fromRow == toRow && inLimit && direction) {
            int min = Math.min(fromCol, toCol);
            int max = Math.max(fromCol, toCol);

            //Check if there is a piece in the way
            for (int i = min + 1; i < max && !isJumper(); i++) {
                Tile tile = board.getTile(new Position(fromRow,i));
                if (!tile.isEmpty()) {
                    return new Response(false);
                }
            }

            return validateTile(move,board);

        }
        else return new Response(false);
    }
}
