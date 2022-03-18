package com.game.taki;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CardsCollection implements Collection<Card> {
    private List<Card> cards;
    private int topIndex;

    public CardsCollection() {
        this.cards = new ArrayList<>();
        this.topIndex = 0;
    }

    public CardsCollection(List<Card> cardsList) {
        this.cards = cardsList;
        this.topIndex = cardsList.size();
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.cards.contains(o);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return this.cards.toArray();
    }

    @Override
    public boolean add(Card o) {
        this.cards.add(o);
        this.topIndex++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.cards.remove(o)) {
            this.topIndex--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object card : c) {
            this.add((Card) card);
        }
        return true;
    }

    @Override
    public void clear() {
        this.cards.clear();
        this.topIndex = 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
