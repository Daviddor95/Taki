package com.game.taki;

import java.util.ArrayList;

public class DrawTwoCard extends DecoratedCard{

    public DrawTwoCard(ICard decoratedCard) {
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
        ArrayList<Player> players = game.getPlayers();

        Player p = game.getNextPlayer();
        p.setNumCardsHeNeedsToDraw(game.getCurrentPlayer().getNumCardsHeNeedsToDraw()+2);
        players.set(game.getNextPlayerIndex(), p);

        Player pCurrent = game.getCurrentPlayer();
        pCurrent.setNumCardsHeNeedsToDraw(0);
        players.set(game.getCurrentPlayerIndex(), pCurrent);
        game.setPlayers(players);
    }
}
