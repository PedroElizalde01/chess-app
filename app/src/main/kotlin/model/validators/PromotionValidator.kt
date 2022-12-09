package model.validators

import model.board.Board
import model.piece.Color
import model.tile.Tile

class PromotionValidator {
    companion object {
        fun validate(color: Color, board: Board, tile: Tile): Response {
            if (tile.piece?.getColor() == color) {
                if (tile.piece?.promotion == true) {
                    if (tile.piece?.getColor() == Color.WHITE) {
                        if (tile.y == board.getBoardHeight()) {
                            return Response(true, "")
                        }
                    }
                    if (tile.piece?.getColor() == Color.BLACK) {
                        if (tile.y == 1) {
                            return Response(true, "")
                        }
                    }
                }
            }
            return Response(false, "You can't promote this piece")
        }
    }
}