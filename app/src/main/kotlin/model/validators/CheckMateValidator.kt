package model.validators

import model.board.Board
import model.piece.Color
import model.tile.Tile

class CheckMateValidator(private val checkValidator: CheckValidator) {
    fun validate(board: Board, color: Color): Boolean {
        if (checkValidator.validate(board, color)) {
            val allyTiles = board.getAllyTiles(color)
            for (t in allyTiles) {
                for (v in t.piece?.getValidators()!!) {
                    if (!validateCheckMate(v, t, color, board)) return false
                }
                for( s in t.piece!!.getSpecialMoves()){
                    if (!validateCheckMate(s, t, color, board)) return false
                }
            }
            return true
        }
        return false
    }

    private fun validateCheckMate(validator: ValidatorMove, allyTile: Tile, color: Color, board: Board): Boolean {
        for (k in board.getTiles()) {
            try {
                if (validator.validate(allyTile, k, color, board).bool) {
                    val newBoard = board.updateBoard(allyTile, k)
                    if (!checkValidator.validate(newBoard, color)) {
                        return false
                    }
                }
            } catch (e: Exception) {
                continue
            }
        }
        return true
    }
}
