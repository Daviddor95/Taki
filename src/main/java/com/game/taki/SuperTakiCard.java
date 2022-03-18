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


    private void addedBehaviorForSuperTaki(GameModel game) {
        this.decoratedCard = new TakiCard(new Card("Taki Card", game.getPile().getCurrentTopCard().getColor()));
        PileOfPlayedCards newPile = game.getPile();
        newPile.setCurrentTopCard(decoratedCard);
        game.setPile(newPile);
    }
}

