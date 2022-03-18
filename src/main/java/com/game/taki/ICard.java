package com.game.taki;

public interface ICard {
    void doAction(GameModel game);
    boolean isValidAction(ICard current);
    String getName();
    String getColor();

}
