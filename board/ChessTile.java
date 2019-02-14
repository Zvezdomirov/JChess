package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class ChessTile extends TwoDimPoint {

    private Piece pieceOnTop;

    ChessTile(int xCoord, int yCoord, Piece pieceOnTop) {
        super(xCoord, yCoord);
        this.setPieceOnTop(pieceOnTop);
    }

    public boolean isEmpty() {
        return pieceOnTop == null;
    }

    public Piece getPieceOnTop() {
        return pieceOnTop;
    }

    public void setPieceOnTop(Piece pieceOnTop) {
        this.pieceOnTop = pieceOnTop;
    }
}
