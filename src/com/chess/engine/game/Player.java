package com.chess.engine.game;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.pieces.Alliance;
import com.chess.engine.pieces.Piece;

import java.util.Set;

public class Player {
    private String userName;
    private String password;
    private Alliance alliance;
    private Set<Piece> activePieces;
    private Set<Piece> capturedPieces;
    private boolean hasCastled;
    private boolean hasPawnDoubleMove;

    public Player(String userName, String password,
                  Alliance alliance) {
        this.userName = userName;
        this.password = password;
        this.alliance = alliance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Piece> getActivePieces() {
        return activePieces;
    }

    public void setActivePieces(Set<Piece> activePieces) {
        this.activePieces = activePieces;
    }

    public Set<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public void setCapturedPieces(Set<Piece> capturedPieces) {
        this.capturedPieces = capturedPieces;
    }

    public void addCapturedPiece(Piece capturedPiece) {
        capturedPieces.add(capturedPiece);
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }
}
