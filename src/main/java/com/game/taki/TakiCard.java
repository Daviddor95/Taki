package com.game.taki;

import java.util.ArrayList;

public class TakiCard extends DecoratedCard{

    public TakiCard(ICard decoratedCard) {
        super(decoratedCard);
    }


    @Override
    public void doAction(GameModel game) {
        decoratedCard.doAction(game);
        addedBehavior(game);

    }

    @Override
    public boolean isValidAction(ICard current) {
        return this.decoratedCard.isValidAction(current);
    }

    @Override
    public String getName() {
        return this.decoratedCard.getName();
    }

    @Override
    public String getColor() {
        return this.decoratedCard.getColor();
    }

    protected void addedBehavior(GameModel game) {
        Player currentPlayer = game.getCurrentPlayer();
        ArrayList<ICard> playerCards = currentPlayer.getPlayerCards();
        for(int i = 0; i< playerCards.size(); i++){
            if(playerCards.get(i).getColor().equals(this.decoratedCard.getColor())){
                game.setIsNextPlayer(false);
                game.setNumberOfTimesItsStillMyTurn(game.getNumberOfTimesItsStillMyTurn() + 1);
            }
        }
    }
}
