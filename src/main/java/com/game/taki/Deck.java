package com.game.taki;
import java.util.Collections;
import java.util.ArrayList;

public class Deck {
    private ArrayList<ICard> cards;
    private ArrayList<String> ColorsInGame;
    public Deck(ArrayList<String> ColorsInGame){
        this.ColorsInGame = ColorsInGame;
        this.cards = new ArrayList<ICard>();

        for (int i = 0; i < ColorsInGame.size(); i++) {
            for(int j =0; j < 2;j++){
                for (int num = 1; num < 10; num++) {
                    cards.add(new Card(String.valueOf(num), ColorsInGame.get(i)));
                }
                cards.add(new StopCard(new Card("Stop Card", ColorsInGame.get(i))));
                cards.add(new ChangeDirectionCard(new Card("Change-Direction Card", ColorsInGame.get(i))));
                cards.add(new PlusCard(new Card("Plus Card", ColorsInGame.get(i))));
                cards.add(new TakiCard(new Card("Taki Card", ColorsInGame.get(i))));
            }
        }
        cards.add(new SuperTakiCard(new Card("Super-Taki Card", "Colorful")));
        cards.add(new SuperTakiCard(new Card("Super-Taki Card", "Colorful")));

        cards.add(new ChangeColorCard(new Card("Change-Color Card", "Colorful")));
        cards.add(new ChangeColorCard(new Card("Change-Color Card", "Colorful")));
        cards.add(new ChangeColorCard(new Card("Change-Color Card", "Colorful")));
        cards.add(new ChangeColorCard(new Card("Change-Color Card", "Colorful")));
        this.shuffle();
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
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
