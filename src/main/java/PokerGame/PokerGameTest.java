package PokerGame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokerGameTest {

    PokerGame game;
    Player playerOne;
    Player playerTwo;
    Player playerThree;
    Hand hand;
    Hand hand2;
    Hand hand3;

    @Before
    public void setUp() {
        game = new PokerGame();
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

        assertEquals("High Card", game.evaluateHand(hand));

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



    @Test
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

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerOne", game.findOutWinner());
    }

    @Test
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

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testShouldDeclareWinnerHandWithBiggerFlush() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 10));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("diamonds", 2));
        hand.addCardToHand(new Card("diamonds", 6));

        hand2.addCardToHand(new Card("clubs", 14));
        hand2.addCardToHand(new Card("clubs", 13));
        hand2.addCardToHand(new Card("clubs", 12));
        hand2.addCardToHand(new Card("clubs", 7));
        hand2.addCardToHand(new Card("clubs", 9));

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testShouldGetProperIndexValueForHand() {

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

    }

    @Test
    public void testShouldDeclareWinnerHandWithBiggerStraight() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("diamonds", 9));

        hand2.addCardToHand(new Card("clubs", 14));
        hand2.addCardToHand(new Card("clubs", 13));
        hand2.addCardToHand(new Card("spades", 12));
        hand2.addCardToHand(new Card("clubs", 11));
        hand2.addCardToHand(new Card("spades", 10));

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testShouldDeclareWinnerHigherCardEvenWhenOnlyTheLastCardIsHigher () throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("diamonds", 12));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("diamonds", 7));

        hand2.addCardToHand(new Card("clubs", 13));
        hand2.addCardToHand(new Card("spades", 12));
        hand2.addCardToHand(new Card("clubs", 11));
        hand2.addCardToHand(new Card("spades", 10));
        hand2.addCardToHand(new Card("clubs", 6));

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerOne", game.findOutWinner());
    }

    @Test
    public void testShouldDeclareWinnerPairWithHigherValuedPair() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("spades", 13));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("diamonds", 7));

        hand2.addCardToHand(new Card("clubs", 13));
        hand2.addCardToHand(new Card("spades", 12));
        hand2.addCardToHand(new Card("clubs", 11));
        hand2.addCardToHand(new Card("spades", 6));
        hand2.addCardToHand(new Card("clubs", 6));

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerOne", game.findOutWinner());
    }

    @Test
    public void testShouldBeAbleToUpdateHandValueSavedInHand() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("spades", 13));
        hand.addCardToHand(new Card("diamonds", 11));
        hand.addCardToHand(new Card("hearts", 2));
        hand.addCardToHand(new Card("diamonds", 7));

        hand2.addCardToHand(new Card("hearts", 13));
        hand2.addCardToHand(new Card("hearts", 12));
        hand2.addCardToHand(new Card("hearts", 11));
        hand2.addCardToHand(new Card("hearts", 10));
        hand2.addCardToHand(new Card("hearts", 7));

        game.updateHandValues();

        assertEquals("One Pair", hand.getHandValue());
        assertEquals(8, hand.getRankingValue());
        assertEquals("Flush", hand2.getHandValue());
        assertEquals(4, hand2.getRankingValue());
    }

    @Test
    public void testShouldDeclareWinnerForHigherFlush() throws TooManyElementsException {
        hand.addCardToHand(new Card("clubs", 13));
        hand.addCardToHand(new Card("clubs", 12));
        hand.addCardToHand(new Card("clubs", 11));
        hand.addCardToHand(new Card("clubs", 6));
        hand.addCardToHand(new Card("clubs", 6));

        hand2.addCardToHand(new Card("diamonds", 13));
        hand2.addCardToHand(new Card("diamonds", 12));
        hand2.addCardToHand(new Card("diamonds", 11));
        hand2.addCardToHand(new Card("diamonds", 6));
        hand2.addCardToHand(new Card("diamonds", 2));

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testShouldDeclareWinnerPairWithHigherValuedPair2() throws TooManyElementsException {
        hand.addCardToHand(new Card("clubs", 13));
        hand.addCardToHand(new Card("spades", 12));
        hand.addCardToHand(new Card("clubs", 11));
        hand.addCardToHand(new Card("spades", 6));
        hand.addCardToHand(new Card("clubs", 6));

        hand2.addCardToHand(new Card("diamonds", 7));
        hand2.addCardToHand(new Card("spades", 7));
        hand2.addCardToHand(new Card("diamonds", 5));
        hand2.addCardToHand(new Card("hearts", 3));
        hand2.addCardToHand(new Card("diamonds", 2));

        game.updateHandValues();

        System.out.println("Player One Hand: " + hand.getCards());
        System.out.println("Player One Hand Value: " + playerOne.getHandValue());
        System.out.println("Player Two Hand: " + hand2.getCards());
        System.out.println("Player Two Hand Value: " + playerTwo.getHandValue());

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testShouldDeclareWinnerSetOfThreesWithHigherValuedSet() throws TooManyElementsException {
        hand.addCardToHand(new Card("clubs", 13));
        hand.addCardToHand(new Card("spades", 12));
        hand.addCardToHand(new Card("clubs", 6));
        hand.addCardToHand(new Card("spades", 6));
        hand.addCardToHand(new Card("clubs", 6));

        hand2.addCardToHand(new Card("diamonds", 7));
        hand2.addCardToHand(new Card("spades", 7));
        hand2.addCardToHand(new Card("diamonds", 7));
        hand2.addCardToHand(new Card("hearts", 3));
        hand2.addCardToHand(new Card("diamonds", 2));

        game.updateHandValues();

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testShouldDeclareWinnerFourOfAKindWithHigherValuedSetOfFours() throws TooManyElementsException {

        hand.addCardToHand(new Card("clubs", 13));
        hand.addCardToHand(new Card("spades", 13));
        hand.addCardToHand(new Card("diamonds", 13));
        hand.addCardToHand(new Card("hearts", 13));
        hand.addCardToHand(new Card("clubs", 6));

        hand2.addCardToHand(new Card("diamonds", 10));
        hand2.addCardToHand(new Card("spades", 10));
        hand2.addCardToHand(new Card("hearts", 10));
        hand2.addCardToHand(new Card("clubs", 10));
        hand2.addCardToHand(new Card("diamonds", 2));

        game.updateHandValues();

        assertEquals("playerOne", game.findOutWinner());
    }

    @Test
    public void testShouldDeclareWinnerWithHighestPairWithThreePlayers() throws TooManyElementsException {
        game.addPlayerToGame(playerThree);

        hand.addCardToHand(new Card("clubs", 13));
        hand.addCardToHand(new Card("spades", 13));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("hearts", 8));
        hand.addCardToHand(new Card("clubs", 2));

        hand2.addCardToHand(new Card("diamonds", 14));
        hand2.addCardToHand(new Card("spades", 14));
        hand2.addCardToHand(new Card("hearts", 4));
        hand2.addCardToHand(new Card("clubs", 9));
        hand2.addCardToHand(new Card("diamonds", 6));

        hand3.addCardToHand(new Card("spades", 10));
        hand3.addCardToHand(new Card("hearts", 10));
        hand3.addCardToHand(new Card("clubs", 3));
        hand3.addCardToHand(new Card("diamonds", 2));
        hand3.addCardToHand(new Card("spades", 7));

        game.updateHandValues();

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testWinnerShouldBePairWithHighestKickerIfPairsAreEqual() throws TooManyElementsException {

        hand2.addCardToHand(new Card("clubs", 14));
        hand2.addCardToHand(new Card("spades", 14));
        hand2.addCardToHand(new Card("diamonds", 7));
        hand2.addCardToHand(new Card("diamonds", 8));
        hand2.addCardToHand(new Card("diamonds", 2));

        hand.addCardToHand(new Card("hearts", 14));
        hand.addCardToHand(new Card("diamonds", 14));
        hand.addCardToHand(new Card("hearts", 7));
        hand.addCardToHand(new Card("hearts", 8));
        hand.addCardToHand(new Card("hearts", 3));

        game.updateHandValues();

        assertEquals("playerOne", game.findOutWinner());
    }

    @Test
    public void testShouldOutcomeShouldBeTieIfPlayersHaveEqualFlushes() throws TooManyElementsException {

    }
}
