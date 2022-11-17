package board;

import edu.austral.dissis.chess.gui.PlayerColor;
import piece.Empty;
import piece.Piece;
import piece.PieceInterface;
import tile.Position;
import tile.Tile;
import validation.movement.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassicBoard implements Board {

    private final int size = 8;
    private List<Tile> tiles = new ArrayList<>();

    public ClassicBoard()  {
        createBoard();
    }

    private void createBoard() {

        List<Tile> initialTiles = new ArrayList<>();
        Tile[] tilesArray = new Tile[size*size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tilesArray[index] = new Tile(new Position(j,i),new Empty());
                index++;
            }
        }
        this.tiles = Arrays.asList(tilesArray);

        initialTiles.add(new Tile(new Position(0,0), new Piece("w00", "rook", PlayerColor.WHITE, new RookMovementValidator())));
        initialTiles.add(new Tile(new Position(0,7), new Piece("w70", "rook", PlayerColor.WHITE, new RookMovementValidator())));
        initialTiles.add(new Tile(new Position(7,0), new Piece("b07", "rook", PlayerColor.BLACK, new RookMovementValidator())));
        initialTiles.add(new Tile(new Position(7,7), new Piece("b77", "rook", PlayerColor.BLACK, new RookMovementValidator())));

        initialTiles.add(new Tile(new Position(0,1), new Piece("w10", "knight", PlayerColor.WHITE, new KnightMovementValidator(true, 3))));
        initialTiles.add(new Tile(new Position(0,6), new Piece("w60", "knight", PlayerColor.WHITE, new KnightMovementValidator(true, 3))));
        initialTiles.add(new Tile(new Position(7,1), new Piece("b17", "knight", PlayerColor.BLACK, new KnightMovementValidator(true, 3))));
        initialTiles.add(new Tile(new Position(7,6), new Piece("b67", "knight", PlayerColor.BLACK, new KnightMovementValidator(true, 3))));

        initialTiles.add(new Tile(new Position(0,2), new Piece("w20", "bishop", PlayerColor.WHITE, new DiagonalMovementValidator(false, 8, 0))));
        initialTiles.add(new Tile(new Position(0,5), new Piece("w50", "bishop", PlayerColor.WHITE, new DiagonalMovementValidator(false, 8, 0))));
        initialTiles.add(new Tile(new Position(7,2), new Piece("b27", "bishop", PlayerColor.BLACK, new DiagonalMovementValidator(false, 8, 0))));
        initialTiles.add(new Tile(new Position(7,5), new Piece("b57", "bishop", PlayerColor.BLACK, new DiagonalMovementValidator(false, 8, 0))));

        initialTiles.add(new Tile(new Position(0,3), new Piece("w30", "queen", PlayerColor.WHITE, new QueenMovementValidator(false, 8))));
        initialTiles.add(new Tile(new Position(7,3), new Piece("b37", "queen", PlayerColor.BLACK, new QueenMovementValidator(false, 8))));

        initialTiles.add(new Tile(new Position(0,4), new Piece("w40", "king", PlayerColor.WHITE, new QueenMovementValidator(false, 1))));
        initialTiles.add(new Tile(new Position(7,4), new Piece("b47", "king", PlayerColor.BLACK, new QueenMovementValidator(false, 1))));

        for (int i = 0; i < 8; i++) {
            initialTiles.add(new Tile(new Position(1, i), new Piece("0w" + i, "pawn", PlayerColor.WHITE, new PawnMovementValidator(1))));
            initialTiles.add(new Tile(new Position(6, i), new Piece("7b" + i, "pawn", PlayerColor.BLACK, new PawnMovementValidator(-1))));
        }

        for (Tile tile : initialTiles){
            updateTile(getTile(tile.getPos()),tile.getPiece());
        }
    }

    @Override
    public Tile getTile(Position position) {
        for (Tile tile : tiles) {
            if (tile.getPos().compareTo(position) == 0) {
                return tile;
            }
        }
        return null;
    }

    @Override
    public Tile updateTile(Tile newTile, PieceInterface piece) {
        Tile oldTile = getTile(newTile.getPos());
        int n = getTiles().indexOf(oldTile);
        getTiles().set(n,newTile.setPiece(piece));
        return oldTile;
    }

    @Override
    public boolean isTileEmpty(Tile tile) {
        return tile.isEmpty();
    }

    @Override
    public List<Tile> getTiles() {
        return this.tiles;
    }

    @Override
    public int getHeight() {
        return size;
    }

    @Override
    public int getWidth() {
        return size;
    }

    @Override
    public List<PieceInterface> getPieces(){
        List<PieceInterface> pieces = new ArrayList<>();
        for (Tile tile : tiles){
            pieces.add(tile.getPiece());
        }
        return pieces;
    }
}
