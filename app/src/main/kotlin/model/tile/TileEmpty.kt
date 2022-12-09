package model.tile

import model.piece.Piece

class TileEmpty (
    override val x : Int,
    override val y: Int,
    override val piece : Piece? = null
) : Tile {

    override fun pieceArrival(piece: Piece): TileWithPiece {
        return TileWithPiece(piece, x, y)
    }

    override fun pieceDeparture(): TileEmpty {
        return TileEmpty(x,y)
    }

    override fun hasPiece(): Boolean {
        return false;
    }

}