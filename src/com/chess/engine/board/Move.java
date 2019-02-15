package com.chess.engine.board;

import com.chess.engine.game.Player;
import com.chess.engine.pieces.Piece;

public class Move {
    private Piece pieceToMove;
    private ChessTile moveCoordinate;
    private MoveType moveType;
    private Board currentBoard;

    public Move(MoveType moveType) {
        this.moveType = moveType;
    }

    public void movePiece(Player attackedPlayer) {
        if (moveType.equals(MoveType.REGULAR)) {
            regularMove();
        } else if (moveType.equals(MoveType.ATTACKING) &&
                attackedPlayer != null){
            attackingMove(attackedPlayer);
        }
    }

    private void regularMove() {
        int oldXCoord = pieceToMove.getPiecePosition().getXCoord();
        int oldYCoord = pieceToMove.getPiecePosition().getYCoord();
        moveCoordinate.setPieceOnTop(pieceToMove);
        currentBoard.getTile(oldXCoord, oldYCoord).setPieceOnTop(null);
    }

    private void attackingMove(Player attackedPlayer) {
        int oldXCoord = pieceToMove.getPiecePosition().getXCoord();
        int oldYCoord = pieceToMove.getPiecePosition().getYCoord();
        Piece capturedPiece = currentBoard.getTile(
                moveCoordinate.getXCoord(), moveCoordinate.getYCoord()).getPieceOnTop();

        moveCoordinate.setPieceOnTop(pieceToMove);
        attackedPlayer.addCapturedPiece(capturedPiece);
        currentBoard.getTile(oldXCoord, oldYCoord).setPieceOnTop(null);
    }

}
