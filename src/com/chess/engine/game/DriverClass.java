package com.chess.engine.game;

import com.chess.engine.pieces.Alliance;
import com.chess.gui.Table;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DriverClass {
    public static void main(String[] args) throws IOException {
        Player john= new Player("John", "pass123", Alliance.WHITE);
        Player peter = new Player("Peter", "pass456", Alliance.BLACK);
        Game chessGame = new Game(john, peter);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        chessGame.getGameBoard().displayBoard(bw);
        bw.flush();
        bw.close();
    }
}
