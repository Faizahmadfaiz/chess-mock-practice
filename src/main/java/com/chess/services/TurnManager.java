package com.chess.services;

import com.chess.models.Player;

public class TurnManager {
    private Player currentTurn;

    public TurnManager(Player startingPlayer) {
        this.currentTurn = startingPlayer;
    }

    public Player getCurrentPlayer() {
        return currentTurn;
    }

    public void switchTurn() {
        // Switch current player
    }
}
