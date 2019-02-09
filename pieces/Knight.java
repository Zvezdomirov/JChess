package com.chess.engine.pieces;

import com.chess.engine.board.Move;
import com.chess.engine.board.Board;
import com.chess.engine.board.ChessTile;
import com.chess.engine.board.Constants;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    public Knight(ChessTile piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Set<Move> calculateLegalMoves(Board board) {

        int xCoord = this.getPiecePosition().getXCoord();
        int yCoord = this.getPiecePosition().getYCoord();

        Set<Move> legalMoves = new HashSet<>();

        if (xCoord - 1 >= 0) {
            if (yCoord - 2 >= 0) {
                if (board.getTile(xCoord - 1, yCoord - 2).isEmpty()) {
                    legalMoves.add(new Move());
                } else {
                    if (board.getTile(xCoord - 1, yCoord - 2)
                            .getPieceOnTop().getPieceAlliance() != this.getPieceAlliance()) {
                        legalMoves.add(new Move()); //but an attacking one
                    }
                }

            } else if (yCoord + 2 < Constants.ROW_SIZE) {
                if (board.getTile(xCoord - 1, yCoord + 2).isEmpty()) {
                    legalMoves.add(new Move());
                } else {
                    if (board.getTile(xCoord - 1, yCoord + 2)
                            .getPieceOnTop().getPieceAlliance() != this.getPieceAlliance()) {
                        legalMoves.add(new Move()); //but an attacking one
                    }
                }
            }
        } else if (xCoord + 1 < Constants.COL_SIZE) {
            if (yCoord - 2 >= 0) {
                if (board.getTile(xCoord + 1, yCoord - 2).isEmpty()) {
                    legalMoves.add(new Move());
                } else {
                    if (board.getTile(xCoord + 1, yCoord - 2)
                            .getPieceOnTop().getPieceAlliance() != this.getPieceAlliance()) {
                        legalMoves.add(new Move()); //but an attacking one
                    }
                }

            } else if (yCoord + 2 < Constants.ROW_SIZE) {
                if (board.getTile(xCoord - 1, yCoord - 2).isEmpty()) {
                    legalMoves.add(new Move());
                } else {
                    if (board.getTile(xCoord - 1, yCoord - 2)
                            .getPieceOnTop().getPieceAlliance() != this.getPieceAlliance()) {
                        legalMoves.add(new Move()); //but an attacking one
                    }
                }
            }
        }
        return legalMoves;
    }

    @Override
    public String toString() {
        return PieceType.KNIGHT.toString();
    }
}
