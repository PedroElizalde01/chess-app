package model.validators.move

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.validators.ClassicValidator
import model.validators.Response

class PawnCaptureMoveValidator : ClassicValidator(){

    override fun validate(from: Tile, to: Tile, color: Color, board: Board): Response {
        if(validatePieceAndDestination(from, to, color).bool){
            if(!to.hasPiece()) return Response(false, "Invalid move")
            if(color == Color.WHITE){
                if(from.x + 1 == to.x && from.y + 1 == to.y){
                    return Response(true, "")
                } else if (from.x - 1 == to.x && from.y + 1 == to.y){
                    return Response(true, "")
                }
            } else {
                if(from.x + 1 == to.x && from.y - 1 == to.y){
                    return Response(true, "")
                } else if (from.x - 1 == to.x && from.y - 1 == to.y){
                    return Response(true, "")
                }
            }
        }
        return Response(false, "Invalid move")
    }

}
