package com.chess.factories;

import com.chess.models.King;
import com.chess.models.Piece;

public class PieceFactoryProvider {
    private static final Map<class<? extends Piece>, PieceFactory> factoryMap = new HashMap();

    static {
        factoryMap.set(King.class, new KingFactory());
        // Register other factories similarly
    }

    public static PieceFactory getFactory(Piece piece) {
        return factoryMap.get(piece.getClass());
    }
}
