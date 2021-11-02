package com.github.denakh.deckofcardsapi;

import com.github.denakh.deckofcardsapi.models.deckofcards.DeckInfo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

// See API description on https://deckofcardsapi.com/
public class DeckOfCardsRequester {

    private static final String DECK_OF_CARDS_API_ROOT_URL = "https://deckofcardsapi.com/api/deck/";
    private static final RequestSpecification REQUEST_SPECIFICATION =
            new RequestSpecBuilder().setBaseUri(DECK_OF_CARDS_API_ROOT_URL)
                    .build();

//    static {
//        REQUEST_SPECIFICATION =
//                new RequestSpecBuilder().setBaseUri(DECK_OF_CARDS_API_ROOT_URL)
//                        .build();
//    }

//    public static void configure() {
//        REQUEST_SPECIFICATION =
//                new RequestSpecBuilder().setBaseUri(DECK_OF_CARDS_API_ROOT_URL)
//                        .build();
//    }

    public static DeckInfo shuffleTheCards(int deckCount) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("deck_count", deckCount)
                .get("new/shuffle/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo drawCards(int cardCount, String deckId) {
        // If deckId == "new" a shuffled deck and draw cards from that deck will be created in the same request.
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("count", cardCount)
                .get(deckId + "/draw/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo reShuffleTheCards(int deckId) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .get(deckId + "/shuffle/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo createBrandNewDeck(boolean containsJokers) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("jokers_enabled", containsJokers)
                .get("new/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo createPartialDeck(String cardCodes) {
        // The value, one of A (for an ace), 2, 3, 4, 5, 6, 7, 8, 9, 0 (for a ten), J (jack), Q (queen), or K (king);
        // The suit, one of S (Spades), D (Diamonds), C (Clubs), or H (Hearts).
        // Example: cardCodes = "AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH"
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("cards", cardCodes)
                .get("new/shuffle/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo createPile(String deckId, String pileName, String cardCodes) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("cards", cardCodes)
                .get(deckId + "/pile/" + pileName + "/add/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo shufflePile(String deckId, String pileName) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .get(deckId + "/pile/" + pileName + "/shuffle/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo listCardsInPile(String deckId, String pileName) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .get(deckId + "/pile/" + pileName + "/list/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo drawCardsFromPile(String deckId, String pileName, String cardCodes) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("cards", cardCodes)
                .get(deckId + "/pile/" + pileName + "/draw/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo drawCardsFromPile(String deckId, String pileName, int cardCount) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("count", cardCount)
                .get(deckId + "/pile/" + pileName + "/draw/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }

    public static DeckInfo drawCardsFromPileBottom(String deckId, String pileName, int cardCount) {
        return RestAssured.given(REQUEST_SPECIFICATION)
                .param("count", cardCount)
                .get(deckId + "/pile/" + pileName + "/draw/bottom/")
                .then()
                .statusCode(200)
                .extract()
                .as(DeckInfo.class);
    }
}
