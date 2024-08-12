package Pokergametest;

import PokerGame.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandEvaluatorTest {

    PokerGame game;
    HandEvaluator handEvaluator;
    Player playerOne;
    Player playerTwo;
    Player playerThree;
    Hand hand;
    Hand hand2;
    Hand hand3;

    @BeforeEach
    public void setUp() {
        game = new PokerGame();
        handEvaluator = new HandEvaluator();
        hand = new Hand();
        hand2 = new Hand();
        hand3 = new Hand();
        playerOne = new Player(hand, "playerOne", "blue");
        playerTwo = new Player(hand2, "playerTwo", "black");
        playerThree = new Player(hand3, "playerThree", "white");

        game.addPlayerToGame(playerTwo);
        game.addPlayerToGame(playerOne);

    }

    @Test
    public void testEvaluateHandShouldReturnHighCard() throws TooManyElementsException {
        hand.addCardToHand(new Card("spades", 2));
        hand.addCardToHand(new Card("clubs", 5));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("clubs", 12));

        Assertions.assertEquals("High Card", handEvaluator.evaluateHand(hand));

    }


    @Test
    public void testHandShouldBeValuedFlushIfFlush() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("diamonds", 4));
        hand.addCardToHand(new Card("diamonds", 2));

        Assertions.assertEquals("Flush", handEvaluator.evaluateHand(hand));
    }

    @Test
    public void testHandShouldNotBeValuedWithFlushIfNotAllCarsAreTheSameSuit() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 7));
        hand.addCardToHand(new Card("diamonds", 4));
        hand.addCardToHand(new Card("diamonds", 2));

        Assertions.assertFalse(handEvaluator.checkIfFlush(hand));
    }

    @Test
    public void testHandShouldBeValuedStraight() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("clubs", 12));
        hand.addCardToHand(new Card("spades", 11));
        hand.addCardToHand(new Card("diamonds", 10));

        Assertions.assertEquals("Straight", handEvaluator.evaluateHand(hand));
    }

    @Test
    public void testHandShouldNotBeValuedStraightIfNotStraight() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 7));
        hand.addCardToHand(new Card("diamonds", 4));
        hand.addCardToHand(new Card("diamonds", 2));

        Assertions.assertFalse(handEvaluator.checkIfStraight(hand));
    }

    @Test
    public void testEvaluateShouldReturnAPairIfHandContainsAPair() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("spades", 4));
        hand.addCardToHand(new Card("hearts", 2));

        Assertions.assertEquals("One Pair", handEvaluator.evaluateHand(hand));
    }

    @Test
    public void testCreateHistogramShouldReturnAnArrayWith15indices() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("spades", 4));
        hand.addCardToHand(new Card("hearts", 2));

        Assertions.assertEquals(15, handEvaluator.createValueHistogramForHand(hand).length);
    }

    @Test
    public void testCreateHistogramShouldCountHowManyInstancesOfCertainValueAreInHand () throws TooManyElementsException {

        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("clubs", 10));
        hand.addCardToHand(new Card("hearts", 14));
        Assertions.assertEquals(3, handEvaluator.createValueHistogramForHand(hand)[14]);
        Assertions.assertEquals(2, handEvaluator.createValueHistogramForHand(hand)[10]);
        Assertions.assertEquals(0, handEvaluator.createValueHistogramForHand(hand)[3]);
    }


    @Test
    public void testCreateHistogramShouldCountTwoInstancesOfValueTwoIfThoseExistInHand() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("spades", 4));
        hand.addCardToHand(new Card("hearts", 2));

        Assertions.assertEquals(2, handEvaluator.createValueHistogramForHand(hand)[14]);
        Assertions.assertEquals(1, handEvaluator.createValueHistogramForHand(hand)[10]);
        Assertions.assertEquals(1, handEvaluator.createValueHistogramForHand(hand)[4]);
        Assertions.assertEquals(1, handEvaluator.createValueHistogramForHand(hand)[2]);
    }


    @Test
    public void testEvaluateShouldReturnTwoPairIfHandContainsTwoPairs() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("clubs", 10));
        hand.addCardToHand(new Card("hearts", 2));

        Assertions.assertEquals("Two Pair", handEvaluator.evaluateHand(hand));

    }

    @Test
    public void testEvaluateShouldReturnStraightFlush()throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("diamonds", 9));
        hand.addCardToHand(new Card("diamonds", 8));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("diamonds", 6));

        Assertions.assertEquals("Straight Flush", handEvaluator.evaluateHand(hand));
    }

    @Test
    public void testEvaluateShouldReturnRoyalFlush()throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("diamonds", 10));

        Assertions.assertEquals("Royal Flush", handEvaluator.evaluateHand(hand));
    }



    @Test
    public void testShouldReturnTrueIfHandHasAtLeastOnePair()  {
        int [] histogram = {0,0,0,0,4,};
        Assertions.assertTrue(handEvaluator.checkIfHandIsPaired(histogram));
    }

    @Test
    public void testShouldReturnFalseIfHandHasNoPair()  {
        int [] histogram = {0,0,1,1,1,1,1};
        Assertions.assertFalse(handEvaluator.checkIfHandIsPaired(histogram));
    }


    @Test
    public void testShouldReturnCorrectIndexValueForHandValue() {
        assertEquals(0, game.getIndexValueForHandValue("Royal Flush"));
        assertEquals(1, game.getIndexValueForHandValue("Straight Flush"));
        assertEquals(2, game.getIndexValueForHandValue("Four of a Kind"));
        assertEquals(3, game.getIndexValueForHandValue("Full House"));
        assertEquals(4, game.getIndexValueForHandValue("Flush"));
        assertEquals(5, game.getIndexValueForHandValue("Straight"));
        assertEquals(6, game.getIndexValueForHandValue("Three of a Kind"));
        assertEquals(7, game.getIndexValueForHandValue("Two Pair"));
        assertEquals(8, game.getIndexValueForHandValue("One Pair"));
        assertEquals(9, game.getIndexValueForHandValue("High Card"));
        assertEquals(-1, game.getIndexValueForHandValue("Banaani"));
    }
}
