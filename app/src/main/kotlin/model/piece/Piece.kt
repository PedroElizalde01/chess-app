package model.piece

import model.validators.*

interface Piece {
    val id : String
    val type : String?
    val validator : List<ValidatorMove>?
    var data : HashMap<String, Int>
    val isDead : Boolean
    val promotion : Boolean

    fun getSpecialMoves() : List<SpecialValidatorMove>
    fun getValidators() : List<ValidatorMove>
    fun kill ( ) : Piece
    fun getColor() : Color

}