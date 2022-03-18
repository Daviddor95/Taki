package com.game.taki;

import java.util.ArrayList;

public class Player {
    private ArrayList<ICard> playerCards;
    private int numCardsHeNeedsToDraw;
    public Player(ArrayList<ICard> playerCards){
        this.playerCards = playerCards;
        numCardsHeNeedsToDraw = 0;
    }
    public void play(){

    }
    public void popPlayedCard(ICard card){
        ArrayList<ICard> newPlayerCards = this.playerCards;
        newPlayerCards.remove(card);
        setPlayerCards(newPlayerCards);
    }

    public ArrayList<ICard> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList<ICard> playerCards) {
        this.playerCards = playerCards;
    }

    public int getNumCardsHeNeedsToDraw() {
        return numCardsHeNeedsToDraw;
    }

    public void setNumCardsHeNeedsToDraw(int numCardsHeNeedsToDraw) {
        this.numCardsHeNeedsToDraw = numCardsHeNeedsToDraw;
    }
}
