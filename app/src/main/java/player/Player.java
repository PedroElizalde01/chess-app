package player;

import board.Board;
import edu.austral.dissis.chess.gui.PlayerColor;
import exception.InvalidMoveException;
import exception.OffLimitsException;
import movement.Move;
import piece.Empty;
import piece.PieceInterface;
import tile.Tile;
import validation.movement.Response;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private PlayerColor color;
    private List<PieceInterface> capturedPieces;

    public Player(String name, PlayerColor color) {
        this.name = name;
        this.color = color;
        this.capturedPieces = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public PlayerColor getColor() {
        return color;
    }

    public List<PieceInterface> getCapturedPieces() {
        return capturedPieces;
    }

    public Board movePiece(Move move, Board board) throws InvalidMoveException, OffLimitsException {
        Response res = move.getValidator().isValid(move,board);
        if(res.isValid()){
            Tile from = move.getFrom();
            Tile to = move.getTo();
            PieceInterface piece = from.getPiece();
            board.updateTile(from,new Empty());
            board.updateTile(to, piece);
            newCapturedPiece(res.getPieces());
            return board;
        }
        throw new InvalidMoveException();
    }

    private List<PieceInterface> newCapturedPiece(List<PieceInterface> newPieces){
        this.capturedPieces.addAll(newPieces);
        return this.capturedPieces;
    }
}
