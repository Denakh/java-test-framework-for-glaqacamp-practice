package com.github.denakh.deckofcardsapi.models.deckofcards;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Card implements Comparable<Card> {

    private String image;

    private String value;

    private String suit;

    private String code;

    private Images images;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return image.equals(card.image) &&
                value.equals(card.value) &&
                suit.equals(card.suit) &&
                code.equals(card.code) &&
                Objects.equals(images, card.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, value, suit, code, images);
    }

    @Override
    public String toString() {
        return "Card{" +
                "image='" + image + '\'' +
                ", value='" + value + '\'' +
                ", suit='" + suit + '\'' +
                ", code='" + code + '\'' +
                ", images=" + images +
                '}';
    }

    @Override
    public int compareTo(Card card) {
        return this.getCode().compareTo(card.getCode());
    }

    public static String getCardCodes(List<Card> cards) {
        return cards.stream().map(Card::getCode).collect(Collectors.joining(","));
    }
}
