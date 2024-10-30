package com.chess.strategies;

import com.chess.models.Board;
import com.chess.models.Cell;

public interface PieceStrategy {
    boolean validateMove(Cell start, Cell end, Board board);
}
