package com.github.denakh.deckofcardsapi.models.deckofcards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class DeckInfo implements Comparable<DeckInfo> {

    @JsonProperty("success")
    private Boolean operationSuccess;

    @JsonProperty("deck_id")
    private String deckId;

    @JsonProperty("shuffled")
    private Boolean isDeckShuffled;

    @JsonProperty("remaining")
    private Integer remainingDeckCards;

    @JsonProperty("cards")
    private List<Card> drawnCards = new ArrayList<>();

    private Map<String, Pile> piles = new HashMap<>();

    public Boolean getOperationSuccess() {
        return operationSuccess;
    }

    public void setOperationSuccess(Boolean operationSuccess) {
        this.operationSuccess = operationSuccess;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public Boolean getDeckShuffled() {
        return isDeckShuffled;
    }

    public void setDeckShuffled(Boolean deckShuffled) {
        isDeckShuffled = deckShuffled;
    }

    public Integer getRemainingDeckCards() {
        return remainingDeckCards;
    }

    public void setRemainingDeckCards(Integer remainingDeckCards) {
        this.remainingDeckCards = remainingDeckCards;
    }

    public List<Card> getDrawnCards() {
        return drawnCards;
    }

    public void setDrawnCards(List<Card> drawnCards) {
        this.drawnCards = drawnCards;
    }

    public Map<String, Pile> getPiles() {
        return piles;
    }

    public void setPiles(Map<String, Pile> piles) {
        this.piles = piles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckInfo deckInfo = (DeckInfo) o;
        return operationSuccess.equals(deckInfo.operationSuccess) &&
                deckId.equals(deckInfo.deckId) &&
                Objects.equals(isDeckShuffled, deckInfo.isDeckShuffled) &&
                remainingDeckCards.equals(deckInfo.remainingDeckCards) &&
                Objects.equals(drawnCards, deckInfo.drawnCards) &&
                Objects.equals(piles, deckInfo.piles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationSuccess, deckId, isDeckShuffled, remainingDeckCards, drawnCards, piles);
    }

    @Override
    public String toString() {
        return "DeckInfo{" +
                "operationSuccess=" + operationSuccess +
                ", deckId='" + deckId + '\'' +
                ", isDeckShuffled=" + isDeckShuffled +
                ", remainingDeckCards=" + remainingDeckCards +
                ", drawnCards=" + drawnCards +
                ", piles=" + piles +
                '}';
    }

    @Override
    public int compareTo(DeckInfo card) {
        return this.getDeckId().compareTo(card.deckId);
    }
}
