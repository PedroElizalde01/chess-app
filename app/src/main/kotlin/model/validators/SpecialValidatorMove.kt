package model.validators

import model.board.Board
import model.piece.Color
import model.tile.Tile

interface SpecialValidatorMove : ValidatorMove {
    fun getFinalPosition(color:Color, board:Board, to:Tile) : List<Tile>
}