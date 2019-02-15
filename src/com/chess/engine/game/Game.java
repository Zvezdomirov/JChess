package com.chess.engine.game;

import com.chess.engine.board.Board;
import com.chess.engine.board.ChessTile;
import com.chess.engine.board.Constants;
import com.chess.engine.pieces.*;
import com.chess.gui.Table;

public class Game {

    final private Board gameBoard = new Board(); //One instance per game
    private Player whitePlayer;
    private Player blackPlayer;
    private Alliance playerOnTurn;
    private Table table;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        configStartingBoard(gameBoard.getBoardTiles());
        table = new Table(this.gameBoard);
        setPlayerOnTurn(Alliance.WHITE);
    }

    public Alliance getPlayerOnTurn() {
        return playerOnTurn;
    }

    public void setPlayerOnTurn(Alliance playerOnTurn) {
        this.playerOnTurn = playerOnTurn;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public Player getWhitePlayer() {
        return whitePlayer;
    }

    public Player getBlackPlayer() {
        return blackPlayer;
    }

    private static void configStartingBoard(ChessTile[][] board) {
        //Set the black pieces
        board[0][0].setPieceOnTop(new Rook(Alliance.BLACK));
        board[0][1].setPieceOnTop(new Knight(Alliance.BLACK));
        board[0][2].setPieceOnTop(new Bishop(Alliance.BLACK));
        board[0][3].setPieceOnTop(new Queen(Alliance.BLACK));
        board[0][4].setPieceOnTop(new King(Alliance.BLACK));
        board[0][5].setPieceOnTop(new Bishop(Alliance.BLACK));
        board[0][6].setPieceOnTop(new Knight(Alliance.BLACK));
        board[0][7].setPieceOnTop(new Rook(Alliance.BLACK));
        for (int i = 0; i < Constants.COL_SIZE; i++) {
            board[1][i].setPieceOnTop(new Pawn(Alliance.BLACK));
        }
        //Set the white pieces

        for (int i = 0; i < Constants.COL_SIZE; i++) {
            board[6][i].setPieceOnTop(new Pawn(Alliance.WHITE));
        }
        board[7][0].setPieceOnTop(new Rook(Alliance.WHITE));
        board[7][1].setPieceOnTop(new Knight(Alliance.WHITE));
        board[7][2].setPieceOnTop(new Bishop(Alliance.WHITE));
        board[7][3].setPieceOnTop(new Queen(Alliance.WHITE));
        board[7][4].setPieceOnTop(new King(Alliance.WHITE));
        board[7][5].setPieceOnTop(new Bishop(Alliance.WHITE));
        board[7][6].setPieceOnTop(new Knight(Alliance.WHITE));
        board[7][7].setPieceOnTop(new Rook(Alliance.WHITE));
    }
}
