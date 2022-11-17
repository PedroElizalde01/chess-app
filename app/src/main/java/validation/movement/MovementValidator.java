package validation.movement;

import board.Board;
import exception.OffLimitsException;
import movement.Move;

public interface MovementValidator {

    Response isValid(Move move, Board board) throws OffLimitsException;
}
