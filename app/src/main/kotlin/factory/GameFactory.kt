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

    fun createCapablancaGame(): Game {
        val pieceFactory = PieceFactory()
        val boardFactory = BoardFactory()
        val board = boardFactory.createCapablancaBoard()
        val winCondition = WinCondition(
            listOf(
                pieceFactory.createKing("w061", Color.WHITE),
                pieceFactory.createKing("b510", Color.BLACK)
            )
        )
        return Game(board, winCondition, Color.WHITE, pieceFactory.createQueen("w41", Color.WHITE))
    }

    fun createAntiPawnGame(): Game {
        val pieceFactory = PieceFactory()
        val boardFactory = BoardFactory()
        val board = boardFactory.createAntiPawnBoard()
        val winCondition = WinCondition(
            listOf(
                pieceFactory.createKing("w51", Color.WHITE),
                pieceFactory.createKing("b58", Color.BLACK)
            )
        )
        return Game(board, winCondition, Color.WHITE, pieceFactory.createQueen("w41", Color.WHITE))
    }

}