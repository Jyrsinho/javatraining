package PokerGame;

import java.util.ArrayList;

public class Hand {

    ArrayList<Card> cardArrayHand;
    private static final int MAX_CARDS = 5;


    /**
     * Constructor for Hand
     */
    public Hand() {
        cardArrayHand = new ArrayList<>();
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
     * Overriding the toString() method
     * @return String description of the Hand
     */
    @Override
    public String toString() {
        String hand = "Hand contains: ";
        for (int i = 0; i <cardArrayHand.size() ; i++) {
            hand += cardArrayHand.get(i).getSuit();
            hand += cardArrayHand.get(i).getValue();
            hand += ", ";
        }
        return hand;
    }

    /**
     * Test program for the Hand-class
     * @param args none
     */
    public static void main (String []args) throws TooManyElementsException {

        Hand hand = new Hand();
        Card fiveofHearts = new Card("hearts", 5);
        hand.addCardToHand(fiveofHearts);
        Card sixOfSpades = new Card("spades", 6);
        hand.addCardToHand(sixOfSpades);

        System.out.println(hand);

    }
}
