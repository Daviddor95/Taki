package com.game.taki;

public class Player {
    private Card[] playerCards;
    public Player(Card[] playerCards){
        this.playerCards = playerCards;
    }
    public void play(){

    }

    public Card[] getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(Card[] playerCards) {
        this.playerCards = playerCards;
    }
}
