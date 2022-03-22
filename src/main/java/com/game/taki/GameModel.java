package com.game.taki;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class GameModel extends IGameModel{
    private Deck deck;
    private ArrayList<Player> players;
    private PileOfPlayedCards pile;
    private int currentPlayerIndex;
    private boolean isNextPlayer;
    private int numberOfTimesItsStillMyTurn;
    private boolean isNextStopped;
    private ICard choosenCardInThisTurn;
    private int indexOfPerson = 0;
    private boolean wasReversed;
    private ArrayList<String> colors;
    private IController controller;
    private int numberOfPlayers;
    private int handSize;

    public GameModel() {
        this.colors = new ArrayList<>();
        this.colors.add("R");
        this.colors.add("G");
        this.colors.add("B");
        this.colors.add("Y");
        this.deck = new Deck(this.colors);
        this.players = new ArrayList<>();
        this.pile = new PileOfPlayedCards();
        this.isNextPlayer = false;
        this.numberOfTimesItsStillMyTurn = 0;
        this.isNextStopped = false;
        this.wasReversed = false;
    }

    public void setController(IController c) {
        this.controller = c;
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    // Takes an arraylist as a parameter and returns
    // a reversed arraylist
    public void ReverseOrderOfPlayers()
    {
        // Arraylist for storing reversed elements
        ArrayList<Player> revPlayerList = new ArrayList<>();
        for (int i = players.size() - 1; i >= 0; i--) {
            // Append the elements in reverse order
            revPlayerList.add(players.get(i));
        }
        this.setPlayers(revPlayerList);
        this.wasReversed = true;
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

    public ICard getTopPileCard() {
        return this.pile.getCurrentTopCard();
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
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
                c.add(deck.getCards().get(deck.getCardsCollect().getTopIndex()));
                deck.removeTopCardInDeck();
            }
            players.get(i).addToPlayersCollection(c);
        }
    }

    public void takingCardFromDeck(Player p){
        CardsCollection c1 = new CardsCollection();
        c1.add(this.deck.getCardsCollect().getCard(this.deck.getCardsCollect().getTopIndex()));
        p.addToPlayersCollection(c1);
        this.deck.removeTopCardInDeck();
    }

    @Override
    public void initializeGame() {
        this.players.add(new Player(true));
        for (int i = 0; i < this.numberOfPlayers - 1; i++) {
            this.players.add(new Player(false));
        }
        DistributeCards(this.handSize);
        ICard centralCard = getDeck().getCards().get(getDeck().getCardsCollect().getTopIndex());
        this.deck.removeTopCardInDeck();
        this.setChoosenCardInThisTurn(centralCard);
        this.pile.addToPlayedCards(centralCard);
        this.pile.setCurrentTopCard(centralCard);
        this.updateScene();
    }

    public void MakeAMove(Player p) {
        if (!this.isNextStopped) {
            p.getPlayingStrategy().doOperation(p, this.pile.getCurrentTopCard(), this);
        } else {
            this.isNextStopped = false;
        }
        this.controller.updateScene();
    }

    public void setNumberOfPlayers(int players) {
        this.numberOfPlayers = players;
    }

    public void setNumberOfHandCards(int numOfCards) {
        this.handSize = numOfCards;
    }

    @Override
    public void gameRound() {
        Player me = this.players.get(indexOfPerson);
        currentPlayerIndex = indexOfPerson;
        MakeAMove(me);
        System.out.println(this.pile.getCurrentTopCard().getName() + this.pile.getCurrentTopCard().getColor());
        if(numberOfTimesItsStillMyTurn >0){
            setNumberOfTimesItsStillMyTurn(numberOfTimesItsStillMyTurn - 1);
            return;
        }
        int i = 1;
        //if first card is change direction card
        if(wasReversed && indexOfPerson == 0 && players.size() == 3){
            indexOfPerson = 2;
            wasReversed = false;
            i = 0;
        }else if(wasReversed && indexOfPerson == 2 && players.size() == 3){
            indexOfPerson = 0;
            wasReversed = false;
            i = 1;
        }else if(wasReversed && indexOfPerson == 3 && players.size() == 4){
            indexOfPerson = 0;
            wasReversed = false;
            i = 1;
        }else if(wasReversed && indexOfPerson == 0 && players.size() == 4){
            indexOfPerson = 3;
            wasReversed = false;
            i = 0;
        }
        boolean person = false;
        while(!person) {
            this.updateScene();
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Player p = this.players.get(i);
            currentPlayerIndex = i;
            MakeAMove(p);
            if(wasReversed && indexOfPerson == 0 && players.size() == 3){
                indexOfPerson = 2;
            }
            if(wasReversed && indexOfPerson == 2 && players.size() == 3){
                indexOfPerson = 0;
            }
            if(wasReversed && indexOfPerson == 0 && players.size() == 4){
                indexOfPerson = 3;
            }
            if(wasReversed && indexOfPerson == 3 && players.size() == 4){
                indexOfPerson = 0;
            }
            if(wasReversed && players.size() == 3){
                if(i==2){
                    i = 0;
                }else if(i == 0){
                    i = 2;
                }
                wasReversed = false;
            }
            if(wasReversed && players.size() == 4){
                if(i==3){
                    i = 0;
                }else if(i == 0){
                    i = 3;
                }else if(i==1){
                    i = 2;
                }else if(i == 2){
                    i = 1;
                }
                wasReversed = false;
            }
            if(this.numberOfTimesItsStillMyTurn == 0){
                i++;
            }
            if (i>=players.size()){
                i = i - players.size();
            }
            if ((this.numberOfTimesItsStillMyTurn == 0) && (i == indexOfPerson)) {
                if (!isNextStopped) {
                    person = true;
                    this.takeCards();
                    this.updateScene();
                } else {
                    i = 1;
                }
            }
            System.out.println(this.pile.getCurrentTopCard().getName() + this.pile.getCurrentTopCard().getColor());
            this.updateScene();
        }
    }

    @Override
    public boolean isWinning(Player p) {
        return p.getCardsCollect().isEmpty() && (p.getNumCardsHeNeedsToDraw() == 0);
    }

    public int whoWon() {
        for (int i = 0; i < this.getPlayers().size(); i++) {
            if (this.isWinning(this.getPlayers().get(i))) {
                return i;
            }
        }
        return -1;
    }

    public CardsCollection getPlayerHand() {
        return this.getPlayers().get(this.indexOfPerson).getCardsCollect();
    }

    public ICard getChoosenCardInThisTurn() {
        return this.choosenCardInThisTurn;
    }

    public void setChoosenCardInThisTurn(ICard choosenCardInThisTurn) {
        this.choosenCardInThisTurn = choosenCardInThisTurn;
    }

    public void addCardToPile(ICard card){
        this.pile.addToPlayedCards(card);
    }

    public void setCurrentTopCardInPile(ICard card){
        this.pile.setCurrentTopCard(card);
    }

    public void popPlayedCardOfCurrentPlayer(ICard card){
        this.players.get(this.currentPlayerIndex).popPlayedCard(card);
    }

    public void updateScene() {
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.controller.updateScene();
    }

    public int getPersonIndex() {
        return this.indexOfPerson;
    }

    public void takeCards() {
        Player person = this.getPlayers().get(this.indexOfPerson);
        if (person.getNumCardsHeNeedsToDraw() > 0) {
            for (int k = 0; k < person.getNumCardsHeNeedsToDraw(); k++) {
                this.takingCardFromDeck(person);
            }
            person.setNumCardsHeNeedsToDraw(0);
        }
    }
}
