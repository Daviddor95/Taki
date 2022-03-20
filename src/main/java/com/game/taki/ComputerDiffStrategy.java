package com.game.taki;

import java.util.Random;

public class ComputerDiffStrategy implements AIStrategy {

    @Override
    public void doOperation(Player p, ICard current, GameModel game) {
        CardsCollection playersCards = p.getCardsCollect();
        for(ICard card : playersCards){
            if (card.isValidAction(current)){
                card.doAction(game);
                break;
            }
        }
    }
}
