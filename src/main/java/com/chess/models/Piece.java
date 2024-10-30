package com.chess.models;

import com.chess.enums.Color;

public abstract class Piece {
    protected Color color;
    protected boolean killed = false;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean isValidMove(Cell start, Cell end);
}
