package com.chess.models;

import com.chess.enums.Color;

public class King {
   public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Cell start, Cell end) {
        // Implement King's move validation logic here
        return true;
    } 
}
