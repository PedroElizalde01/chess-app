package model.validators

import model.board.Board
import model.piece.Color
import model.tile.Tile

interface ValidatorMove {
    fun validate (from : Tile, to : Tile, color: Color, board : Board) : Response
}
