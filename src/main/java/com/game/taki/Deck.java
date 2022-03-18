package com.game.taki;

import java.util.ArrayList;

public class Deck {
    private ArrayList<ICard> cards;
    private ArrayList<String> ColorsInGame;
    public Deck(ArrayList<String> ColorsInGame){
        this.ColorsInGame = ColorsInGame;
        this.cards = new ArrayList<ICard>();
        for (int i = 0; i < ColorsInGame.size(); i++) {
            for (int num = 1; num < 10; num++) {
                cards.add(new Card(String.valueOf(num), ColorsInGame.get(i)));
            }
        }

       // CREATE AND ADD SPECIAL CARDS
    }

    public void shuffle() {


    }

    public ArrayList<ICard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<ICard> cards) {
        this.cards = cards;
    }

    public ArrayList<String> getColorsInGame() {
        return ColorsInGame;
    }

    public void setColorsInGame(ArrayList<String> colorsInGame) {
        ColorsInGame = colorsInGame;
    }
}
