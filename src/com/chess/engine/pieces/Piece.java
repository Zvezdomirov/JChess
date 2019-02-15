package com.chess.engine.pieces;

import com.chess.engine.board.Move;
import com.chess.engine.board.Board;
import com.chess.engine.board.ChessTile;
import java.util.Set;

public abstract class Piece {
    private Alliance pieceAlliance;
    private ChessTile piecePosition;

    Piece (Alliance pieceAlliance) {
        this.pieceAlliance = pieceAlliance;
    }

    public void setPiecePosition(ChessTile piecePosition) {
        this.piecePosition = piecePosition;
    }
    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    };
    public ChessTile getPiecePosition() {
        return piecePosition;
    };
    public abstract Set<Move> calculateLegalMoves(Board board);
    public abstract String toString();
}
