package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;

public class ChancellorMovementValidator extends AbstractValidator{

    private final MovementValidator rookValidator;
    private final MovementValidator knightValidator;

    public ChancellorMovementValidator(boolean jumper, int limit) {
        super(jumper, limit);
        this.rookValidator = new RookMovementValidator();
        this.knightValidator = new KnightMovementValidator(jumper,3);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        if (move.getFrom().column() == move.getTo().column() || move.getFrom().row() == move.getTo().row()) {
            return rookValidator.isValid(move, board);
        }else{
            return knightValidator.isValid(move,board);
        }
    }
}
