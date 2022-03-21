package com.game.taki;

public abstract class IGameModel {
    public abstract void initializeGame();
    public abstract void gameRound();
    public abstract boolean isWinning(Player p);
    public abstract CardsCollection getPlayerHand();
}
