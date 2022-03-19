package com.game.taki;

import java.util.ArrayList;

public class GameModel extends IGameModel{
    private Deck deck;
    private ArrayList<Player> players;
    private PileOfPlayedCards pile;
    private int currentPlayerIndex;
    private boolean isNextPlayer;
    private int numberOfTimesItsStillMyTurn;
    private boolean isNextStopped;

    public GameModel(ArrayList<Player> players, ArrayList<String> colorsInGame){
        this.deck = new Deck(colorsInGame);
        this.players = players;
        this.pile = new PileOfPlayedCards();
        this.isNextPlayer = false;
        this.numberOfTimesItsStillMyTurn = 0;
        this.isNextStopped = false;

    }
    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    // Takes an arraylist as a parameter and returns
    // a reversed arraylist
    public void ReverseOrderOfPlayers()
    {
        // Arraylist for storing reversed elements
        ArrayList<Player> revPlayerList = new ArrayList<Player>();
        for (int i = players.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revPlayerList.add(players.get(i));
        }

        this.setPlayers(revPlayerList);
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
            this.currentPlayerIndex = this.getNextPlayerIndex();
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

    public int getNextPlayerIndex(){
        if(this.currentPlayerIndex == (this.players.size() - 1)){
           return 0;
        } else{
           return (this.currentPlayerIndex+ 1);
        }
    }

    public Player getNextPlayer(){
        return players.get(getNextPlayerIndex());
    }

    public int getPreviousPlayerIndex(){
        if(this.currentPlayerIndex == 0){
            return (this.players.size() - 1);
        } else{
            return (this.currentPlayerIndex- 1);
        }
    }

    public Player getPreviousPlayer(){
        return players.get(getPreviousPlayerIndex());
    }

    public boolean isNextStopped() {
        return isNextStopped;
    }

    public void setIsNextStopped(boolean isNextStopped) {
        this.isNextStopped = isNextStopped;
    }

    public void DistributeCards(int initialNumberOfCardsInHand){
        for(int i = 0; i < players.size(); i++){
            CardsCollection c = new CardsCollection();
            for(int j=0; j < initialNumberOfCardsInHand; j++){
                c.add(pile.getCurrentTopCard());
                pile.removeTopCard();
            }
            players.get(i).addToPlayersCollection(c);
        }
    }

    @Override
    public void intializeGame(ArrayList<Player> players, ArrayList<String> colorsInGame, int initialNumberOfCardsInHand) {
        GameModel regularGame = new GameModel(players, colorsInGame);
        DistributeCards(initialNumberOfCardsInHand);
        ICard centralCard = getPile().getCurrentTopCard();
        this.pile.removeTopCard();
    }

    @Override
    public void courseOfGame() {
        boolean ok=true;
        while (ok){
            for(int i = 0; i < players.size(); i++){
                Player p = players.get(i);
                p.play();
                if(isWinning(p)){
                    //Enter winning message
                    ok=false;
                    break;
                }
            }
        }

    }

    @Override
    public boolean isWinning(Player p) {
        return p.getPlayerCards().isEmpty() && (p.getNumCardsHeNeedsToDraw() == 0);
    }
}
