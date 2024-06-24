package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hand implements Iterable<Card> {

    ArrayList<Card> cardArrayHand;
    private static final int MAX_CARDS = 5;
    private String value;
    private int rankingValue;
    boolean isPaired = false;


    /**
     * Constructor for Hand
     */
    public Hand() {
        cardArrayHand = new ArrayList<>();
        value = null;
        rankingValue = -1;
    }


    /**
     * updates the hand's value
     */
    public void updateHandValue(String value, int rankingValue) {
        this.value = value;
        this.rankingValue = rankingValue;
    }

    public void updateHandValue(boolean isPaired) {
        this.isPaired = true;
    }

    /**
     * returns the amount of cards in the Hand
     * @return the amount of cards in the Hand
     */
    public int getHandLength() {
        return cardArrayHand.size();
    }


    /**
     * returns the value of the hand
     * @return the value of the hand
     */
    public String getHandValue() {
        return this.value;
    }

    /**
     * returns the ranking value of the hand as it stands in the pokerHandValues array
     * @return the ranking value of the hand as it stands in the pokerHandValues array
     */
    public int getRankingValue() {
        return this.rankingValue;
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
     * Method to get all cards in the hand
     * @return List of all the cards in the hand
     */
    public List<Card> getCards() {
        return cardArrayHand;

    }

    /**
     * Sorts the hand based on the value of cards.
     */
    public void sortHand() {
        Collections.sort(cardArrayHand);
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

    @Override
    public Iterator<Card> iterator() {
        return null;
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
