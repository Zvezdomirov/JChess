package com.chess.engine.board;

import com.chess.engine.pieces.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Board {

    private ChessTile[][] gameBoard;
    private Alliance nextToPlay;

    public Board() {
        gameBoard = new ChessTile[Constants.ROW_SIZE][Constants.COL_SIZE];
        spawnEmptyBoard(gameBoard);
        configStartingBoard(gameBoard);
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

    private static void spawnEmptyBoard(ChessTile[][] board) {
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COL_SIZE; j++) {
                board[i][j] = new ChessTile(i, j, null);
            }
        }
    }

    public void displayBoard(BufferedWriter bufferedWriter) throws IOException {
        for (ChessTile[] row : gameBoard) {
            for (ChessTile chessTile : row) {
                if (chessTile.getPieceOnTop() == null) {
                    bufferedWriter.write("- ");
                } else {
                    bufferedWriter.write(chessTile.getPieceOnTop().toString() + ' ');
                }
            }
            bufferedWriter.write('\n');
        }
    }

    public ChessTile getTile(int row, int col) {
        return gameBoard[row][col];
    }

    public static void main(String[] args) {
        Board board = new Board();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            board.displayBoard(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
