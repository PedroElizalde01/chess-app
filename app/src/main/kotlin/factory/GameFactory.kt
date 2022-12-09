package factory

import model.Game
import model.WinCondition
import model.piece.Color

class GameFactory {

    fun createClassicGame(): Game {
        val pieceFactory = PieceFactory()
        val boardFactory = BoardFactory()
        val board = boardFactory.createClassicBoard()
        val winCondition = WinCondition(
            listOf(
                pieceFactory.createKing("w51", Color.WHITE),
                pieceFactory.createKing("b58", Color.BLACK)
            )
        )
        return Game(board, winCondition, Color.WHITE, pieceFactory.createQueen("w41", Color.WHITE))
    }
}