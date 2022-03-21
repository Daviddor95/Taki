package com.game.taki;

import java.util.List;

public class PileOfPlayedCards {
    private CardsCollection playedCards;
    private ICard currentTopCard;

    public PileOfPlayedCards(){
        this.playedCards = new CardsCollection();
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
            d.setCards(playedCards.getCardsFromCollection());
            d.shuffle();
            this.playedCards = new CardsCollection();
        }
    }

    public List<ICard> getPlayedCards() {
        return playedCards.getCardsFromCollection();
    }

    public void setPlayedCards(List<ICard> playedCards) {
        this.playedCards = new CardsCollection(playedCards);
    }

    public void removeTopCard(){
        this.playedCards.remove(this.playedCards.getCardsFromCollection().get(this.playedCards.size()-1));
        this.setCurrentTopCard(this.playedCards.getCardsFromCollection().get(this.playedCards.size()-1));
    }
}
