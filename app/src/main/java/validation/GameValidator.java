package validation;

import board.Board;
import edu.austral.dissis.chess.gui.MoveResult;
import edu.austral.dissis.chess.gui.PlayerColor;
import movement.Move;

public interface GameValidator {
    MoveResult checkMove(Board board, Move move, PlayerColor playerColor);
}
