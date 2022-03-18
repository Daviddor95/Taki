package com.game.taki;

import java.util.ArrayList;

public class GameModel {
    private Deck deck;
    private ArrayList<Player> players;
    private PileOfPlayedCards pile;
    private int currentPlayerIndex;
    private boolean isNextPlayer;
    private int numberOfTimesItsStillMyTurn;

    public GameModel(ArrayList<Player> players, ArrayList<String> colorsInGame){
        this.deck = new Deck(colorsInGame);
        this.players = players;
        this.pile = new PileOfPlayedCards();
        this.isNextPlayer = false;
        this.numberOfTimesItsStillMyTurn = 0;

    }
    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    public void ReverseOrderOfPlayers() {

    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public PileOfPlayedCards getPile() {
        return pile;
    }

    public void setPile(PileOfPlayedCards pile) {
        this.pile = pile;
    }



    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public void changeCurrentPlayerToTheNextOne() {
        if(isNextPlayer){
            if(this.currentPlayerIndex == (this.players.size() - 1)){
                this.currentPlayerIndex = 0;
            } else{
                this.currentPlayerIndex++;
            }
        }
    }

    public boolean isNextPlayer() {
        return isNextPlayer;
    }

    public void setIsNextPlayer(boolean nextPlayer) {
        isNextPlayer = nextPlayer;
    }

    public int getNumberOfTimesItsStillMyTurn() {
        return numberOfTimesItsStillMyTurn;
    }

    public void setNumberOfTimesItsStillMyTurn(int numberOfTimesItsStillMyTurn) {
        this.numberOfTimesItsStillMyTurn = numberOfTimesItsStillMyTurn;
    }
}
