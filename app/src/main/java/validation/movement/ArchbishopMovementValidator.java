package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;

public class ArchbishopMovementValidator extends AbstractValidator{

    private final MovementValidator diagonalValidator;
    private final MovementValidator knightValidator;

    public ArchbishopMovementValidator(boolean jumper, int limit) {
        super(jumper, limit);
        this.diagonalValidator = new DiagonalMovementValidator(jumper,8,0);
        this.knightValidator = new KnightMovementValidator(jumper,3);
    }

    @Override
    public Response isValid(Move move, Board board) throws OffLimitsException {
        if(diagonalValidator.isValid(move,board).isValid()){
            return diagonalValidator.isValid(move,board);
        }
        return knightValidator.isValid(move,board);
    }
}
