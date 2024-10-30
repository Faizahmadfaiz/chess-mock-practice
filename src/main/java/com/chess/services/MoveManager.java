package com.chess.services;

import com.chess.enums.GameStatus;
import com.chess.factories.PieceFactory;
import com.chess.factories.PieceFactoryProvider;
import com.chess.models.Board;
import com.chess.models.Move;
import com.chess.models.Piece;
import com.chess.strategies.PieceStrategy;

public class MoveManager {
    private List<Move> movesPlayed;

    public MoveManager() {
        this.movesPlayed = new ArrayList<>();
    }

    public boolean validateMove(Move move, Board board) {
        // Validate if the move follows piece-specific rules
        Piece movedPiece = move.getPieceMoved();
        PieceFactory factory = PieceFactoryProvider.getFactory(movedPiece);
        if (factory != null) {
            PieceStrategy strategy = factory.createStrategy();
            strategy.validateMove(move.getStart(), move.getEnd(), board);G
        }
        return false;
    }

    public void recordMove(Move move) {
        movesPlayed.add(move);
    }

    public GameStatus checkGameStatus(Board board) {
        // Check for check, checkmate, stalemate
        return GameStatus.ACTIVE;
    }
}
