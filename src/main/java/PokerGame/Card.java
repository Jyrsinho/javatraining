package PokerGame;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final String suit;
    private final int value;


    /**
     * Constructor for Card
     * @param suit of a card
     * @param value of a card
     */
    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }


    /**
     *
     * @return suit of the card
     */
    public String getSuit() {
        return this.suit;
    }


    /**
     *
     * @return value of the card
     */
    public int getValue() {
        return this.value;
    }


    /**
     * Compare cards by value
     * @param other the object to be compared.
     * @return negative integer if this is less than other, zero if values are equal, and positive integer
     * if other is greater than this.
     */
    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.value, other.value);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Card card = (Card) other;
        return value == card.value && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    @Override
    public String toString() {
        return value + "of" + suit;
    }
} // end of Hand Class