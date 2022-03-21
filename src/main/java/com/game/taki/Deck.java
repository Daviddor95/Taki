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
                cards.add(new StopCard(new Card("Stop", ColorsInGame.get(i))));
                cards.add(new ChangeDirectionCard(new Card("ChangeDirection", ColorsInGame.get(i))));
                cards.add(new PlusCard(new Card("Plus", ColorsInGame.get(i))));
                cards.add(new TakiCard(new Card("Taki", ColorsInGame.get(i))));
                cards.add(new DrawTwoCard(new Card("2+", ColorsInGame.get(i))));
            }
        }
        cards.add(new SuperTakiCard(new Card("SuperTaki", "C")));
        cards.add(new SuperTakiCard(new Card("SuperTaki", "C")));

        cards.add(new ChangeColorCard(new Card("ChangeColor", "C")));
        cards.add(new ChangeColorCard(new Card("ChangeColor", "C")));
        cards.add(new ChangeColorCard(new Card("ChangeColor", "C")));
        cards.add(new ChangeColorCard(new Card("ChangeColor", "C")));
        this.shuffle();
    }

    public void shuffle() {
        List<ICard> temp = this.cards.getCardsFromCollection();
        Collections.shuffle(temp);
        this.cards = new CardsCollection(temp);
    }

    public List<ICard> getCards() {
        return this.cards.getCardsFromCollection();
    }
    public CardsCollection getCardsCollect() {
        return this.cards;
    }

    public void setCards(List<ICard> cards) {
        this.cards = new CardsCollection(cards);
    }

    public ArrayList<String> getColorsInGame() {
        return ColorsInGame;
    }

    public void setColorsInGame(ArrayList<String> colorsInGame) {
        ColorsInGame = colorsInGame;
    }

    public void removeTopCardInDeck(){
        cards.remove(cards.getCardsFromCollection().get(cards.getTopIndex()));
    }
}
