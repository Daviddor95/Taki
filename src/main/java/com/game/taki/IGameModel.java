package com.game.taki;

import java.util.ArrayList;
import java.util.List;

public abstract class IGameModel {
    public abstract void intializeGame(ArrayList<Player> players, ArrayList<String> colorsInGame, int initialNumberOfCardsInHand);
    public abstract void courseOfGame();
    public abstract boolean isWinning(Player p);
    public abstract List<ICard> getPlayerHand();
}
