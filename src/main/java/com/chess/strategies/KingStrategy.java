package com.chess.strategies;

import com.chess.models.Board;
import com.chess.models.Cell;

public class KingStrategy implements PieceStrategy {
    @Override
    public boolean validateMove(Cell start, Cell end, Board board) {
        // Implement king's specific movement rules
        return true;
    }
}
