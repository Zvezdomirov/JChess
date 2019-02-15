package com.chess.engine.pieces;

import com.chess.engine.board.*;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    public Bishop(Alliance pieceAlliance) {
        super(pieceAlliance);
    }


    //The queen also uses this logic
    @SuppressWarnings("Duplicates")
    @Override
    public Set<Move> calculateLegalMoves(Board board) {

        int xCoord = this.getPiecePosition().getXCoord();
        int yCoord = this.getPiecePosition().getYCoord();

        int tempX;
        int tempY;

        Set<Move> legalMoves = new HashSet<>();

        //Check the upper-left diagonal
        for (tempX = xCoord, tempY = yCoord;
                tempX >= 0 && tempY <= Constants.COL_SIZE;
                tempX--, tempY++) {

            //If the current tile is empty, we can add a
            //regular move into the legalMoves set
            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR));

              //If the current tile has an opponent's piece
              //on top, add an attacking move into the legalMoves set
            } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() != this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING)); // attacking move

                //The only left case is that the piece on the current tile
                //has an ally piece on top, therefore it is not a legal
                //move and we have to stop looking farther in this direction.
            } else {
                break;
            }
        }

        //The above code is analogical

        //Check the lower-left diagonal and so on...
        for (tempX = xCoord, tempY = yCoord;
                tempX >= 0 && tempY >= 0;
                tempX--, tempY--) {

            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR)); //regular move
            } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() == this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING)); // attacking move
            } else {
                break;
            }
        }

        for (tempX = xCoord, tempY = yCoord;
             tempX < Constants.ROW_SIZE && tempY >= 0;
             tempX++, tempY--) {

            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR)); //regular move
                } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() == this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING)); // attacking move
            } else {
                break;
            }
        }

        for (tempX = xCoord, tempY = yCoord;
             tempX < Constants.ROW_SIZE && tempY < Constants.COL_SIZE;
             tempX++, tempY++) {

            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move(MoveType.REGULAR)); //regular move
            } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() == this.getPieceAlliance()) {
                legalMoves.add(new Move(MoveType.ATTACKING)); // attacking move
            } else {
                break;
            }
        }

        return legalMoves;
    }

    @Override
    public String toString() {
        return PieceType.BISHOP.toString();
    }
}
