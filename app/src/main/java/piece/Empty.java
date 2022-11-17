package piece;

import edu.austral.dissis.chess.gui.PlayerColor;
import validation.movement.EmptyMovementValidator;
import validation.movement.MovementValidator;

public class Empty implements PieceInterface {
    private MovementValidator movementValidator;

    public Empty() {
        this.movementValidator = new EmptyMovementValidator();
    }

    public MovementValidator getMovementValidator() {
        return movementValidator;
    }

    public String getId() {
        throw new UnsupportedOperationException("Empty piece has no id");
    }

    @Override
    public String getName() {
        return "empty";
    }

    @Override
    public PlayerColor getColor() {
        return null;
    }

    @Override
    public boolean isEmpty(){
        return true;
    }
}
