package com.chess.engine.board;

import java.io.BufferedWriter;
import java.io.IOException;

public class Board {
    private ChessTile[][] boardTiles;

    public Board() {
        boardTiles = new ChessTile[Constants.ROW_SIZE][Constants.COL_SIZE];
        spawnEmptyBoard(boardTiles);
    }

    public ChessTile[][] getBoardTiles() {
        return boardTiles;
    }

    private static void spawnEmptyBoard(ChessTile[][] board) {
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COL_SIZE; j++) {
                board[i][j] = new ChessTile(i, j, null);
            }
        }
    }
    public void displayBoard(BufferedWriter bufferedWriter) throws IOException {
        for (ChessTile[] row : boardTiles) {
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
        return boardTiles[row][col];
    }
}
