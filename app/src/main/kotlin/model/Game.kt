package model

import model.board.Board
import model.piece.*
import model.validators.CheckMateValidator
import model.validators.CheckValidator
import model.validators.ClassicMover

class Game (
    private val board : Board,
    private val winCondition : WinCondition,
    private val turn : Color,
    private val promotionPiece : Piece
        ){
    private val checkValidator : CheckValidator = CheckValidator(winCondition)
    private val checkMateValidataor : CheckMateValidator = CheckMateValidator(checkValidator)
    private val moverClassic : ClassicMover = ClassicMover(checkValidator, promotionPiece)

    fun changeTurn () : Color {
        if (turn == Color.WHITE){
            return Color.BLACK
        }
        return Color.WHITE
    }

    fun isInCheck () : Boolean {
        return checkValidator.validate(board, turn)
    }

    fun isInCheckMate () : Boolean {
        return checkMateValidataor.validate(board, turn)
    }

    fun movePiece(fromX: Int, fromY:Int, toX:Int,toY:Int) : Game {
        val from = board.getTile(fromX, fromY)
        val to = board.getTile(toX, toY)
        val newBoard = moverClassic.movePiece(from, to, board, turn)
        return Game(newBoard, winCondition, changeTurn(), promotionPiece)
    }

    fun getBoard () : Board {
        return board
    }

    fun getTurn () : Color {
        return turn
    }

    fun getWinCondition () : WinCondition {
        return winCondition
    }

}