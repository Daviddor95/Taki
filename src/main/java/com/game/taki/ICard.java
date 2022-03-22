package com.game.taki;

public interface ICard {
    void doAction(GameModel game);
    boolean isValidAction(ICard current, GameModel g);
    String getName();
    String getColor();
}
