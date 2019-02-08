package com.chess.engine.board;

public class Board {
    private final ChessTile[][] board;

    public Board() {
        board = new ChessTile[Constants.ROW_SIZE][Constants.COL_SIZE];
    }

    public ChessTile getTile(int row, int col) {
        return board[row][col];
    }
    //probably won't need it, because we will spawn the board with
    //the pieces on top
    /*private static void spawnEmptyBoard(ChessTile[][] board) {
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COL_SIZE; j++) {
                board[i][j] = new ChessTile(i, j, null);
            }
        }
    }*/

}
