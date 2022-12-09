package model.validators

import model.WinCondition
import model.board.Board
import model.piece.Color
import model.piece.NormalPiece
import model.piece.Piece
import model.tile.Tile

class ClassicMover(val checkValidator: CheckValidator, val promotionPiece : Piece) {
    val winCondition : WinCondition = checkValidator.getWinCondition()

    fun movePiece(from: Tile, to: Tile, board: Board, color: Color) : Board{
        var enemyColor : Color
        if(color == Color.WHITE){
            enemyColor = Color.BLACK
        } else {
            enemyColor = Color.WHITE
        }
        val winConditionList = winCondition.getWinPiecesIds(color,board)
        if(winConditionList.size == 1){
            if(to.piece?.id == winConditionList.get(0)){
                throw Exception("You can't capture the alst win condition")
            }
        }
        if(from.piece?.getColor() != color){
            throw Exception("Its not your turn")
        }
        for ( v in from.piece!!.getValidators()){
            val response = v.validate(from,to,color,board)
            if(response.bool){
                var newBoard = board.updateBoard(from,to)
                if(checkValidator.validate(newBoard,color)){
                    throw Exception("Your king is in check")
                }
                from.piece!!.data["moves"] = from.piece!!.data["moves"]!! + 1
                if(PromotionValidator.validate(color,newBoard,newBoard.getTile(to.x,to.y)).bool){
                    val oldPiece = newBoard.getTile(to.x,to.y).piece
                    if(oldPiece != null){
                        newBoard = newBoard.promotePiece(to, NormalPiece(oldPiece.id,promotionPiece.type.toString(),promotionPiece.getValidators(),oldPiece.data,false, false, oldPiece.getColor()))
                    }
                }
                return newBoard
            }
        }
        for (specialMove in from.piece!!.getSpecialMoves()){
            val res = specialMove.validate(from,to,color,board)
            if(res.bool) {
                var newBoard = board.updateBoard(from, to)
                if (checkValidator.validate(newBoard, color)) {
                    throw Exception("Your king is in check")
                }
                from.piece!!.data["moves"] = from.piece!!.data["moves"]!! + 1
                val finalPosition = specialMove.getFinalPosition(color, board, to)
                for (tile in finalPosition) {
                    if (tile.hasPiece()) {
                        val newTile = tile.piece?.let { board.getTileById(it.id) }
                        newBoard = newBoard.updateBoard(newTile!!, tile)
                    }
                }
                if (checkValidator.validate(newBoard, color))
                    throw Exception("Your king is in check")
                if(PromotionValidator.validate(color,newBoard, to).bool){
                    val oldPiece = newBoard.getTile(to.x,to.y).piece
                    if(oldPiece != null)
                        newBoard = newBoard.promotePiece(to,NormalPiece(oldPiece.id,promotionPiece.type.toString(),promotionPiece.getValidators(),oldPiece.data,false, false, oldPiece.getColor()))
                }
                return newBoard
            }
        }
        throw Exception("Invalid move")
    }
}