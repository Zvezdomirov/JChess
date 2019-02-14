package com.chess.engine.pieces;

import com.chess.engine.board.*;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece{


    public King(Alliance pieceAlliance) {
        super(pieceAlliance);
    }


    //The code below the first "if" is pretty much the same
    //because we have to check all four directions
    @SuppressWarnings("Duplicates")
    @Override
    public Set<Move> calculateLegalMoves(Board board) {

        int xCoord = this.getPiecePosition().getXCoord();
        int yCoord = this.getPiecePosition().getYCoord();

        Set<Move> legalMoves = new HashSet<>();


        //Check the tile on the left
        if (xCoord - 1 >= 0) {
            //if it's free, add a regular move to the legalMoves set
            if (board.getTile(xCoord - 1, yCoord).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR));
                //else if it's occupied by an enemy piece, add
                //an attacking move to the legalMoves set
            } else if (board.getTile(xCoord - 1, yCoord).getPieceOnTop()
                    .getPieceAlliance() != this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING));
            }
        }
        //The above code is analogical
        if(xCoord + 1 < Constants.ROW_SIZE) {
            if (board.getTile(xCoord + 1, yCoord).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR)); // regular move
            } else if (board.getTile(xCoord + 1, yCoord).getPieceOnTop()
                    .getPieceAlliance() != this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING)); // attacking move
            }
        }

        if(yCoord - 1 >= 0) {
            if (board.getTile(xCoord, yCoord - 1).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR)); // regular move
            } else if (board.getTile(xCoord, yCoord - 1).getPieceOnTop()
                    .getPieceAlliance() != this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING)); // attacking move
            }
        }

        if(yCoord + 1 < Constants.ROW_SIZE) {
            if (board.getTile(xCoord, yCoord + 1).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR)); // regular move
            } else if (board.getTile(xCoord, yCoord + 1).getPieceOnTop()
                    .getPieceAlliance() != this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING)); // attacking move
            }
        }

        return legalMoves;
    }

    @Override
    public String toString() {
        return PieceType.KING.toString();
    }
}
