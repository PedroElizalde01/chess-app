package model.tile

import model.piece.Piece

interface Tile {
    val piece : Piece?
    val x : Int
    val y : Int

    fun pieceArrival(piece : Piece) : TileWithPiece

    fun pieceDeparture() : TileEmpty

    fun hasPiece() : Boolean
}