package model.validators

import model.board.Board
import model.WinCondition
import model.piece.Color
import model.tile.Tile

class CheckValidator (private val winCondition: WinCondition){
    fun validate(board: Board, color: Color) : Boolean {
        val enemyColor = if (color == Color.WHITE) Color.BLACK else Color.WHITE
        val ids = winCondition.getWinPiecesIds(color, board)
        if(ids.size == 1) {
            val enemyTiles = board.getEnemyTiles(color)
            for ( t in enemyTiles){
                for (v in t.piece?.getValidators()!!){
                    if(validateCheck(t,v,board,ids,enemyColor)) return true else continue
                }
                for (s in t.piece?.getSpecialMoves()!!){
                    if(validateCheck(t,s,board,ids,enemyColor)) return true else continue
                }
            }
        }
        return false
    }

    private fun validateCheck(enemyTile: Tile, validator: ValidatorMove, board: Board, ids: List<String>, enemyColor: Color): Boolean {
        try{
            if(validator.validate(enemyTile,board.getTileById(ids.get(0)),enemyColor,board).bool){
                return true
            }
        } catch (e: Exception) {}
        return false
    }

    fun getWinCondition() : WinCondition{
        return winCondition
    }
}