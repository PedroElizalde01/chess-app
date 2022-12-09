package model

import edu.austral.dissis.chess.gui.*
import factory.GameFactory
import model.piece.Color

class CustomGameEngine : GameEngine {

    var classic = GameFactory().createClassicGame()

    override fun applyMove(move: Move): MoveResult {
        try {
            if (classic.isInCheckMate()) {
                if (classic.getTurn() == Color.WHITE) {
                    return GameOver(PlayerColor.BLACK)
                } else {
                    return GameOver(PlayerColor.WHITE)
                }
            }
            classic = classic.movePiece(move.from.column, move.from.row, move.to.column, move.to.row)
            if (classic.getTurn() == Color.WHITE) {
                val moveResult = NewGameState(chessPieces(), PlayerColor.WHITE)
                if (classic.isInCheckMate()) {
                    return GameOver(PlayerColor.BLACK)
                }
                return moveResult
            } else {
                val moveResult = NewGameState(chessPieces(), PlayerColor.BLACK)
                if (classic.isInCheckMate()) {
                    return GameOver(PlayerColor.WHITE)
                }
                return moveResult
            }
        } catch(e : Exception){
            return InvalidMove(e.message.toString())
        }
    }

    override fun init(): InitialState {
        return InitialState(BoardSize(8,8), chessPieces(), PlayerColor.WHITE)
    }

    private fun chessPieces() : List<ChessPiece>{
        val listChessPieces = ArrayList<ChessPiece>()
        for ( piece in classic.getBoard().getAllPieces()){
            val tile = classic.getBoard().getTileById(piece.id)
            if ( piece.getColor() == Color.WHITE){
                listChessPieces.add(ChessPiece(piece.id, PlayerColor.WHITE, Position(tile.y, tile.x), piece.type.toString()))
            }else{
                listChessPieces.add(ChessPiece(piece.id, PlayerColor.BLACK, Position(tile.y, tile.x), piece.type.toString()))
            }
        }
        return listChessPieces
    }
}

