package com.game.taki;

import java.util.Random;

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
        if(!c.isEmpty()){
            int x = random.nextInt(c.size());
            c.getCard(x).doAction(game);
        }else{
                //game.setDeck(game.);
           // p.addToPlayersCollection();
        }

    }
}
