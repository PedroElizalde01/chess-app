package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;
import tile.Tile;

public class PawnMovementValidator extends AbstractValidator{

    private final MovementValidator forwardValidator;
    private final MovementValidator firstMoveValidator;
    private final MovementValidator captureValidator;
    private boolean firstMove;

    public PawnMovementValidator(int direction){
        super(false,1,direction);
        this.firstMove = true;
        this.forwardValidator = new VerticalMoveValidator(false,1,direction);
        this.firstMoveValidator = new VerticalMoveValidator(false,2,direction);
        this.captureValidator = new DiagonalMovementValidator(false,1,direction);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        Tile toTile = move.getTo();
        if(firstMove){
            if (toTile.isEmpty()){
                if(firstMoveValidator.isValid(move,board).isValid()){
                    firstMove = false;
                    return new Response(true);
                }
            } else {
                firstMove = false;
                return captureValidator.isValid(move,board);
            }

        } else {
            if (toTile.isEmpty()){
                firstMove = false;
                return forwardValidator.isValid(move,board);
            } else {
                firstMove = false;
                return captureValidator.isValid(move,board);
            }
        }
        return forwardValidator.isValid(move,board);
    }
}
