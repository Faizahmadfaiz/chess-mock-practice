package com.chess.models;

public class Board {
    private final int rows = 8;
    private final int columns = 8;
    private Cell[][] cells;

    public Board() {
        this.cells = new Cell[rows][columns];
        resetBoard();
    }

    public void resetBoard() {
        // Initialize board and place pieces in starting positions
    }

    public void updateBoard(Move move) {
        // Execute the move, update piece positions on board
        movePiece(move.getStart(), move.getEnd());
    }

    private void movePiece(Cell start, Cell end) {
        end.setPiece(start.getPiece());
        start.setPiece(null);
    }
}
