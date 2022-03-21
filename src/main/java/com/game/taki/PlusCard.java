package com.game.taki;

public class PlusCard extends DecoratedCard{

    public PlusCard(ICard decoratedCard) {
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
        game.setNumberOfTimesItsStillMyTurn(game.getNumberOfTimesItsStillMyTurn() + 1);
        game.setIsNextPlayer(false);
    }
}
