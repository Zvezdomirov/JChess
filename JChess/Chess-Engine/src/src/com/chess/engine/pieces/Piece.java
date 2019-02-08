package com.chess.engine.pieces;

import com.chess.engine.board.Move;
import com.chess.engine.game.Board;
import com.chess.engine.game.ChessTile;
import java.util.Set;

public abstract class Piece {
    private Alliance pieceAlliance;
    private ChessTile piecePosition;

    Piece (ChessTile piecePosition, Alliance pieceAlliance) {
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
    }

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    };
    public ChessTile getPiecePosition() {
        return piecePosition;
    };
    public abstract Set<Move> calculateLegalMoves(Board board);
}
