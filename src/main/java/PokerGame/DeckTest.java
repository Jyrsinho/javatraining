package PokerGame;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }


    @Test
    public void testShouldAddCardToDeck() {
        Assertions.assertEquals(0, deck.getLength());

        Card fiveofHearts = new Card ("hearts", 5);
        deck.addCard(fiveofHearts);
        assertEquals(1, deck.getLength());

    }


    @Test
    public void testDeckShouldInitializeDeckWith52Cards() {
        Assertions.assertEquals(0, deck.getLength());

        deck.initialize();
        assertEquals(52, deck.getLength());
    }


    @Test
    public void testDeckSuitCounterShouldReturnOneIfDeckHasOneCardOfGivenSuit() {
        Assertions.assertEquals(0, deck.suitCounter("hearts"));

        Card fiveofHearts = new Card ("hearts", 5);
        deck.addCard(fiveofHearts);
        Assertions.assertEquals(1, deck.suitCounter("hearts"));

    }


    @Test
    public void testDeckShouldInitializeDeckWith13Hearts() {
        deck.initialize();
        Assertions.assertEquals(13,deck.suitCounter("hearts"));
    }

    @Test
    public void testDeckShouldInitializeDeckWith13Spades() {
        deck.initialize();
        Assertions.assertEquals(13,deck.suitCounter("spades"));
    }

    @Test
    public void testDeckShouldSortItselfAccordingToCardValues() {
        deck.addCard(new Card("Hearts", 5));
        deck.addCard(new Card("Spades", 2));
        deck.addCard(new Card("Diamonds", 14));
        deck.addCard(new Card("Clubs", 10));
        deck.sortDeck();

        List<Card> sortedCards = deck.getCards();
        List<Card> expectedOrder = new ArrayList<Card>();
        expectedOrder.add(new Card("Spades", 2));
        expectedOrder.add(new Card("Hearts", 5));
        expectedOrder.add(new Card("Clubs", 10));
        expectedOrder.add(new Card("Diamonds", 14));

        Assertions.assertEquals(expectedOrder, sortedCards);
    }

    @Test
    public void testShouldShuffleTheDeck() {
        deck.addCard(new Card("Hearts", 5));
        deck.addCard(new Card("Spades", 2));
        deck.addCard(new Card("Diamonds", 14));
        deck.addCard(new Card("Clubs", 10));
        deck.sortDeck();
        System.out.println("Deck before shuffle:");
        System.out.println(deck);
        String deckBeforeShuffle = deck.toString();
        deck.shuffle();
        String deckAfterShuffle = deck.toString();
        System.out.println("Deck after shuffle:");
        System.out.println(deck);

        assertNotEquals(deckAfterShuffle, deckBeforeShuffle);

    }
}
