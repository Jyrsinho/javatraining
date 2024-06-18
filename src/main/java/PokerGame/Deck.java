package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that contains all the cards in the deck.
 * Knows all the cards in the deck.
 */
public class Deck {

    private ArrayList<Card> cards;
    private int cardsInDeck = 52;
    private final String [] suits = {"clubs", "diamonds", "hearts", "spades"};


    /**
     * Constructor for the Deck class
     */
    public Deck() {
        cards = new ArrayList<>();
    }


    /**
     * Initializes Deck. Fills the deck with 52 cards. 4 different suits. 13 different values.
     */
    public void initialize() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 2; j <= 14; j++) {
                Card card = new Card(suits[i], j);
                cards.add(card);
            }
        }
    }


    /**
     * Adds card to the Deck
     * @param card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }


    /**
     * Method to get all cards in the deck
     * @return List of all the cards in the deck
     */
    public List<Card> getCards() {
        return cards;

    }

    /**
     * Sorts the deck based on card values
      */
    public void sortDeck() {
        Collections.sort(cards);
    }


    /**
     * returns the amount of cards in the deck
     * @return the length of deck
     */
    public int getLength() {
        return cards.size();
    }


    public void shuffle() {

    }


    /**
     * return the amount cards in the deck that are of given suit
     * @param suit that is looked for
     * @return amount of cards in the deck that are of given suit
     */
    public int suitCounter(String suit) {
        if (cards.size() <= 0) return 0;

        int amountOfCardsInDeckOfSuit = 0;

        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getSuit().equals(suit)) {
                amountOfCardsInDeckOfSuit ++;
            }
        }
        return amountOfCardsInDeckOfSuit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Deck contains: ");
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i));
        }
        return sb.toString();
    }

    /**
     * Test program for the Deck class
     * @param args
     */
    public static void main (String[] args) {

        Deck deck = new Deck();
        deck.initialize();
        deck.getCards();
        System.out.println(deck);
        deck.sortDeck();
        System.out.println(deck);
    }


    }

