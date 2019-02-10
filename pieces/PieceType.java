package com.chess.engine.pieces;

public enum PieceType {
    ROOK('R'),
    KNIGHT('N'),
    BISHOP('B'),
    QUEEN('Q'),
    KING('K'),
    PAWN('P');
    private char inital;
    PieceType(char initial){
        this.inital = initial;
    }

    @Override
    public String toString() {
        return String.valueOf(this.inital);
    }
}
