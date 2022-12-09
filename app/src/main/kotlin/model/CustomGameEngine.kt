package model

import edu.austral.dissis.chess.gui.*
import model.piece.Color
import java.util.*

class CustomGameEngine(var game:Game) : GameEngine {

    override fun applyMove(move: Move): MoveResult {
        try {
            if (game.isInCheckMate()) {
                if (game.getTurn() == Color.WHITE) {
                    return GameOver(PlayerColor.BLACK)
                } else {
                    return GameOver(PlayerColor.WHITE)
                }
            }
            game = game.movePiece(move.from.column, move.from.row, move.to.column, move.to.row)
            if (game.getTurn() == Color.WHITE) {
                val moveResult = NewGameState(chessPieces(), PlayerColor.WHITE)
                if (game.isInCheckMate()) {
                    return GameOver(PlayerColor.BLACK)
                }
                return moveResult
            } else {
                val moveResult = NewGameState(chessPieces(), PlayerColor.BLACK)
                if (game.isInCheckMate()) {
                    return GameOver(PlayerColor.WHITE)
                }
                return moveResult
            }
        } catch(e : Exception){
            return InvalidMove(e.message.toString())
        }
    }

    override fun init(): InitialState {
        return InitialState(BoardSize(game.getBoard().getBoardWidth(),game.getBoard().getBoardHeight()), chessPieces(), PlayerColor.WHITE)
    }

    private fun chessPieces() : List<ChessPiece>{
        val listChessPieces = ArrayList<ChessPiece>()
        for ( piece in game.getBoard().getAllPieces()){
            val tile = game.getBoard().getTileById(piece.id)
            if ( piece.getColor() == Color.WHITE){
                listChessPieces.add(ChessPiece(piece.id, PlayerColor.WHITE, Position(tile.y, tile.x), piece.type.toString()))
            }else{
                listChessPieces.add(ChessPiece(piece.id, PlayerColor.BLACK, Position(tile.y, tile.x), piece.type.toString()))
            }
        }
        return listChessPieces
    }
}

