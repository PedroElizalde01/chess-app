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

        for (i in 1..8) tiles += TileWithPiece(pieceFactory.createPawn("w$i 2",Color.WHITE), i,2)
        for (i in 1..8) tiles += TileWithPiece(pieceFactory.createPawn("b$i 7",Color.BLACK), i,7)

        for (i in 1..8) for (j in 3..6) tiles += TileEmpty(i,j)

        return Board(tiles)
    }

    //fun createbutterflyBoard() : Board {
        //    var tiles : List<Tile> = mutableListOf()
        //
        //
        //}

    fun createCapablancaBoard() : Board{
        var tiles : List<Tile> = mutableListOf()

        tiles += TileWithPiece(pieceFactory.createRook("w011",Color.WHITE), 1,1)
        tiles += TileWithPiece(pieceFactory.createRook("w101",Color.WHITE), 10,1)
        tiles += TileWithPiece(pieceFactory.createRook("b018",Color.BLACK), 1,8)
        tiles += TileWithPiece(pieceFactory.createRook("b108",Color.BLACK), 10,8)

        tiles += TileWithPiece(pieceFactory.createKnight("w028",Color.WHITE), 2,1)
        tiles += TileWithPiece(pieceFactory.createKnight("w091",Color.WHITE), 9,1)
        tiles += TileWithPiece(pieceFactory.createKnight("b210",Color.BLACK), 2,8)
        tiles += TileWithPiece(pieceFactory.createKnight("b98",Color.BLACK), 9,8)

        tiles += TileWithPiece(pieceFactory.createChancellor("w031",Color.WHITE), 3,1)
        tiles += TileWithPiece(pieceFactory.createArchbichop("w081",Color.WHITE), 8,1)
        tiles += TileWithPiece(pieceFactory.createChancellor("b310",Color.BLACK), 3,8)
        tiles += TileWithPiece(pieceFactory.createArchbichop("b810",Color.BLACK), 8,8)

        tiles += TileWithPiece(pieceFactory.createBishop("w041",Color.WHITE), 4,1)
        tiles += TileWithPiece(pieceFactory.createBishop("w071",Color.WHITE), 7,1)
        tiles += TileWithPiece(pieceFactory.createBishop("b410",Color.BLACK), 4,8)
        tiles += TileWithPiece(pieceFactory.createBishop("b710",Color.BLACK), 7,8)

        tiles += TileWithPiece(pieceFactory.createQueen("w051",Color.WHITE), 5,1)
        tiles += TileWithPiece(pieceFactory.createQueen("b610",Color.BLACK), 6,8)

        tiles += TileWithPiece(pieceFactory.createKing("w061",Color.WHITE), 6,1)
        tiles += TileWithPiece(pieceFactory.createKing("b510",Color.BLACK), 5,8)

        for (i in 1..10) tiles += TileWithPiece(pieceFactory.createPawn("w$i 2",Color.WHITE), i,2)
        for (i in 1..10) tiles += TileWithPiece(pieceFactory.createPawn("b$i 7",Color.BLACK), i,7)

        for (i in 1..10) for (j in 3..6) tiles += TileEmpty(i,j)

        return Board(tiles)
    }

    fun createAntiPawnBoard() : Board {
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

        for (i in 1..8) tiles += TileWithPiece(pieceFactory.createAntiPawn("w$i 2",Color.WHITE), i,2)
        for (i in 1..8) tiles += TileWithPiece(pieceFactory.createAntiPawn("b$i 7",Color.BLACK), i,7)

        for (i in 1..8) for (j in 3..6) tiles += TileEmpty(i,j)

        return Board(tiles)
    }
}