package com.game.taki;

import java.util.List;

public class Player {
    private CardsCollection playerCards;
    private int numCardsHeNeedsToDraw;
    private boolean isRealPerson;
    private AIStrategy playingStrategy;

    public Player(boolean isRealPerson) {
        this.playerCards = new CardsCollection();
        numCardsHeNeedsToDraw = 0;
        this.isRealPerson = isRealPerson;
        if(isRealPerson){
            playingStrategy = new RealPersonStrategy();
        } else{
            playingStrategy = new ComputerSimpleStrategy();
        }
    }

    public void addToPlayersCollection(CardsCollection c){
        playerCards.addAll(c);
    }
    public void popPlayedCard(ICard card){
        for (ICard c : this.playerCards) {
            if (c.getName().equals(card.getName()) && c.getColor().equals(card.getColor())) {
                this.playerCards.remove(c);
                return;
            }
        }
    }

    public CardsCollection getCardsCollect() {
        return playerCards;
    }

    public void setPlayerCards(List<ICard> playerCards) {
        this.playerCards = new CardsCollection(playerCards);
    }

    public int getNumCardsHeNeedsToDraw() {
        return numCardsHeNeedsToDraw;
    }

    public void setNumCardsHeNeedsToDraw(int numCardsHeNeedsToDraw) {
        this.numCardsHeNeedsToDraw = numCardsHeNeedsToDraw;
    }

    public AIStrategy getPlayingStrategy() {
        return playingStrategy;
    }

    public boolean isRealPerson() {
        return isRealPerson;
    }

    public void setRealPerson(boolean realPerson) {
        isRealPerson = realPerson;
    }
}
