package PokerGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

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

        Assertions.assertEquals(0, handOne.getHandLength());
        handOne.addCardToHand(fiveOfHearts);
        Assertions.assertEquals(1, handOne.getHandLength());
    }


    @Ignore
    public void testShouldBeAbleToAddSeveralCardsToArrayList() throws TooManyElementsException {
        Assertions.assertEquals(0, handOne.getHandLength());
        handOne.addCardToHand(fiveOfHearts);
        Assertions.assertEquals(1, handOne.getHandLength());
        handOne.addCardToHand(threeOfHearts);
        handOne.addCardToHand(tenOfDiamonds);
        handOne.addCardToHand(sevenOfSpades);
        handOne.addCardToHand(fiveOfClubs);
        Assertions.assertEquals(5, handOne.getHandLength());
    }


    @Test
    public void testShouldNotBeAbleToAddMoreThanFiveCardsToHand() throws TooManyElementsException {
        try {
            for (int i = 0; i < 6; i++) {
                handOne.addCardToHand(new Card("hearts", i));
            }
            Assertions.fail("Expected TooManyElementsException to be thrown");
        } catch (TooManyElementsException e) {
            Assertions.assertEquals("Cannot add more than 5 cards to the hand.", e.getMessage());
        }
    }

    @Test
    public void testShouldBeAbleToSortCardsInHandAccordingToValue() throws TooManyElementsException {
        handOne.addCardToHand(fiveOfHearts);
        handOne.addCardToHand(threeOfHearts);
        handOne.addCardToHand(tenOfDiamonds);
        handOne.addCardToHand(sevenOfSpades);
        handOne.addCardToHand(twoOfClubs);
        handOne.sortHand();

        List <Card> sortedHand = handOne.getCards();
        List <Card> expectedOrder = new ArrayList<>();
        expectedOrder.add(twoOfClubs);
        expectedOrder.add(threeOfHearts);
        expectedOrder.add(fiveOfHearts);
        expectedOrder.add(sevenOfSpades);
        expectedOrder.add(tenOfDiamonds);

        Assertions.assertEquals(expectedOrder, sortedHand);

    }
}