package com.game.taki;

public abstract class DecoratedCard implements ICard{
    protected ICard decoratedCard;

    public DecoratedCard(ICard decoratedCard){
        this.decoratedCard = decoratedCard;
    }


    public void doAction(GameModel game) {
        this.decoratedCard.doAction(game);
    }

    @Override
    public boolean isValidAction(ICard current, GameModel g) {
        return this.decoratedCard.isValidAction(current, g);
    }

    @Override
    public String getName() {
        return this.decoratedCard.getName();
    }

    @Override
    public String getColor() {
        return this.decoratedCard.getColor();
    }
}
