package model.tile

import model.piece.Piece

class TileWithPiece(
    override val piece : Piece?,
    override val x : Int,
    override val y: Int
        ) : Tile {
    override fun pieceArrival(piece: Piece): TileWithPiece {
        return TileWithPiece(piece, x, y)
    }

    override fun pieceDeparture(): TileEmpty {
        return TileEmpty(x,y)
    }

    override fun hasPiece(): Boolean {
        return true
    }


}
