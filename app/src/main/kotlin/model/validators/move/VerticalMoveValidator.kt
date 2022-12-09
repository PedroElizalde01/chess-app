package model.validators.move

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.validators.ClassicValidator
import model.validators.Response

class VerticalMoveValidator (val limit : Int, val up : Boolean) : ClassicValidator() {
    override fun validate(from: Tile, to: Tile, color: Color, board: Board): Response {
        var limit = limit
        if(limit == 0){
            limit = board.getBoardWidth()
        }
        if(validateClassicConditions(from,to,color,board).bool){
            var y = from.y
            if(up){
                y -= limit
                if(y <= to.y && from.x == to.x && from.y > to.y){
                    return Response(true, "")
                }
            } else {
                y += limit
                if(y >= to.y && from.x == to.x && from.y < to.y){
                    return Response(true, "")
                }
            }
        }else {
            throw Exception(validateClassicConditions(from,to,color,board).error)
        }
        return Response(false, "Invalid move")
    }
}