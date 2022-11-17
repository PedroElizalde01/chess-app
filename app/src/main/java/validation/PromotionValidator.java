package validation;

import board.Board;
import edu.austral.dissis.chess.gui.MoveResult;
import edu.austral.dissis.chess.gui.NewGameState;
import edu.austral.dissis.chess.gui.PlayerColor;
import movement.Move;
import piece.Piece;
import tile.Position;
import tile.Tile;
import validation.movement.QueenMovementValidator;

import java.util.ArrayList;
import java.util.List;

import static translator.Translator.translatePieces;

public class PromotionValidator implements GameValidator{
    @Override
    public MoveResult checkMove(Board board, Move move, PlayerColor playerColor) {
        List<Tile> pawnTiles = new ArrayList<>();
        for (int i = 0; i < board.getWidth()-1; i++) {
            Tile topTile = board.getTile(new Position(0,i));
            if (topTile.getPiece().getName().equals("pawn")) pawnTiles.add(topTile);
        }
        for (int i = 0; i < board.getWidth()-1; i++) {
            Tile botTile = board.getTile(new Position(board.getHeight()-1, i));
            if (botTile.getPiece().getName().equals("pawn")) pawnTiles.add(botTile);
        }
        if (pawnTiles.size() != 0){
            for(Tile tile : pawnTiles){
                board.updateTile(tile,new Piece(tile.getPiece().getId(), "queen", tile.getPiece().getColor(), new QueenMovementValidator(false, 8)));
            }
            return new NewGameState(translatePieces(board.getTiles()),playerColor == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE);
        }
        return new NewGameState(translatePieces(board.getTiles()),playerColor == PlayerColor.WHITE ? PlayerColor.BLACK : PlayerColor.WHITE);
    }
}
