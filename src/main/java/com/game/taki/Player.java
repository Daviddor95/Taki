package com.game.taki;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private CardsCollection playerCards;
    private int numCardsHeNeedsToDraw;
    private boolean isRealPerson;
    private AIStrategy playingStrategy;
    // private ICard choosenCard;

    public Player(boolean isRealPerson) {  // CardsCollection playerCards,
        this.playerCards = new CardsCollection();
        numCardsHeNeedsToDraw = 0;
        this.isRealPerson = isRealPerson;
        if(isRealPerson){
            playingStrategy = new RealPersonStrategy();
        } else{
            playingStrategy = new ComputerSimpleStrategy();
        }
    }
    public void play(){  // ICard topPileCard
//        if (this.choosenCard.isValidAction(topPileCard)) {
//            this.popPlayedCard(this.choosenCard);
//        }

    }
    public void addToPlayersCollection(CardsCollection c){
        playerCards.addAll(c);
    }
    public void popPlayedCard(ICard card){
        System.out.println(this.playerCards.contains(card));
        playerCards.remove(card);
    }

//    public void chooseCard(ICard c) {
//        this.choosenCard = c;
//    }
    public List<ICard> getPlayerCards() {
        return playerCards.getCardsFromCollection();
    }

    public CardsCollection getCardsCollect() {
        return playerCards;
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
