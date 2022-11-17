package validation;

import board.Board;
import edu.austral.dissis.chess.gui.GameOver;
import edu.austral.dissis.chess.gui.MoveResult;
import edu.austral.dissis.chess.gui.NewGameState;
import edu.austral.dissis.chess.gui.PlayerColor;
import movement.Move;
import piece.PieceInterface;

import java.util.ArrayList;
import java.util.List;

import static translator.Translator.translatePieces;

public class VictoryValidator implements GameValidator{

    @Override
    public MoveResult checkMove(Board board, Move move, PlayerColor playerColor) {
        List<PieceInterface> kings = new ArrayList<>();
        for (PieceInterface piece : board.getPieces()){
            if (piece.getName().equals("king")){
                kings.add(piece);
            }
        }
        if (kings.size() == 1){
            return new GameOver(kings.get(0).getColor());
        }
        return null;
    }
}
