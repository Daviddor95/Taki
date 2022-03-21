package com.game.taki;

import java.util.ArrayList;

public class StopCard extends DecoratedCard{

    public StopCard(ICard decoratedCard) {
        super(decoratedCard);
    }


    @Override
    public void doAction(GameModel game) {
        decoratedCard.doAction(game);
        if(game.getNumberOfTimesItsStillMyTurn() ==0){
            addedBehavior(game);
        }

    }

    protected void addedBehavior(GameModel game) {
        game.setIsNextStopped(true);
    }
}
