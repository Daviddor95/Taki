package com.game.taki;

public interface AIStrategy {
    void doOperation(Player p, ICard current, GameModel game);
}
