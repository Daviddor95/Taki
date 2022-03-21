package com.game.taki;

import java.util.Random;

public class ComputerDiffStrategy implements AIStrategy {

    @Override
    public void doOperation(Player p, ICard current, GameModel game) {
        boolean ok = false;
        CardsCollection playersCards = p.getCardsCollect();
        if(p.getNumCardsHeNeedsToDraw()>0) {
            for (int k = 0; k < p.getNumCardsHeNeedsToDraw(); k++) {
                game.takingCardFromDeck(p);
            }
        }else{
            for(ICard card : playersCards){
                if (card.isValidAction(current)){
                    card.doAction(game);
                    ok = true;
                    break;
                }
            }

            if(!ok){
                game.takingCardFromDeck(p);
            }
        }

    }
}
