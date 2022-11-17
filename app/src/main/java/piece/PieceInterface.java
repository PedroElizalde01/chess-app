package piece;

import edu.austral.dissis.chess.gui.PlayerColor;
import validation.movement.MovementValidator;

public interface PieceInterface {
    String getId();
    String getName();
    PlayerColor getColor();
    MovementValidator getMovementValidator();
    boolean isEmpty();
}
