package PokerGame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PokerGameTest {

    PokerGame game;
    Hand hand;

    @Before
    public void setUp() {
        game = new PokerGame();
        hand = new Hand();

    }


    @Test
    public void testEvaluateHandShouldReturnHighCard() throws TooManyElementsException {
        hand.addCardToHand(new Card("spades", 2));
        hand.addCardToHand(new Card("clubs", 5));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("clubs", 12));

        assertEquals("High Card: 12ofclubs", game.evaluateHand(hand));

    }

    @Test
    public void testHandShouldBeValuedFlushIfFlush() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("diamonds", 4));
        hand.addCardToHand(new Card("diamonds", 2));

        assertEquals("Flush", game.evaluateHand(hand));
    }

    @Test
    public void testHandShouldNotBeValuedWithFlushIfNotAllCarsAreTheSameSuit() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 7));
        hand.addCardToHand(new Card("diamonds", 4));
        hand.addCardToHand(new Card("diamonds", 2));

        assertFalse(game.checkIfFlush(hand));
    }

    @Test
    public void testHandShouldBeValuedStraight() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("clubs", 12));
        hand.addCardToHand(new Card("spades", 11));
        hand.addCardToHand(new Card("diamonds", 10));

        assertEquals("Straight", game.evaluateHand(hand));
    }

    @Test
    public void testHandShouldNotBeValuedStraightIfNotStraight() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 7));
        hand.addCardToHand(new Card("diamonds", 4));
        hand.addCardToHand(new Card("diamonds", 2));

        assertFalse(game.checkIfStraight(hand));
    }

    @Test
    public void testEvaluateShouldReturnAPairIfHandContainsAPair() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("spades", 4));
        hand.addCardToHand(new Card("hearts", 2));

        assertEquals("One Pair", game.evaluateHand(hand));
    }

    @Test
    public void testCreateHistogramShouldReturnAnArrayWith15indices() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("spades", 4));
        hand.addCardToHand(new Card("hearts", 2));

        assertEquals(15, game.createValueHistogramForHand(hand).length);
    }

    @Test
    public void testCreateHistogramShouldCountHowManyInstancesOfCertainValueAreInHand () throws TooManyElementsException {

        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("clubs", 10));
        hand.addCardToHand(new Card("hearts", 14));
        assertEquals(3, game.createValueHistogramForHand(hand)[14]);
        assertEquals(2, game.createValueHistogramForHand(hand)[10]);
        assertEquals(0, game.createValueHistogramForHand(hand)[3]);
    }

    @Test
    public void testCreateHistogramShouldCountTwoInstancesOfValueTwoIfThoseExistInHand() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("spades", 4));
        hand.addCardToHand(new Card("hearts", 2));

        assertEquals(2, game.createValueHistogramForHand(hand)[14]);
        assertEquals(1, game.createValueHistogramForHand(hand)[10]);
        assertEquals(1, game.createValueHistogramForHand(hand)[4]);
        assertEquals(1, game.createValueHistogramForHand(hand)[2]);
    }


    @Test
    public void testEvaluateShouldReturnTwoPairIfHandContainsTwoPairs() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("clubs", 14));
        hand.addCardToHand(new Card("clubs", 10));
        hand.addCardToHand(new Card("hearts", 2));

        assertEquals("Two Pair", game.evaluateHand(hand));

    }

    @Test
    public void testEvaluateShouldReturnStraightFlush()throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("diamonds", 9));
        hand.addCardToHand(new Card("diamonds", 8));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("diamonds", 6));

        assertEquals("Straight Flush", game.evaluateHand(hand));
    }

    @Ignore
    public void testEvaluateShouldReturnRoyalFlush()throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("diamonds", 9));
        hand.addCardToHand(new Card("diamonds", 8));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("diamonds", 6));

        assertEquals("Royal Flush", game.evaluateHand(hand));
    }
}
