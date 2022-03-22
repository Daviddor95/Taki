package com.game.taki;


import java.util.ArrayList;

public class Card implements ICard {
    private String name;
    private String color;
    //private Boolean isFaceDown;

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

    public boolean isValidAction(ICard current, GameModel g){
        //return (current.getColor().equals(this.color) || ((current.getName().equals(this.name)) && isNumeric(this.name)));
        if (current.getName().startsWith("2+") && (g.getCurrentPlayer().getNumCardsHeNeedsToDraw()>0)){
            if(this.name.startsWith("2+")){
                return true;
            } else{
                return false;
            }
        }
        return (current.getColor().equals(this.color) || (current.getName().equals(this.name)));
    }
    @Override
    public void doAction(GameModel game) {
        if(this.isValidAction(game.getPile().getCurrentTopCard(), game)){
            game.addCardToPile(this);
            game.setCurrentTopCardInPile(this);
            game.popPlayedCardOfCurrentPlayer(this);
            game.setIsNextPlayer(true);
            game.updateScene();
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
