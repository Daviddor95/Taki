package com.game.taki;

public class RealPersonStrategy implements AIStrategy {
    @Override
    public void doOperation(Player p, ICard current, GameModel game) {
        if (p.getNumCardsHeNeedsToDraw() > 0) {
            for (int k = 0; k < p.getNumCardsHeNeedsToDraw(); k++) {
                game.takingCardFromDeck(p);
            }
            p.setNumCardsHeNeedsToDraw(0);
        } else {
            ICard card = game.getChoosenCardInThisTurn();
            if(card.isValidAction(current, game)) {
                card.doAction(game);
            }
            else {
                game.takingCardFromDeck(p);
            }
        }
    }
}
