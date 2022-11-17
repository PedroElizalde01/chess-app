package tile;

import piece.Empty;
import piece.PieceInterface;

public class Tile implements Comparable<Tile>{
    private final Position pos;
    private PieceInterface piece;

    public Tile(Position pos, PieceInterface piece) {
        this.pos = pos;
        this.piece = piece;
    }

    public Position getPos() {
        return pos;
    }

    public PieceInterface getPiece() {
        return piece;
    }

    public Tile setPiece(PieceInterface piece) {
        this.piece = piece;
        return this;
    }

    public int column() { return pos.column();}

    public int row() { return pos.row();}

    public boolean isEmpty() {
        return getPiece().isEmpty();
    }

    public int compareTo(Tile tile) {
        return pos.compareTo(tile.pos);
    }
}
