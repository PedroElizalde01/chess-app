package validation.movement;

import board.Board;
import movement.Move;

public class EmptyMovementValidator implements MovementValidator{
    @Override
    public Response isValid(Move move, Board board) {
        return new Response(false);
    }
}
