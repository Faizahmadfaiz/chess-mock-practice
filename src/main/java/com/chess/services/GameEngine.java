package com.chess.services;

import com.chess.enums.GameStatus;
import com.chess.models.Board;
import com.chess.models.Move;
import com.chess.models.Player;

public class GameEngine {
    private Board board;
    private Player[] players;
    private GameStatus status;
    private TurnManager turnManager;
    private MoveManager moveManager;
    private DisplayManager displayManager;

    public GameController(Player[] players) {
        this.board = new Board();
        this.players = players;
        this.status = GameStatus.ACTIVE;
        this.turnManager = new TurnManager(players[0]); // Start with one player
        this.moveManager = new MoveManager();
        this.displayManager = new DisplayManager();
    }

    public void startGame() {
        // Initialize game components
        board.resetBoard();
        displayManager.showBoard(board);

        // Main game loop
        while (status == GameStatus.ACTIVE) {
            // Call makeMove for the current player
            makeMove();

            // After the move, check if the game has ended
            if (status != GameStatus.ACTIVE) {
                break; // Exit the loop if there's a win, stalemate, or resignation
            }
        }

        // Display the final result
        displayFinalStatus();
    }

    public void assignTurn() {
        // Logic to assign the turn to the correct player
        turnManager.switchTurn();
    }

    // Method to get the current player from TurnManager
    public Player getCurrentPlayer() {
        return turnManager.getCurrentPlayer();
    }

    // Make a move by current player
    public void makeMove() {
        // 1. Get the current player
        Player currentPlayer = getCurrentPlayer();

        // 2. Get the move from the player
        Move move = currentPlayer.makeMove();

        // 3. Validate the move
        if (moveManager.validateMove(move, board)) {
            // 4. Update the board with the move
            board.updateBoard(move);

            // 5. Record the move
            moveManager.recordMove(move);

            // 6. Check the game status (e.g., checkmate, stalemate)
            status = moveManager.checkGameStatus(board);

            // 7. Display the updated board
            displayManager.showBoard(board);

            // 8. Switch to the next player
            turnManager.switchTurn();
        } else {
            System.out.println("Invalid move. Please try again.");
        }
    }

    // Helper method to get the current player
    public Player getCurrentPlayer() {
        return turnManager.getCurrentPlayer();
    }

    // Display final status after game ends
    private void displayFinalStatus() {
        switch (status) {
            case WHITE_WIN:
                System.out.println("White wins!");
                break;
            case BLACK_WIN:
                System.out.println("Black wins!");
                break;
            case STALEMATE:
                System.out.println("Game is a draw (Stalemate).");
                break;
            default:
                System.out.println("Game ended unexpectedly.");
                break;
        }
    }
}
