package com.game.taki;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class ComputerSimpleStrategy implements AIStrategy{

    @Override
    public void doOperation(Player p, ICard current, GameModel game) {
        CardsCollection playersCards = p.getCardsCollect();
        CardsCollection c = new CardsCollection();
        for(ICard card : playersCards){
            if (card.isValidAction(current)){
                c.add(card);
            }
        }
        Random random = new Random();
        int x = random.nextInt(c.size());
        c.getCardsFromCollection().get(x).doAction(game);
    }
}
