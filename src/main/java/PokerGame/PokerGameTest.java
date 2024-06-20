package PokerGame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokerGameTest {

    PokerGame game;
    Player playerOne;
    Player playerTwo;
    Hand hand;
    Hand hand2;

    @Before
    public void setUp() {
        game = new PokerGame();
        hand = new Hand();
        hand2 = new Hand();
        playerOne = new Player(hand, "playerOne", "blue");
        playerTwo = new Player(hand2, "playerTwo", "black");
        game.addPlayerToGame(playerTwo);
        game.addPlayerToGame(playerOne);

    }

    @Test
    public void testShouldAddAPlayerToAGame() {
        assertEquals(2, game.getAmountOfPlayers());
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

    @Test
    public void testEvaluateShouldReturnRoyalFlush()throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("diamonds", 10));

        assertEquals("Royal Flush", game.evaluateHand(hand));
    }

    @Test
    public void testShouldReturnTrueIfHandHasAtLeastOnePair() throws TooManyElementsException {
        int [] histogram = {0,0,0,0,4,};
        assertEquals(true, game.checkIfHandIsPaired(histogram));
    }

    @Test
    public void testShouldReturnFalseIfHandHasNoPair() throws  TooManyElementsException {
        int [] histogram = {0,0,1,1,1,1,1};
        assertEquals(false, game.checkIfHandIsPaired(histogram));
    }


    @Test
    public void testShouldUpdateHandValues() throws TooManyElementsException {
        assertNull(hand.getHandValue());
        assertNull(hand2.getHandValue());

        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("diamonds", 10));

        hand2.addCardToHand(new Card("diamonds", 10));
        hand2.addCardToHand(new Card("clubs", 13));
        hand2.addCardToHand(new Card("clubs", 12));
        hand2.addCardToHand(new Card("clubs", 11));
        hand2.addCardToHand(new Card("clubs", 10));

        game.updateHandValues();
        assertEquals("Royal Flush", hand.getHandValue());
        assertEquals("One Pair", hand2.getHandValue());
    }

    @Test
    public void testShouldReturnCorrectIndexValueForHandValue() {
        assertEquals(0, game.getNumericalValueForHandValue("Royal Flush"));
        assertEquals(1, game.getNumericalValueForHandValue("Straight Flush"));
        assertEquals(2, game.getNumericalValueForHandValue("Four of a Kind"));
        assertEquals(3, game.getNumericalValueForHandValue("Full House"));
        assertEquals(4, game.getNumericalValueForHandValue("Flush"));
        assertEquals(5, game.getNumericalValueForHandValue("Straight"));
        assertEquals(6, game.getNumericalValueForHandValue("Three of a Kind"));
        assertEquals(7, game.getNumericalValueForHandValue("Two Pair"));
        assertEquals(8, game.getNumericalValueForHandValue("One Pair"));
        assertEquals(9, game.getNumericalValueForHandValue("High Card"));
    }


    @Ignore
    public void testShouldDeclareHandWithRoyalFlushWinnerOverHandWithPair() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("diamonds", 10));

        hand2.addCardToHand(new Card("diamonds", 10));
        hand2.addCardToHand(new Card("clubs", 13));
        hand2.addCardToHand(new Card("clubs", 12));
        hand2.addCardToHand(new Card("clubs", 11));
        hand2.addCardToHand(new Card("clubs", 10));


        assertEquals("playerOne", game.findOutWinner());
    }

    @Ignore
    public void testShouldDeclareHandWithThreeOfAKindWinnerOverHandWithOnePair() throws TooManyElementsException{
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("clubs", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("clubs", 9));
        hand.addCardToHand(new Card("diamonds", 9));

        hand2.addCardToHand(new Card("diamonds", 10));
        hand2.addCardToHand(new Card("clubs", 13));
        hand2.addCardToHand(new Card("clubs", 12));
        hand2.addCardToHand(new Card("spades", 10));
        hand2.addCardToHand(new Card("clubs", 10));


        assertEquals("playerTwo", game.findOutWinner());
    }
}
