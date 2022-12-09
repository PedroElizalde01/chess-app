package model.validators.move

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.validators.ClassicValidator
import model.validators.Response

class JumpMoveValidator(private val x: Int, private val y: Int) : ClassicValidator(){
    override fun validate(from: Tile, to: Tile, color: Color, board: Board): Response {
        if(validatePieceAndDestination(from, to, color).bool){
            if(from.x + x == to.x && from.y + y == to.y){
                return Response(true, "")
            }
        } else {
            throw Exception(validatePieceAndDestination(from, to, color).error)
        }
        return Response(false, "Invalid move")
    }
}