package PokerGame;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    @Test
    public void testShouldAddCardToDeck() {
        Deck deck = new Deck();
        assertEquals(0, deck.getLength());

        Card fiveofHearts = new Card ("hearts", 5);
        deck.addCard(fiveofHearts);
        assertEquals(1, deck.getLength());

    }


    @Test
    public void testDeckShouldInitializeDeckWith52Cards() {
        Deck deck = new Deck();
        assertEquals(0, deck.getLength());

        deck.initialize();
        assertEquals(52, deck.getLength());
    }


    @Test
    public void testDeckSuitCounterShouldReturnOneIfDeckHasOneCardOfGivenSuit() {
        Deck deck = new Deck();
        assertEquals(0, deck.suitCounter("hearts"));

        Card fiveofHearts = new Card ("hearts", 5);
        deck.addCard(fiveofHearts);
        assertEquals(1, deck.suitCounter("hearts"));

    }


    @Test
    public void testDeckShouldInitializeDeckWith13Hearts() {
        Deck deck = new Deck();
        deck.initialize();
        assertEquals(13,deck.suitCounter("hearts"));
    }

    @Test
    public void testDeckShouldInitializeDeckWith13Spades() {
        Deck deck = new Deck();
        deck.initialize();
        assertEquals(13,deck.suitCounter("spades"));

    }
}
