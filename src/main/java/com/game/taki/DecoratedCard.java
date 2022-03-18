package com.game.taki;

public abstract class DecoratedCard implements ICard{
    protected ICard decoratedCard;

    public DecoratedCard(ICard decoratedCard){
        this.decoratedCard = decoratedCard;
    }


    public void doAction(GameModel game) {
        this.decoratedCard.doAction(game);
    }
}
