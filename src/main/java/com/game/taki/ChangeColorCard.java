package com.game.taki;

public class ChangeColorCard extends DecoratedCard {
    public ChangeColorCard(ICard decoratedCard) {
        super(decoratedCard);
    }

    @Override
    public void doAction(GameModel game) {
        decoratedCard.doAction(game);
        addedBehavior(game);

    }

    protected void addedBehavior(GameModel game) {
        //game.setCurrentColor();
    }
}
