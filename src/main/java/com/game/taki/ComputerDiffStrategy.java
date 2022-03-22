package com.game.taki;

import java.util.Random;

public class ComputerDiffStrategy implements AIStrategy {

    //The same as ComputerSimpleStrategy, but we pick the first valid card we can use
    @Override
    public void doOperation(Player p, ICard current, GameModel game) {
        CardsCollection playersCards = p.getCardsCollect();
        CardsCollection c;
        if (p.getNumCardsHeNeedsToDraw() > 0) {
            for (int k = 0; k < p.getNumCardsHeNeedsToDraw(); k++) {
                game.takingCardFromDeck(p);
            }
            p.setNumCardsHeNeedsToDraw(0);
        } else {
            Random random = new Random();
            c = new CardsCollection();
            for (ICard card : playersCards) {
                if (card.isValidAction(current, game)) {
                    c.add(card);
                    break;
                }
            }
            if (!c.isEmpty()) {
                int x = random.nextInt(c.size());
                c.getCard(x).doAction(game);
                c.remove(c.getCard(x));
                while(game.getNumberOfTimesItsStillMyTurn()>0 && !c.isEmpty()){
                    x = random.nextInt(c.size());
                    c.getCard(x).doAction(game);
                    c.remove(c.getCard(x));
                    game.setNumberOfTimesItsStillMyTurn(game.getNumberOfTimesItsStillMyTurn() - 1);
                }
                if(game.getNumberOfTimesItsStillMyTurn()>0 && c.isEmpty()) {
                    game.takingCardFromDeck(p);
                    game.setNumberOfTimesItsStillMyTurn(0);
                }
            } else {
                game.takingCardFromDeck(p);
            }
        }
    }
}
