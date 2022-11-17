package translator;

import board.Board;
import edu.austral.dissis.chess.gui.ChessPiece;
import edu.austral.dissis.chess.gui.Move;
import edu.austral.dissis.chess.gui.Position;
import piece.PieceInterface;
import tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Translator {

    public static List<ChessPiece> translatePieces(List<Tile> tiles) {
        List<ChessPiece> castedPieces = new ArrayList<>();
        for (Tile tile : tiles) {
            PieceInterface actualPiece = tile.getPiece();
            if (!actualPiece.isEmpty()) {
                castedPieces.add(
                        new ChessPiece(
                                actualPiece.getId(),
                                actualPiece.getColor(),
                                new Position(tile.row()+1, tile.column()+1),
                                actualPiece.getName()));
            }
        }
        return castedPieces;
    }

    public static movement.Move translateMove(Move move, Board board) {
        Tile fromTile = board.getTile(new tile.Position(move.getFrom().getRow()-1,move.getFrom().getColumn()-1));
        Tile toTile = board.getTile(new tile.Position(move.getTo().getRow()-1,move.getTo().getColumn()-1));

        return new movement.Move(fromTile,toTile);
    }
}
