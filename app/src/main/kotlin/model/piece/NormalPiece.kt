package model.piece

import model.validators.SpecialValidatorMove
import model.validators.ValidatorMove

class NormalPiece (
    override val id : String,
    override val type : String?,
    override val validator : List<ValidatorMove>,
    override var data : HashMap<String, Int>,
    override val isDead : Boolean = false,
    override val promotion : Boolean = false,
    private val color : Color ) : Piece {

    override fun getSpecialMoves(): List<SpecialValidatorMove> {
        return listOf()
    }

    override fun getValidators(): List<ValidatorMove> {
        return validator
    }

    override fun kill(): Piece {
        return NormalPiece(id, type, validator, data, true, promotion, color)
    }

    override fun getColor(): Color {
        return color
    }
}