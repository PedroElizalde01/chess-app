package factory

import model.piece.Color
import model.piece.NormalPiece
import model.piece.Piece
import model.piece.SpecialPiece
import model.validators.ValidatorMove
import model.validators.move.*

class PieceFactory {
    fun createPawn(id : String, color : Color) : Piece {
        val hashMap = HashMap<String, Int>()
        hashMap.put("moves", 0)
        return NormalPiece(id,"pawn", listOf(PawnMoveValidator()), hashMap, false, true, color)
    }

    fun createRook(id: String, color : Color) : Piece {
        val hashMap = HashMap<String, Int>()
        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(VerticalMoveValidator(0, true))
        validators.add(VerticalMoveValidator(0, false))
        validators.add(HorizontalMoveValidator(0, false))
        validators.add(HorizontalMoveValidator(0, true))
        return NormalPiece(id, "rook", validators, hashMap, false, false, color)
    }

    fun createKnight(id: String, color : Color) : Piece {
        val hashMap = HashMap<String, Int>()
        val validators = ArrayList<ValidatorMove>()

        hashMap.put("moves", 0)
        validators.add(JumpMoveValidator(1,2))
        validators.add(JumpMoveValidator(2,1))
        validators.add(JumpMoveValidator(1,-2))
        validators.add(JumpMoveValidator(2,-1))
        validators.add(JumpMoveValidator(-1,2))
        validators.add(JumpMoveValidator(-2,1))
        validators.add(JumpMoveValidator(-1,-2))
        validators.add(JumpMoveValidator(-2,-1))
        return NormalPiece(id, "knight", validators, hashMap, false, false, color)
    }

    fun createBishop(id : String, color : Color) : Piece {
        val hashMap = HashMap<String, Int>()
        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(DiagonalMoveValidator(0, listOf(1,2,3,4)))
        return NormalPiece(id, "bishop", validators, hashMap, false, false, color)
    }

    fun createQueen(id : String, color : Color) : Piece {
        val hasMap = HashMap<String, Int>()
        hasMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(VerticalMoveValidator(0, false))
        validators.add(VerticalMoveValidator(0, true))
        validators.add(HorizontalMoveValidator(0, false))
        validators.add(HorizontalMoveValidator(0, false))
        validators.add(DiagonalMoveValidator(0, listOf(1,2,3,4)))
        return NormalPiece(id, "queen", validators, hasMap, false, false, color)
    }

    fun createKing(id: String, color : Color) : Piece {
        val hashMap = HashMap<String, Int>()
        hashMap.put("moves", 0)
        val validators = ArrayList<ValidatorMove>()
        validators.add(VerticalMoveValidator(1, false))
        validators.add(VerticalMoveValidator(1, true))
        validators.add(HorizontalMoveValidator(1, false))
        validators.add(HorizontalMoveValidator(1, false))
        validators.add(DiagonalMoveValidator(1, listOf(1,2,3,4)))
        return NormalPiece(id, "king", validators, hashMap, true, false, color)
    }
}