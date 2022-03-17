package com.game.taki;

public class SettingOfGame {
    private int numOfColors;
    private int numOfCardsInHand;
    public SettingOfGame(int numOfColors, int numOfCardsInHand){
        this.numOfCardsInHand = numOfCardsInHand;
        this.numOfColors = numOfColors;
    }
    public void save(){

    }

    public int getNumOfColors() {
        return numOfColors;
    }

    public void setNumOfColors(int numOfColors) {
        this.numOfColors = numOfColors;
    }

    public int getNumOfCardsInHand() {
        return numOfCardsInHand;
    }

    public void setNumOfCardsInHand(int numOfCardsInHand) {
        this.numOfCardsInHand = numOfCardsInHand;
    }
}
