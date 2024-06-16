package PokerGame;

public class Card {

    private final String suit;
    private final int value;

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

} // end of Hand Class