package factory

import model.board.Board
import model.piece.Color
import model.tile.Tile
import model.tile.TileEmpty
import model.tile.TileWithPiece

class BoardFactory {
    private val pieceFactory = PieceFactory()

    fun createClassicBoard() : Board {
        var tiles : List<Tile> = mutableListOf()
        tiles += TileWithPiece(pieceFactory.createRook("w11",Color.WHITE), 1,1)
        tiles += TileWithPiece(pieceFactory.createRook("w81",Color.WHITE), 8,1)
        tiles += TileWithPiece(pieceFactory.createRook("b18",Color.BLACK), 1,8)
        tiles += TileWithPiece(pieceFactory.createRook("b88",Color.BLACK), 8,8)

        tiles += TileWithPiece(pieceFactory.createKnight("w21",Color.WHITE), 2,1)
        tiles += TileWithPiece(pieceFactory.createKnight("w71",Color.WHITE), 7,1)
        tiles += TileWithPiece(pieceFactory.createKnight("b28",Color.BLACK), 2,8)
        tiles += TileWithPiece(pieceFactory.createKnight("b78",Color.BLACK), 7,8)

        tiles += TileWithPiece(pieceFactory.createBishop("w31",Color.WHITE), 3,1)
        tiles += TileWithPiece(pieceFactory.createBishop("w61",Color.WHITE), 6,1)
        tiles += TileWithPiece(pieceFactory.createBishop("b38",Color.BLACK), 3,8)
        tiles += TileWithPiece(pieceFactory.createBishop("b68",Color.BLACK), 6,8)

        tiles += TileWithPiece(pieceFactory.createQueen("w41",Color.WHITE), 4,1)
        tiles += TileWithPiece(pieceFactory.createQueen("b48",Color.BLACK), 4,8)

        tiles += TileWithPiece(pieceFactory.createKing("w51",Color.WHITE), 5,1)
        tiles += TileWithPiece(pieceFactory.createKing("b58",Color.BLACK), 5,8)

        for (i in 1..8) tiles += TileWithPiece(pieceFactory.createPawn("w$i 8",Color.WHITE), i,2)
        for (i in 1..8) tiles += TileWithPiece(pieceFactory.createPawn("b$i 7",Color.BLACK), i,7)

        for (i in 1..8) for (j in 3..6) tiles += TileEmpty(i,j)

        return Board(tiles)
    }
}