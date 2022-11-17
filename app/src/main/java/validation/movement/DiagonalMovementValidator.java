package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;
import tile.Position;
import tile.Tile;

public class DiagonalMovementValidator extends AbstractValidator {

    public DiagonalMovementValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        int fromCol = move.getFrom().column();
        int fromRow = move.getFrom().row();
        int toCol = move.getTo().column();
        int toRow = move.getTo().row();

        boolean inLimit = Math.abs(fromCol - toCol) <= getLimit() && Math.abs(fromRow - toRow) <= getLimit();

        if (Math.abs(fromCol - toCol) == Math.abs(fromRow - toRow) && inLimit) {

            int min = Math.min(fromCol, toCol);
            int max = Math.max(fromCol, toCol);

            //int directionX = (toCol - fromCol) / Math.abs(max - min);
            int directionY = (toRow - fromRow) / Math.abs(max - min);

            for (int i = min + 1; i < max; i++) {
                Tile tile = board.getTile(new Position(fromRow + (i - min) * directionY,i));
                if (!tile.isEmpty()) {
                    return new Response(false);
                }
            }

            return validateTile(move,board);

        } else return new Response(false);
    }
}
