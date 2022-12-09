package model.board

import model.piece.Color
import model.piece.Piece
import model.tile.Tile
import java.lang.Exception
import kotlin.math.abs

class Board (private val tiles : List<Tile>){

    fun updateBoard(from : Tile, to : Tile) : Board {
        val mutTiles = mutableListOf<Tile>()
        for (t in tiles){
            if ( t.x == from.x && t.y == from.y){
                mutTiles.add(t.pieceDeparture())
                continue
            }
            if(t.x == to.x && t.y == to.y){
                mutTiles.add(t.pieceArrival(from.piece!!))
                continue
            }
            mutTiles.add(t)
        }
        return Board(mutTiles)
    }

    fun promotePiece(tile : Tile, piece : Piece) : Board{
        val mutTiles = mutableListOf<Tile>()
        for (t in tiles){
            if (t.x == tile.x && t.y == tile.y){
                mutTiles.add(t.pieceArrival(piece))
                continue
            }
            mutTiles.add(t)
        }
        return Board(mutTiles)
    }

    fun getPath(from: Tile, to: Tile) : List<Tile> {
        val path = mutableListOf<Tile>()
        val fromX = from.x
        val fromY = from.y
        val toX = to.x
        val toY = to.y
        if (fromX == toX) {
            val yMin = minOf(fromY, toY)
            val yMax = maxOf(fromY, toY)
            for (y in yMin + 1 until yMax) {
                path.add(getTile(fromX, y))
            }
        } else if (fromY == toY) {
            val xMin = minOf(fromX, toX)
            val xMax = maxOf(fromX, toX)
            for (x in xMin + 1 until xMax) {
                path.add(getTile(x, fromY))
            }
        } else {
            val xMin = minOf(fromX, toX)
            val xMax = maxOf(fromX, toX)
            val yMin = minOf(fromY, toY)
            val yMax = maxOf(fromY, toY)
            for (x in xMin + 1 until xMax) {
                for (y in yMin + 1 until yMax) {
                    if (abs(x - fromX) == abs(y - fromY)) {
                        path.add(getTile(x, y))
                    }
                }
            }
        }
        return path
    }

    fun getTile (x : Int, y : Int) : Tile {
        return tiles.first{ it.x == x && it.y == y }
    }

    fun getIdOfPieceInBoard() : List<String> {
        val idOfPieces = mutableListOf<String>()
        tiles.forEach{
            if (it.hasPiece()){
                idOfPieces.add(it.piece!!.id)
            }
        }
        return idOfPieces
    }

    fun getEnemyTiles (color : Color) : List<Tile>{
        val enemyTiles = mutableListOf<Tile>()
        tiles.forEach{
            if (it.hasPiece()){
                if (it.piece!!.getColor() != color){
                    enemyTiles.add(it)
                }
            }
        }
        return enemyTiles
    }

    fun getAllyTiles (color : Color) : List<Tile>{
        val allyTiles = mutableListOf<Tile>()
        tiles.forEach{
            if (it.hasPiece()){
                if (it.piece!!.getColor() == color){
                    allyTiles.add(it)
                }
            }
        }
        return allyTiles
    }

    fun getTileById(id : String) : Tile {
        for (t in tiles){
            if( t.hasPiece()){
                if(t.piece!!.id == id){
                    return t
                }
            }
        }
        throw Exception("No piece with id $id")
    }

    fun getTiles() : List<Tile>{
        return tiles
    }

    fun getBoardWidth() : Int {
        return tiles.maxOf { it.x }
    }

    fun getBoardHeight() : Int {
        return tiles.maxOf { it.y }
    }

    fun getAllPieces() : List<Piece> {
        val pieces = mutableListOf<Piece>()
        tiles.forEach{
            if ( it.hasPiece())
                pieces.add(it.piece!!)
        }
        return pieces
    }

}