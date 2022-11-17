package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;

public class KnightMovementValidator extends AbstractValidator{

    public KnightMovementValidator(boolean jumper, int limit){
        super(jumper,limit);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        int fromCol = move.getFrom().column();
        int fromRow = move.getFrom().row();
        int toCol = move.getTo().column();
        int toRow = move.getTo().row();

        int diffX = Math.abs(fromCol - toCol);
        int diffY = Math.abs(fromRow - toRow);

        int directionX = fromCol < toCol ? 1 : -1;
        int directionY = fromRow < toRow ? 1 : -1;

        boolean inLimit = (diffX + diffY) == getLimit() && diffX != 0 && diffY != 0;

        if (inLimit) {

            //Check if there is a piece in the way (x path)
            //boolean validPath = checkPath(move.getFrom(),move.getTo(),true,board) || checkPath(move.getFrom(),move.getTo(),false,board) || isJumper();
            //if (validPath) return validatePosition(move,board);
            return validateTile(move,board);

        }

        return new Response(false);
    }
}
