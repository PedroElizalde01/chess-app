package model.validators.move

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.validators.ClassicValidator
import model.validators.Response

class DiagonalMoveValidator(var limit: Int, val quadrant: List<Int>) : ClassicValidator() {
    override fun validate(from: Tile, to: Tile, color: Color, board: Board): Response {
        if (limit == 0) limit = board.getBoardWidth()
        if (validateClassicConditions(from, to, color, board).bool) {
            val y = from.y
            val x = from.x
            for (i in quadrant) {
                when (i) {
                    1 -> {
                        for (j in 1..limit) {
                            if (y + j == to.y && x + j == to.x) return Response(true, "")
                        }
                    }
                    2 -> {
                        for (j in 1..limit) {
                            if (y + j == to.y && x - j == to.x) return Response(true, "")
                        }
                    }
                    3 -> {
                        for (j in 1..limit) {
                            if (y - j == to.y && x - j == to.x) return Response(true, "")
                        }
                    }
                    4 -> {
                        for (j in 1..limit) {
                            if (y - j == to.y && x + j == to.x) return Response(true, "")
                        }
                    }
                }
            }
        } else {
            throw Exception(validateClassicConditions(from, to, color, board).error)
        }
        return Response(false, "Invalid move")
    }
}