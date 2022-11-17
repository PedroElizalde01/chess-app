package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;

public class RookMovementValidator extends AbstractValidator{

    private final MovementValidator lateralValidator;
    private final MovementValidator verticalValidator;

    public RookMovementValidator() {
        super(false, 8);
        this.lateralValidator = new HorizontalMovementValidator(false, 8, 0);
        this.verticalValidator = new VerticalMoveValidator(false, 8, 0);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {

        if (move.getFrom().column() == move.getTo().column()) {
            return verticalValidator.isValid(move, board);
        } else if (move.getFrom().row() == move.getTo().row()) {
            return lateralValidator.isValid(move, board);
        } else {
            return new Response(false);
        }
    }
}
