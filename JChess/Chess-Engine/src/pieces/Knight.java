package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = {
            -17, -15, -10, -6, 6, 10, 15,17
    };

    Knight(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Set<Move> calculateLegalMoves(Board board) {
        int candidateDestinationCoordinate;

        final Set<Move> legalMoves = new HashSet<>();

        for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {

            candidateDestinationCoordinate = this.piecePosition + currentCandidate;

            if (BoardUtils.isValidCoordinate(candidateDestinationCoordinate)) {
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                if (!candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new Move());
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                    if (this.pieceAlliance != pieceAlliance) {
                        legalMoves.add(new Move());
                    }
                }
            }
        }
        return ImmutableSet.copyOf(legalMoves);
    }

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -17) || (candidateOffset == -10) ||
        (candidateOffset == 6) || candidateOffset == 15);
    }
}
