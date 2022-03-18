package com.game.taki;

import java.util.ArrayList;

public class PileOfPlayedCards {
    private ArrayList<ICard> playedCards;
    private ICard currentTopCard;

    public PileOfPlayedCards(){
        this.playedCards = new ArrayList<ICard>();
        currentTopCard = null;
    }


    public ICard getCurrentTopCard() {
        return currentTopCard;
    }

    public void addToPlayedCards(ICard newTopCard){
        this.playedCards.add(newTopCard);
    }
    public void setCurrentTopCard(ICard newTopCard) {
        this.currentTopCard = newTopCard;
    }

    public void fillEmptyDeck(Deck d){
        if(d.getCards().isEmpty()){
            d.setCards(playedCards);
            d.shuffle();
        }
    }

    public ArrayList<ICard> getPlayedCards() {
        return playedCards;
    }

    public void setPlayedCards(ArrayList<ICard> playedCards) {
        this.playedCards = playedCards;
    }
}
