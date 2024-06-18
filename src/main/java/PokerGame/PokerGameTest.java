package PokerGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class PokerGameTest {

    PokerGame game;
    Hand hand;

    @Before
    public void setUp() {
        game = new PokerGame();
        hand = new Hand();

    }


    @Test
    public void testEvaluateHandShouldReturnHighCard () throws TooManyElementsException {
        hand.addCardToHand(new Card("spades",2));
        hand.addCardToHand(new Card("clubs", 5));
        hand.addCardToHand(new Card("diamonds", 7));
        hand.addCardToHand(new Card("hearts", 10));
        hand.addCardToHand(new Card("clubs", 12));

        assertEquals("High Card: 12ofclubs", game.evaluateHand(hand));

    }

    @Ignore
    public void testHandShouldBeValuedRoyalFlushIfRoalFlush() throws TooManyElementsException {
        hand.addCardToHand(new Card("diamonds",14));
        hand.addCardToHand(new Card("diamonds",13));
        hand.addCardToHand(new Card("diamonds",12));
        hand.addCardToHand(new Card("diamonds",11));
        hand.addCardToHand(new Card("diamonds",10));

        assertEquals("Royal Flush", game.evaluateHand(hand));
    }


}
