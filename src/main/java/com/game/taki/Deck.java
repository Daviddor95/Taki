package com.game.taki;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    private CardsCollection cards;
    private ArrayList<String> ColorsInGame;
    public Deck(ArrayList<String> ColorsInGame){
        this.ColorsInGame = ColorsInGame;
        this.cards = new CardsCollection();

        for (int i = 0; i < ColorsInGame.size(); i++) {
            for(int j =0; j < 2;j++){
                for (int num = 1; num < 10; num++) {
                    cards.add(new Card(String.valueOf(num), ColorsInGame.get(i)));
                }
                cards.add(new StopCard(new Card("Stop Card", ColorsInGame.get(i))));
                cards.add(new ChangeDirectionCard(new Card("Change-Direction Card", ColorsInGame.get(i))));
                cards.add(new PlusCard(new Card("Plus Card", ColorsInGame.get(i))));
                cards.add(new TakiCard(new Card("Taki Card", ColorsInGame.get(i))));
                cards.add(new DrawTwoCard(new Card("Draw-Two Card", ColorsInGame.get(i))));
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
        List<ICard> temp = this.cards.getCardsFromCollection();
        Collections.shuffle(temp);
        this.cards.setCardsForCollection(temp);
    }

    public List<ICard> getCards() {
        return this.cards.getCardsFromCollection();
    }

    public void setCards(List<ICard> cards) {
        this.cards.setCardsForCollection(cards);
    }

    public ArrayList<String> getColorsInGame() {
        return ColorsInGame;
    }

    public void setColorsInGame(ArrayList<String> colorsInGame) {
        ColorsInGame = colorsInGame;
    }
}
