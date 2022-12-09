package model.validators.move

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.validators.ClassicValidator
import model.validators.Response

class HorizontalMoveValidator (val limit: Int, val left : Boolean) : ClassicValidator(){
    override fun validate(from: Tile, to: Tile, color: Color, board: Board): Response {
        var limit = limit
        if(limit === 0){
            limit = board.getBoardWidth()
        }
        if(validateClassicConditions(from, to, color, board).bool){
            var x = from.x
            if(left){
                x -= limit
                if(x <= to.x && from.y == to.y && from.x > to.x){
                    return Response(true, "")
                }
            }else{
                x += limit
                if(x >= to.x && from.y == to.y && from.x < to.x){
                    return Response(true, "")
                }
            }
        }else{
            throw Exception(validateClassicConditions(from, to, color, board).error)
        }
        return Response(false, "Invalid move")
    }
}