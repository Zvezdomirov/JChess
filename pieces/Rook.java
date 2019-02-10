package com.chess.engine.pieces;

import com.chess.engine.board.Board;
import com.chess.engine.board.ChessTile;
import com.chess.engine.board.Constants;
import com.chess.engine.board.Move;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {

    public Rook(Alliance pieceAlliance) {
        super(pieceAlliance);
    }

    //The queen also uses this logic.
    @SuppressWarnings("Duplicates")
    @Override
    public Set<Move> calculateLegalMoves(Board board) {

        int xCoord = this.getPiecePosition().getXCoord();
        int yCoord = this.getPiecePosition().getYCoord();

        int tempX;
        int tempY;
        Set<Move> legalMoves = new HashSet<>();


        //Check the straight line of tiles on the left
        for (tempX = xCoord, tempY = yCoord; tempX >= 0; tempX--) {

            //If the current tile is empty, we can add a
            //regular move into the legalMoves set
            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move());

                //If the current tile has an opponent's piece
                //on top, add an attacking move into the legalMoves set
            } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() != this.getPieceAlliance()) {
                legalMoves.add(new Move()); // attacking move

                //The only left case is that the piece on the current tile
                //has an ally piece on top, therefore it is not a legal
                //move and we have to stop looking farther in this direction.
            } else {
                break;
            }
        }

        //The above code is analogical

        //Check the right straight line and so on...
        for (tempX = xCoord, tempY = yCoord; tempX < Constants.ROW_SIZE; tempX++) {

            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move()); //regular move
            } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() == this.getPieceAlliance()) {
                legalMoves.add(new Move()); // attacking move
            } else {
                break;
            }
        }

        for (tempX = xCoord, tempY = yCoord; tempY >= 0; tempY--) {

            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move()); //regular move
            } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() == this.getPieceAlliance()) {
                legalMoves.add(new Move()); // attacking move
            } else {
                break;
            }
        }

        for (tempX = xCoord, tempY = yCoord; tempY < Constants.COL_SIZE; tempY++) {

            if (board.getTile(tempX, tempY).isEmpty()) {
                legalMoves.add(new Move()); //regular move
            } else if (board.getTile(tempX, tempY).getPieceOnTop()
                    .getPieceAlliance() == this.getPieceAlliance()) {
                legalMoves.add(new Move()); // attacking move
            } else {
                break;
            }
        }

        return legalMoves;
    }

    @Override
    public String toString() {
        return PieceType.ROOK.toString();
    }
}
