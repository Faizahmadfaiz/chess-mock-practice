package com.chess.factories;

import com.chess.strategies.KingStrategy;
import com.chess.strategies.PieceStrategy;

public class KingFactory implements PieceFactory {
    @Override
    public PieceStrategy createStrategy() {
        return new KingStrategy();
    }
}
