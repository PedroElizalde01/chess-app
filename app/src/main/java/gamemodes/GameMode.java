package gamemodes;

import board.Board;
import movement.Move;

public interface GameMode {
    void move(Move move) throws Exception;
    Board updateBoard(Board newBoard);
    Board getBoard();
}
