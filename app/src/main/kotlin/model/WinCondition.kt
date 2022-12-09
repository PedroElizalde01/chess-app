package model

import model.board.Board
import model.piece.Color
import model.piece.Piece

class WinCondition (val pieces : List<Piece>){
    fun getWinPiecesIds(color: Color, board: Board) : List<String> {
        var ids : List<String> = listOf()
        if (pieces.size == 0){
            return emptyList()
        }
        for (i in pieces) {
            if (i.getColor() == color) {
                if (board.getIdOfPieceInBoard().contains(i.id)) ids += i.id
            }
        }
        return ids
    }
}