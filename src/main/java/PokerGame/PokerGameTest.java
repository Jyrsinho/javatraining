package PokerGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokerGameTest {

    PokerGame game;
    Player playerOne;
    Player playerTwo;
    Player playerThree;
    Hand hand;
    Hand hand2;
    Hand hand3;

    @BeforeEach
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
    public void testShouldDealFiveCardsToEachPlayerInTheGame() throws TooManyElementsException {

        game.initialize();
        System.out.println(playerOne.getHand());
        assertEquals(5, playerOne.getHand().getCards().size());
    }

    @Test
    public void testShouldDealFiveDifferentCardsToEachPlayerInTheGame() throws TooManyElementsException {
        game.initialize();
        System.out.println(playerOne.getHand());
        System.out.println(playerTwo.getHand());
        assertNotEquals(playerTwo.getHand().getCards().get(0), playerTwo.getHand().getCards().get(1));
    }

    @Test
    public void testShouldRemoveDealtCardsFromTheDeck() throws TooManyElementsException{
        game.initialize();
        assertEquals(42, game.getAmountOfCardsInDeck());
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
    public void testShouldEvaluateTieIfPlayersHaveEqualFlushes() throws TooManyElementsException {
        hand2.addCardToHand(new Card("clubs", 14));
        hand2.addCardToHand(new Card("clubs", 10));
        hand2.addCardToHand(new Card("clubs", 7));
        hand2.addCardToHand(new Card("clubs", 8));
        hand2.addCardToHand(new Card("clubs", 2));

        hand.addCardToHand(new Card("hearts", 14));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("hearts", 7));
        hand.addCardToHand(new Card("hearts", 8));
        hand.addCardToHand(new Card("hearts", 2));

        game.updateHandValues();

        assertEquals("Tie: playerTwo & playerOne", game.findOutWinner());
    }

    @Test
    public void testShouldEvaluateTieIfPlayersHaveEqualStraights() throws TooManyElementsException {
        hand2.addCardToHand(new Card("clubs", 12));
        hand2.addCardToHand(new Card("diamonds", 11));
        hand2.addCardToHand(new Card("hearts", 10));
        hand2.addCardToHand(new Card("clubs", 9));
        hand2.addCardToHand(new Card("clubs", 8));

        hand.addCardToHand(new Card("spades", 12));
        hand.addCardToHand(new Card("clubs", 11));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("hearts", 9));
        hand.addCardToHand(new Card("hearts", 8));

        game.updateHandValues();

        assertEquals("Tie: playerTwo & playerOne", game.findOutWinner());
    }

    @Test
    public void testShouldAwardWinForPlayerWithBetterSmallerPairInCaseBothPlayersHaveTwoPairWithSameHighPair() throws TooManyElementsException {
        hand2.addCardToHand(new Card("clubs", 12));
        hand2.addCardToHand(new Card("diamonds", 12));
        hand2.addCardToHand(new Card("hearts", 10));
        hand2.addCardToHand(new Card("clubs", 10));
        hand2.addCardToHand(new Card("clubs", 8));

        hand.addCardToHand(new Card("spades", 12));
        hand.addCardToHand(new Card("hearts", 12));
        hand.addCardToHand(new Card("hearts", 8));
        hand.addCardToHand(new Card("hearts", 9));
        hand.addCardToHand(new Card("hearts", 9));

        game.updateHandValues();

        assertEquals("playerTwo", game.findOutWinner());
    }

    @Test
    public void testShouldBeThreeWayTieIfThreePlayerAllHaveSameHandsWithHighCard() throws TooManyElementsException {
        game.addPlayerToGame(playerThree);

        hand2.addCardToHand(new Card("clubs", 12));
        hand2.addCardToHand(new Card("diamonds", 11));
        hand2.addCardToHand(new Card("diamonds", 8));
        hand2.addCardToHand(new Card("diamonds", 7));
        hand2.addCardToHand(new Card("diamonds", 6));

        hand.addCardToHand(new Card("hearts", 12));
        hand.addCardToHand(new Card("clubs", 11));
        hand.addCardToHand(new Card("clubs", 8));
        hand.addCardToHand(new Card("clubs", 7));
        hand.addCardToHand(new Card("clubs", 6));

        hand3.addCardToHand(new Card("spades", 12));
        hand3.addCardToHand(new Card("hearts", 11));
        hand3.addCardToHand(new Card("hearts", 8));
        hand3.addCardToHand(new Card("hearts", 7));
        hand3.addCardToHand(new Card("hearts", 6));

        game.updateHandValues();

        assertEquals("Tie: playerTwo & playerOne & playerThree", game.findOutWinner());
    }
}
