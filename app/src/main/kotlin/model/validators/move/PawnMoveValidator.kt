package model.validators.move

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.validators.ClassicValidator
import model.validators.Response

class PawnMoveValidator : ClassicValidator() {
    private lateinit var verticalValidator : VerticalMoveValidator
    private val captureValidator : PawnCaptureMoveValidator = PawnCaptureMoveValidator()

    override fun validate(from: Tile, to: Tile, color: Color, board: Board): Response {
        if(captureValidator.validate(from, to, color, board).bool){
            return Response(true, "")
        }
        if ( color == Color.WHITE ) {
            verticalValidator = VerticalMoveValidator(1, false)
        } else {
            verticalValidator = VerticalMoveValidator(1, true)
        }
        if (verticalValidator.validate(from, to, color, board).bool && !to.hasPiece()) {
            return Response(true, "")
        }
        if(validateClassicConditions(from,to,color,board).bool){
            if(from.piece?.data?.get("moves") == 0 && !to.hasPiece()){
                if(from.x == to.x && from.y == to.y - 2 && color == Color.WHITE)
                    return Response(true, "")
            }
            if(from.x == to.x && from.y == to.y + 2 && color == Color.BLACK)
                return Response(true, "")
        } else {
            throw Exception(validateClassicConditions(from,to,color,board).error)
        }
        return Response(false, "Invalid move")
    }
}