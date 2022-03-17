package com.game.taki;

public class GameModel {
    private Deck deck;
    private Player[] players;
    public GameModel(Deck deck, Player[] players){
        this.deck = deck;
        this.players = players;
    }


    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}
