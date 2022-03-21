package com.game.taki;

import java.util.ArrayList;
import java.util.List;

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
    private int direction = 1;
    private int indexOfPerson = 0;
    private boolean wasReversed;
    private ArrayList<String> colors;
    private IController controller;
    private boolean isWon;
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
        this.isWon = false;

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
        ArrayList<Player> revPlayerList = new ArrayList<Player>();
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
                //c.add(pile.getCurrentTopCard());
                //pile.removeTopCard();
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
    public void intializeGame() {
        // GameModel regularGame = new GameModel(players, colorsInGame);
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
        this.controller.updateScene();
    }

    public void MakeAMove(Player p ){
        if(!this.isNextStopped){
            p.getPlayingStrategy().doOperation(p, this.pile.getCurrentTopCard(), this);
            if(isWinning(p)){
                this.isWon = true;
                //Enter winning message
                return;
            }
        }else{
            this.isNextStopped = false;
        }
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
        MakeAMove(me);
        this.controller.updateScene();
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
            this.controller.updateScene();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Player p = this.players.get(i);
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

            if ((this.numberOfTimesItsStillMyTurn == 0) && (i == indexOfPerson )) {
                person = true;
            }
            this.controller.updateScene();
        }
    }

    @Override
    public boolean isWinning(Player p) {
        return p.getPlayerCards().isEmpty() && (p.getNumCardsHeNeedsToDraw() == 0);
    }

    public boolean isWon() {
        return this.isWon;
    }

    public List<ICard> getPlayerHand() {
        return this.getPlayers().get(this.indexOfPerson).getPlayerCards();
    }

    public ICard getChoosenCardInThisTurn() {
        return this.choosenCardInThisTurn;
    }

    public void setChoosenCardInThisTurn(ICard choosenCardInThisTurn) {
        this.choosenCardInThisTurn = choosenCardInThisTurn;
    }
}

//        while (!person) {
//            p = p.
//            if(isWinning(p)){
//                    //Enter winning message
//                    ok=false;
//                    break;
//            }
//            person =true;
//        }
//        boolean ok=true;
//        while (ok){
//            for (int i = 0; i < players.size(); i++){
//                Player p = players.get(i);
//                while
//                if (computer)
//                    p.getPlayingStrategy().doOperation(p, this.pile.getCurrentTopCard(), this); // this.pile.getCurrentTopCard()
//                if(isWinning(p)){
//                    //Enter winning message
//                    ok=false;
//                    break;
//                }
//            }
//        }

