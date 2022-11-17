import edu.austral.dissis.chess.gui.*;
import exception.EmptyTileException;
import gamemodes.Capablanca;
import gamemodes.Classic;
import board.Board;
import gamemodes.GameMode;
import org.jetbrains.annotations.NotNull;
import validation.PromotionValidator;
import validation.VictoryValidator;

import java.util.Scanner;

import static translator.Translator.translatePieces;
import static translator.Translator.translateMove;

public class MyGameEngine implements GameEngine {

    private GameMode gameMode=null;
    private PlayerColor currentColor = PlayerColor.WHITE;
    private final VictoryValidator victoryValidator = new VictoryValidator();
    private final PromotionValidator promotionValidator = new PromotionValidator();

    private GameMode chooseGameMode() {
        Scanner myObj = new Scanner(System.in);
        System.out.println(
                "Enter game mode: \n 1 for Classic \n 2 for Capablanca"
        );
        int gameMode = myObj.nextInt();
        return switch (gameMode) {
            case 1 -> new Classic();
            case 2 -> new Capablanca();
            default -> new Classic();
        };
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        movement.Move castedMove = translateMove(move, gameMode.getBoard());
        try {
            if(castedMove.getFrom().isEmpty()) throw new EmptyTileException();
            gameMode.move(castedMove);
            if (victoryValidator.checkMove(gameMode.getBoard(), castedMove,currentColor) != null){
                return victoryValidator.checkMove(gameMode.getBoard(), castedMove,currentColor);
            }else{
                if (promotionValidator.checkMove(gameMode.getBoard(), castedMove,currentColor) != null){
                    return promotionValidator.checkMove(gameMode.getBoard(), castedMove,currentColor);
                }
            }
            return new NewGameState(translatePieces(gameMode.getBoard().getTiles()), changeColor());
        } catch (Exception e) {
            return new InvalidMove(e.getMessage());
        }
    }

    @NotNull
    @Override
    public InitialState init() {
        this.gameMode = chooseGameMode();
        return new InitialState(new BoardSize(gameMode.getBoard().getWidth(),gameMode.getBoard().getHeight()), translatePieces(gameMode.getBoard().getTiles()), PlayerColor.WHITE);
    }

    public Board getBoard() {
        return gameMode.getBoard();
    }

    public PlayerColor changeColor(){
        PlayerColor oldColor = currentColor;
        return currentColor = currentColor == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE;
    }
}
