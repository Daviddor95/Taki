package com.game.taki;

public class PlusCard extends DecoratedCard{

    public PlusCard(ICard decoratedCard) {
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
        game.setNumberOfTimesItsStillMyTurn(game.getNumberOfTimesItsStillMyTurn() + 1);
        game.setIsNextPlayer(false);
    }
}
