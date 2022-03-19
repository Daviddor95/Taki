package com.game.taki;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CardsCollection implements Collection<ICard> {
    private List<ICard> cards;
    private int topIndex;

    public CardsCollection() {
        this.cards = new ArrayList<>();
        this.topIndex = 0;
    }

    public CardsCollection(List<ICard> cardsList) {
        this.cards = cardsList;
        this.topIndex = cardsList.size();
    }

    public List<ICard> getCardsFromCollection(){
        return this.cards;
    }

    public void setCardsForCollection(List<ICard> cards){
        this.cards = cards;
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
    public Iterator<ICard> iterator() {
        return new CardsIterator(this.cards);
    }

    @Override
    public Object[] toArray() {
        return this.cards.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= this.size()) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), this.size());
        }
        return a;
    }

    @Override
    public boolean add(ICard o) {
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
            this.add((ICard) card);
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
        List<ICard> inputCollection = new ArrayList<>();
        for (Object card : c) {
            inputCollection.add((ICard) card);
        }
        if (this.cards.retainAll(inputCollection)) {
            this.topIndex = this.size();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object card : c) {
            this.remove(card);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object card : c) {
            if (!this.contains(card)) {
                return false;
            }
        }
        return true;
    }
}
