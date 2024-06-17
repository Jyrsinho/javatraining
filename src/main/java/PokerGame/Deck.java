package PokerGame;

import java.util.ArrayList;

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
     * Adds card to the Deck
     * @param card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }


    /**
     * returns the amount of cards in the deck
     * @return the length of deck
     */
    public int getLength() {
        return cards.size();
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


    /**
     * Initializes Deck. Fills the deck with 52 cards. 4 different suits. 13 different values.
     * TODO: Kesken
     */
    public void initialize() {
        for (int i = 0; i < suits.length; i++) {
                for (int j = 2; j <= 14; j++) {
                    Card card = new Card(suits[i], j);
                    cards.add(card);
                }
            }
        }
    }

