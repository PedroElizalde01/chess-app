package model.validators

import model.board.Board
import model.piece.Color
import model.tile.Tile

abstract class ClassicValidator : ValidatorMove {

    private fun validatePath(from: Tile, to: Tile, board: Board): Response {
        board.getPath(from, to).forEach {
            if (it.hasPiece()) return Response(false, "There is a piece in the path")
        }
        return Response(true, "")
    }

    private fun validateAllyInDestination(to: Tile, color: Color): Response {
        if (to.hasPiece() && to.piece?.getColor() == color) return Response(
            false,
            "There is an ally piece in that tile"
        )
        return Response(true, "")
    }

    private fun validateIsMyPiece(from: Tile, color: Color): Response {
        if (from.piece?.getColor() != color) return Response(false, "You can't move an enemy piece")
        return Response(true, "")
    }

    fun validateSameTile(from: Tile, to: Tile): Response {
        if (from == to) return Response(false, "You can't move to the same tile")
        return Response(true, "")
    }

    fun validateClassicConditions(from: Tile, to: Tile, color: Color, board: Board): Response {
        return if (validateIsMyPiece(from, color).bool) {
            if (validatePath(from, to, board).bool) {
                if (validateAllyInDestination(to, color).bool) {
                    if (validateSameTile(from, to).bool) {
                        Response(true, "")
                    } else {
                        validateSameTile(from, to)
                    }
                } else {
                    validateAllyInDestination(to, color)
                }
            } else {
                validatePath(from, to, board)
            }
        } else {
            validateIsMyPiece(from, color)
        }
    }

    fun validatePieceAndDestination(from: Tile, to: Tile, color: Color): Response {
        return if (validateIsMyPiece(from, color).bool) {
            if (validateSameTile(from, to).bool) {
                if (validateAllyInDestination(to, color).bool) {
                    Response(true, "")
                } else {
                    validateAllyInDestination(to, color)
                }
            } else {
                validateSameTile(from, to)
            }
        } else {
            validateIsMyPiece(from, color)
        }
    }
}