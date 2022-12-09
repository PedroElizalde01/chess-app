package model.validators.move

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.validators.ClassicValidator
import model.validators.Response

class AntiPawnMoveValidator : ClassicValidator() {

    private lateinit var diagonalValidator: DiagonalMoveValidator

    override fun validate(from: Tile, to: Tile, color: Color, board: Board): Response {
        if(validateCapture(from,to,color,board).bool){
            return Response(true, "")
        }
        if(color == Color.WHITE){
            diagonalValidator = DiagonalMoveValidator(1, listOf(1,2))
        } else {
            diagonalValidator = DiagonalMoveValidator(1, listOf(3,4))

        }
        if(diagonalValidator.validate(from, to, color, board).bool && !to.hasPiece()){
            return Response(true, "")
        }
        if(validateClassicConditions(from, to, color, board).bool){
            if(from.piece?.data?.get("moves") == 0 && !to.hasPiece()){
                if((from.x == to.x + 2 || from.x == to.x - 2) && from.y == to.y - 2 && color == Color.WHITE)
                    return Response(true, "")
                if((from.x == to.x + 2 || from.x == to.x - 2) && from.y == to.y + 2 && color == Color.BLACK)
                    return Response(true, "")
            }
        }else {
            throw Exception(validateClassicConditions(from, to, color, board).error)
        }
        return Response(false, "Invalid move")
    }

    fun validateCapture(from:Tile, to:Tile, color: Color, board: Board): Response {
        if(validatePieceAndDestination(from,to,color).bool){
            if(!to.hasPiece()) return Response(false, "Invalid move")
            if(color == Color.WHITE){
                if(from.x == to.x && from.y == to.y - 1) return Response(true, "")
            } else {
                if(from.x == to.x && from.y == to.y + 1) return Response(true, "")
            }
        }
        return Response(false, "Invalid move")
    }
}