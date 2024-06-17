package PokerGame;

import java.util.ArrayList;

public class Hand {

    ArrayList<Card> cardArrayHand = new ArrayList<>();
    private static final int MAX_CARDS = 5;


    /**
     * Constructor for Hand
     */
    public Hand() {

    }


    /**
     * returns the amount of cards in the Hand
     * @return the amount of cards in the Hand
     */
    public int getHandLength() {
        return cardArrayHand.size();
    }


    /**
     * Adds a card to a Hand
     */
    public void addCardToHand(Card card) throws TooManyElementsException {
        if (getHandLength() >= MAX_CARDS) {
            throw new TooManyElementsException("Cannot add more than "+ MAX_CARDS + " cards to the hand.");
        }
        cardArrayHand.add(card);
    }

    /**
     * Test program for the Hand-class
     * @param args none
     */
    public static void main (String []args) {

    }
}
