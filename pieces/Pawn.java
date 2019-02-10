package com.chess.engine.pieces;

import com.chess.engine.board.Board;
import com.chess.engine.board.ChessTile;
import com.chess.engine.board.Constants;
import com.chess.engine.board.Move;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

    private boolean hasMoved;
    private boolean isInTopBoardTeam;

    public Pawn(Alliance pieceAlliance) {
        super(pieceAlliance);
    }

    @Override
    public Set<Move> calculateLegalMoves(Board board) {

        int xCoord = this.getPiecePosition().getXCoord();
        int yCoord = this.getPiecePosition().getYCoord();

        Set<Move> legalMoves = new HashSet<>();

        if (this.isInTopBoardTeam) {
            if (yCoord + 1 < Constants.COL_SIZE) { //check the tile below
                if (board.getTile(xCoord, yCoord + 1).isEmpty()) {
                    legalMoves.add(new Move()); //regular move
                }
                //check if attacking move is available on the left diagonal
                if (xCoord - 1 >= 0 &&
                        board.getTile(xCoord - 1, yCoord + 1)
                                .getPieceOnTop().getPieceAlliance() != this.getPieceAlliance()) {
                    legalMoves.add(new Move());//attacking move

                }
                //check if attacking move is available on the right diagonal
                if (xCoord + 1 < Constants.ROW_SIZE &&
                        board.getTile(xCoord + 1, yCoord + 1).getPieceOnTop()
                                .getPieceAlliance() != this.getPieceAlliance()) {
                    legalMoves.add(new Move());//attacking move
                }
                //Check if double move is available
                if (!this.hasMoved && yCoord + 2 < Constants.COL_SIZE &&
                        board.getTile(xCoord, yCoord + 2).isEmpty()) {
                    legalMoves.add(new Move());//double move
                }
            }
        } else { //repeat the above logic for the top-board team
            if (yCoord - 1 >= 0) { //check the tile above
                if (board.getTile(xCoord, yCoord - 1).isEmpty()) {
                    legalMoves.add(new Move()); //regular move
                }
                //check if attacking move is available on the left diagonal
                if (xCoord - 1 >= 0 &&
                        board.getTile(xCoord - 1, yCoord + 1)
                                .getPieceOnTop().getPieceAlliance() != this.getPieceAlliance()) {
                    legalMoves.add(new Move());//attacking move

                }
                //check if attacking move is available on the right diagonal
                if (xCoord + 1 < Constants.ROW_SIZE &&
                        board.getTile(xCoord + 1, yCoord + 1).getPieceOnTop()
                                .getPieceAlliance() != this.getPieceAlliance()) {
                    legalMoves.add(new Move());//attacking move
                }

            //Check if double move is available
            if (!this.hasMoved && yCoord - 2 >= 0 &&
                    board.getTile(xCoord, yCoord + 2).isEmpty()) {
                legalMoves.add(new Move());//double move
            }
            }
        }

        return legalMoves;


    }

    @Override
    public String toString() {
        return PieceType.PAWN.toString();
    }
}