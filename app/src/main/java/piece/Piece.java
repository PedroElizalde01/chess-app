package piece;

import edu.austral.dissis.chess.gui.Move;
import edu.austral.dissis.chess.gui.PlayerColor;
import validation.movement.MovementValidator;

import java.util.Set;

public class Piece implements PieceInterface {
    private final String id;
    private final String name;
    private final PlayerColor color;
    private MovementValidator validator;

    public Piece(String id, String name, PlayerColor color,MovementValidator validator) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.validator = validator;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public PlayerColor getColor() {
        return color;
    }

    @Override
    public MovementValidator getMovementValidator() {
        return validator;
    }

    @Override
    public boolean isEmpty(){
        return false;
    }
}
