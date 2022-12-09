package model.piece

import model.validators.*

class SpecialPiece (
    override val id : String,
    override val type : String,
    override val validator : List<ValidatorMove>,
    override var data : HashMap<String, Int>,
    private val specialMoves : List<SpecialValidatorMove>,
    override val isDead : Boolean = false,
    override val promotion : Boolean = false,
    private val color : Color ) : Piece {

    override fun getSpecialMoves(): List<SpecialValidatorMove> {
        return specialMoves
    }

    override fun getValidators(): List<ValidatorMove> {
        return validator
    }

    override fun kill(): Piece {
        return SpecialPiece(id, type, validator, data, specialMoves, true, promotion, color)
    }

    override fun getColor(): Color {
        return color
    }
}