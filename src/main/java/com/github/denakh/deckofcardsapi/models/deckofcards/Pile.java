package com.github.denakh.deckofcardsapi.models.deckofcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pile implements Comparable<Pile> {

    private List<Card> cards = new ArrayList<>();

    private Integer remaining;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pile pile = (Pile) o;
        return cards.equals(pile.cards) &&
                remaining.equals(pile.remaining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, remaining);
    }

    @Override
    public String toString() {
        return "Pile{" +
                "cards=" + cards +
                ", remaining=" + remaining +
                '}';
    }

    @Override
    public int compareTo(Pile pile) {
        return this.getCards().toString().compareTo(pile.getCards().toString());
    }
}
