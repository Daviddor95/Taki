package com.game.taki;

import java.util.ArrayList;

public class ChangeDirectionCard extends DecoratedCard{

    public ChangeDirectionCard(ICard decoratedCard) {
        super(decoratedCard);
    }

    @Override
    public void doAction(GameModel game) {
        decoratedCard.doAction(game);
        addedBehavior(game);

    }

    protected void addedBehavior(GameModel game) {
        game.ReverseOrderOfPlayers();
    }
}
