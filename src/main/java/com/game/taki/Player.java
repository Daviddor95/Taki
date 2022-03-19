package com.game.taki;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private CardsCollection playerCards;
    private int numCardsHeNeedsToDraw;
    public Player(CardsCollection playerCards){
        this.playerCards = playerCards;
        numCardsHeNeedsToDraw = 0;
    }
    public void play(){

    }
    public void addToPlayersCollection(CardsCollection c){
        playerCards.addAll(c);
    }
    public void popPlayedCard(ICard card){
        playerCards.remove(card);
    }

    public List<ICard> getPlayerCards() {
        return playerCards.getCardsFromCollection();
    }

    public void setPlayerCards(List<ICard> playerCards) {
        this.playerCards.setCardsForCollection(playerCards);
    }

    public int getNumCardsHeNeedsToDraw() {
        return numCardsHeNeedsToDraw;
    }

    public void setNumCardsHeNeedsToDraw(int numCardsHeNeedsToDraw) {
        this.numCardsHeNeedsToDraw = numCardsHeNeedsToDraw;
    }
}
