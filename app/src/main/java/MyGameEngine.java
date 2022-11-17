import edu.austral.dissis.chess.gui.*;
import exception.EmptyTileException;
import gamemodes.Classic;
import board.Board;
import org.jetbrains.annotations.NotNull;
import validation.GameValidator;
import validation.VictoryValidator;

import static translator.Translator.translatePieces;
import static translator.Translator.translateMove;

public class MyGameEngine implements GameEngine {

    private final Classic classic = new Classic();
    private PlayerColor currentColor = PlayerColor.WHITE;
    private VictoryValidator victoryValidator = new VictoryValidator();

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        movement.Move castedMove = translateMove(move, classic.getBoard());
        try {
            if(castedMove.getFrom().isEmpty()) throw new EmptyTileException();
            classic.move(castedMove);
            return victoryValidator.checkMove(classic.getBoard(),castedMove,currentColor) != null ?
                    victoryValidator.checkMove(classic.getBoard(),castedMove,currentColor) :
                    new NewGameState(translatePieces(classic.getBoard().getTiles()), changeColor());
        } catch (Exception e) {
            return new InvalidMove(e.getMessage());
        }
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(new BoardSize(classic.getBoard().getWidth(),classic.getBoard().getHeight()), translatePieces(classic.getBoard().getTiles()), PlayerColor.WHITE);
    }

    public Board getBoard() {
        return classic.getBoard();
    }

    public PlayerColor changeColor(){
        PlayerColor oldColor = currentColor;
        return currentColor = currentColor == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
    }
}
