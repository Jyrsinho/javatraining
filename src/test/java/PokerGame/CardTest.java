package PokerGame;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testConstructorInitializesCorrectly() {
        Card fiveOfHearts = new Card ("hearts", 5);

        assertEquals("hearts", fiveOfHearts.getSuit());
        assertEquals(5, fiveOfHearts.getValue());
    }
}