package com.game.taki;

import java.util.Random;

public class ComputerSimpleStrategy implements AIStrategy{
    private boolean isMyTurnStill = true;

    @Override
    public void doOperation(Player p, ICard current, GameModel game) {
        CardsCollection playersCards = p.getCardsCollect();
        CardsCollection c = new CardsCollection();
        if(p.getNumCardsHeNeedsToDraw()>0){
            for(int k = 0; k < p.getNumCardsHeNeedsToDraw(); k++){
                game.takingCardFromDeck(p);
            }
        }else{
            for(ICard card : playersCards){
                if (card.isValidAction(current)){
                    c.add(card);
                }
            }
            Random random = new Random();
            if(!c.isEmpty() && isMyTurnStill){
                while(game.getNumberOfTimesItsStillMyTurn()>0){
                    game.setNumberOfTimesItsStillMyTurn(game.getNumberOfTimesItsStillMyTurn() - 1);
                    int x = random.nextInt(c.size());
                    c.getCard(x).doAction(game);
                    c.remove(c.getCard(x));
                    if(game.getNumberOfTimesItsStillMyTurn()==0){
                        isMyTurnStill = false;
                    }

                }
                if(game.getNumberOfTimesItsStillMyTurn()==0 && isMyTurnStill){
                    int x = random.nextInt(c.size());
                    c.getCard(x).doAction(game);
                }
            }else{
                game.takingCardFromDeck(p);
            }
            isMyTurnStill = true;
        }


    }
}
