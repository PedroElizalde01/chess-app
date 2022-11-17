package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;

public class QueenMovementValidator extends AbstractValidator{

    private final MovementValidator horizontalValidator;
    private final MovementValidator rookValidator;
    private final MovementValidator diagonalValidator;

    public QueenMovementValidator(boolean jumper, int limit){
        super(jumper, limit);
        this.horizontalValidator = new HorizontalMovementValidator(jumper,limit,0);
        this.rookValidator = new RookMovementValidator();
        this.diagonalValidator = new DiagonalMovementValidator(jumper,limit,0);
    }


    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        if (move.getFrom().column() == move.getTo().column() || move.getFrom().row() == move.getTo().row()) {
            return rookValidator.isValid(move,board);
            //return verticalValidator.isValid(move, board);
        } else if (move.getFrom().row() == move.getTo().row()) {
            return horizontalValidator.isValid(move, board);
        } else {
            return diagonalValidator.isValid(move, board);
        }
    }
}
