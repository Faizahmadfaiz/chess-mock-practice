package com.chess.models;

import com.chess.enums.Color;

public abstract class Player {
    protected String name;
    protected Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Move makeMove();
}
