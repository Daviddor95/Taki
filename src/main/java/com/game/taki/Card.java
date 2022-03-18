package com.game.taki;


import java.util.ArrayList;

public class Card implements ICard {
    private String name;
    private String color;
    private Boolean isFaceDown;

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Card(String name, String color){
        this.name = name;
        this.color = color;
    }

    public boolean isValidAction(ICard current){
        //return (current.getColor().equals(this.color) || ((current.getName().equals(this.name)) && isNumeric(this.name)));
        if (current.getName().equals("2+")){
            if(this.name.equals("2+")){
                return true;
            } else{
                return false;
            }
        }
        return (current.getColor().equals(this.color) || (current.getName().equals(this.name)));
    }
    @Override
    public void doAction(GameModel game) {
        if(this.isValidAction(game.getPile().getCurrentTopCard())){
            PileOfPlayedCards newPile = game.getPile();
            int currentPlayerIndex = game.getCurrentPlayerIndex();
            ArrayList<Player> players = game.getPlayers();

            newPile.addToPlayedCards(this);
            newPile.setCurrentTopCard(this);

            Player currentPlayer = game.getCurrentPlayer();
            currentPlayer.popPlayedCard(this);
            players.set(currentPlayerIndex, currentPlayer);

            game.setPlayers(players);
            game.setPile(newPile);

            game.setIsNextPlayer(true);
            if(game.getNumberOfTimesItsStillMyTurn()>0){
               game.setNumberOfTimesItsStillMyTurn (game.getNumberOfTimesItsStillMyTurn()-1);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setNum(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
