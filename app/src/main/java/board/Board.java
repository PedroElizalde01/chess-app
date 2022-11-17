package board;

import piece.PieceInterface;
import tile.Position;
import tile.Tile;

import java.util.List;

public interface Board {
    Tile getTile(Position position);
    Tile updateTile(Tile tile, PieceInterface piece);
    boolean isTileEmpty(Tile tile);
    List<Tile> getTiles();
    int getHeight();
    int getWidth();
    List<PieceInterface> getPieces();
}
