package com.game.taki;

import java.util.ArrayList;

public class DrawTwoCard extends DecoratedCard{

    public DrawTwoCard(ICard decoratedCard) {
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
        //ArrayList<Player> players = game.getPlayers();
        //Player p = game.getNextPlayer();
        //p.setNumCardsHeNeedsToDraw(p.getNumCardsHeNeedsToDraw()+2);
        //players.set(game.getNextPlayerIndex, p);


    }
}
