package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;
import tile.Position;
import tile.Tile;

public class VerticalMoveValidator extends AbstractValidator {

    public VerticalMoveValidator(boolean jumper, int limit, int direction) {
        super(jumper, limit, direction);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        int fromCol = move.getFrom().column();
        int fromRow = move.getFrom().row();
        int toCol = move.getTo().column();
        int toRow = move.getTo().row();

        boolean isLimit = fromCol == toCol && Math.abs(fromRow - toRow) <= getLimit();
        boolean direction = getDirection() == (toRow - fromRow) / Math.abs(fromRow - toRow) || getDirection() == 0;
        if (fromCol == toCol && isLimit && direction ) {
            int min = Math.min(fromRow, toRow);
            int max = Math.max(fromRow, toRow);

            for (int i = min + 1; i < max && !isJumper(); i++) {
                Tile tile = board.getTile(new Position(i,fromCol));
                if (!tile.isEmpty()) {
                    return new Response(false);
                }
            }
            return validateTile(move, board);
        }
        return new Response(false);
    }

}
