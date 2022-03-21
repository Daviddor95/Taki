package com.game.taki;

public class TakiCard extends DecoratedCard{

    public TakiCard(ICard decoratedCard) {
        super(decoratedCard);
    }

    @Override
    public void doAction(GameModel game) {
        decoratedCard.doAction(game);
        if(game.getNumberOfTimesItsStillMyTurn() == 0 || game.getNumberOfTimesItsStillMyTurn() == 1){
            addedBehavior(game);
        }
    }

    protected void addedBehavior(GameModel game) {
        Player currentPlayer = game.getCurrentPlayer();
        CardsCollection playerCards = currentPlayer.getCardsCollect();
        for(ICard c: playerCards) {
            if(c.getColor().equals(this.decoratedCard.getColor())) {
                game.setIsNextPlayer(false);
                game.setNumberOfTimesItsStillMyTurn(game.getNumberOfTimesItsStillMyTurn() + 1);
            }
        }
    }
}
