package PokerGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HandTest {

    Hand handOne;
    Card fiveOfHearts;
    Card threeOfHearts;
    Card tenOfDiamonds;
    Card sevenOfSpades;
    Card fiveOfClubs;
    Card twoOfClubs;
    CardSorter sorter;


    @Before
    public void beforeTests() {
        handOne = new Hand();
        fiveOfHearts = new Card("hearts", 5);
        threeOfHearts = new Card("hearts", 3);
        tenOfDiamonds = new Card("diamonds", 10);
        sevenOfSpades = new Card("spades", 7);
        fiveOfClubs = new Card("clubs", 5);
        twoOfClubs = new Card("clubs", 2);
        sorter = new CardSorter();

    }


    @Test
    public void testShouldBeAbleToAddACardToArrayList() throws TooManyElementsException {

        assertEquals(0, handOne.getHandLength());
        handOne.addCardToHand(fiveOfHearts);
        assertEquals(1, handOne.getHandLength());
    }


    @Test
    public void testShouldBeAbleToAddSeveralCardsToArrayList() throws TooManyElementsException {
        assertEquals(0, handOne.getHandLength());
        handOne.addCardToHand(fiveOfHearts);
        assertEquals(1, handOne.getHandLength());
        handOne.addCardToHand(threeOfHearts);
        handOne.addCardToHand(tenOfDiamonds);
        handOne.addCardToHand(sevenOfSpades);
        handOne.addCardToHand(fiveOfClubs);
        assertEquals(5, handOne.getHandLength());
    }


    @Test
    public void testShouldNotBeAbleToAddMoreThanFiveCardsToHand() throws TooManyElementsException {
        try {
            for (int i = 0; i < 6; i++) {
                handOne.addCardToHand(new Card("hearts", i));
            }
            fail("Expected TooManyElementsException to be thrown");
        } catch (TooManyElementsException e) {
            assertEquals("Cannot add more than 5 cards to the hand.", e.getMessage());
        }
    }

    @Test
    public void testShouldBeAbleToSortCardsAccordingToValue() throws TooManyElementsException {
        handOne.addCardToHand(fiveOfHearts);
        handOne.addCardToHand(threeOfHearts);
        handOne.addCardToHand(tenOfDiamonds);
        handOne.addCardToHand(sevenOfSpades);
        handOne.addCardToHand(twoOfClubs);




    }
}