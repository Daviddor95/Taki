package com.game.taki;

import java.util.Iterator;
import java.util.List;

public class CardsIterator implements Iterator<ICard> {
    private List<ICard> cards;
    private int position;

    public CardsIterator(List<ICard> cardsList) {
        this.cards = cardsList;
    }

    @Override
    public boolean hasNext() {
        return this.position < this.cards.size() && this.cards.get(this.position) != null;
    }

    @Override
    public ICard next() {
        return this.cards.get(this.position++);
    }

    @Override
    public void remove() {
        if (this.position <= 0) {
            throw new IllegalStateException("Illegal iterator position");
        }
        if (this.cards.get(this.position - 1) != null) {
            this.cards.remove(this.position - 1);
        }
    }
}
