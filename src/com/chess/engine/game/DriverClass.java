package com.chess.engine.game;

import com.chess.engine.pieces.Alliance;
import com.chess.gui.Table;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DriverClass {
    public static void main(String[] args) throws IOException {
        Player pesho = new Player("Pesho", "chushki", Alliance.WHITE);
        Player gosho = new Player("Gosho", "domati", Alliance.BLACK);
        Game chessGame = new Game(pesho, gosho);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        chessGame.getGameBoard().displayBoard(bw);
        bw.flush();
        bw.close();
    }
}
