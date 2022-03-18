package com.game.taki;


public class SuperTakiCard extends TakiCard{

    public SuperTakiCard(ICard decoratedCard) {
        super(decoratedCard);
    }


    @Override
    public void doAction(GameModel game) {
        addedBehaviorForSuperTaki(game);
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

    private void addedBehaviorForSuperTaki(GameModel game) {
        this.decoratedCard = (SuperTakiCard) new TakiCard(new Card(this.decoratedCard.getName(), game.getPile().getCurrentTopCard().getColor()));
        PileOfPlayedCards newPile = game.getPile();
        newPile.setCurrentTopCard(decoratedCard);
        game.setPile(newPile);
    }
}

