package com.github.denakh.deckofcardsapi;

import com.github.denakh.deckofcardsapi.models.deckofcards.Card;
import com.github.denakh.deckofcardsapi.models.deckofcards.DeckInfo;
import com.github.denakh.deckofcardsapi.models.deckofcards.Pile;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DeckOfCardsTest {

    @Test
    public void pileCardsShouldCorrespondToUsedForPilesBuilding() {
        //given: shuffled deck
        DeckInfo shuffledDeck = DeckOfCardsRequester.shuffleTheCards(1);

        //when: drawn 2*3 = 6 cards (for 2 piles)
        DeckInfo drawnCards = DeckOfCardsRequester.drawCards(6, shuffledDeck.getDeckId());

        //and: create 2 piles (3 cards in each) from the drawn cards
        List<Card> firstPileCards = drawnCards.getDrawnCards().subList(0, 3);
        List<Card> secondPileCards = drawnCards.getDrawnCards().subList(3, 6);
        String firstPileCardCodes = firstPileCards.stream().map(Card::getCode).collect(Collectors.joining(","));
        String secondPileCardCodes = secondPileCards.stream().map(Card::getCode).collect(Collectors.joining(","));
        String pile1Name = "Pile1";
        String pile2Name = "Pile2";
        DeckOfCardsRequester.createPile(shuffledDeck.getDeckId(), pile1Name, firstPileCardCodes);
        DeckOfCardsRequester.createPile(shuffledDeck.getDeckId(), pile2Name, secondPileCardCodes);

        //then: listing cards in piles the same like used for their building
        DeckInfo pilesInfoWithPile1Cards = DeckOfCardsRequester.listCardsInPile(shuffledDeck.getDeckId(), pile1Name);
        DeckInfo pilesInfoWithPile2Cards = DeckOfCardsRequester.listCardsInPile(shuffledDeck.getDeckId(), pile2Name);
        Assert.assertEquals(pilesInfoWithPile1Cards.getPiles().getOrDefault(pile1Name, new Pile()).getCards().stream().sorted().collect(Collectors.toList()),
                firstPileCards.stream().sorted().collect(Collectors.toList()));
        Assert.assertEquals(pilesInfoWithPile2Cards.getPiles().getOrDefault(pile2Name, new Pile()).getCards().stream().sorted().collect(Collectors.toList()),
                secondPileCards.stream().sorted().collect(Collectors.toList()));
    }
}
