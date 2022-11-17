package gamemodes;

import board.Board;
import board.ClassicBoard;
import edu.austral.dissis.chess.gui.PlayerColor;
import exception.NotYourPieceException;
import exception.OffLimitsException;
import movement.Move;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Classic {

    private Board board;
    private Stack<Move> movements;
    private List<Player> players;
    private boolean whiteTurn;

    public Classic(Board board, List<Player> players) {
        this.board = board;
        this.movements = new Stack<>();
        this.players = players;
        this.whiteTurn = true;
    }

    public Classic() {
        this.board = new ClassicBoard();
        this.movements = new Stack<>();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", PlayerColor.WHITE));
        players.add(new Player("Player 2", PlayerColor.BLACK));
        this.players = players;
        this.whiteTurn = true;
    }

    public void move(Move move) throws Exception {
        Player player = whiteTurn ? players.get(0) : players.get(1);
        if (whiteTurn && move.getFrom().getPiece().getColor() != PlayerColor.WHITE || !whiteTurn && move.getFrom().getPiece().getColor() != PlayerColor.BLACK){
            throw new NotYourPieceException();
        }
        Board board = player.movePiece(move,getBoard());
        movements.push(move);
        updateBoard(board);
        whiteTurn = !whiteTurn;
    }

    private Board updateBoard(Board newBoard) {
        Board oldBoard = getBoard();
        this.board = newBoard;
        return oldBoard;
    }

    public Board getBoard() {
        return board;
    }

    public Stack<Move> getMovements() {
        return movements;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isWhiteTurn() {
        return whiteTurn;
    }
}
