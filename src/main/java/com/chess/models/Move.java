package com.chess.models;

public class Move {
    private Cell start;
    private Cell end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private Player player;

    public Move(Cell start, Cell end, Piece pieceMoved, Player player) {
        this.start = start;
        this.end = end;
        this.pieceMoved = pieceMoved;
        this.player = player;
        this.pieceKilled = end.getPiece(); // Capture if end cell has a piece
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public Player getPlayer() {
        return player;
    }
}
