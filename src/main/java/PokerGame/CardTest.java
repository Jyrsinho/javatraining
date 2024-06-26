package PokerGame;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CardTest {

    private Card fiveOfHearts;
    private Card tenOfSpades;
    private Card fiveofDiamonds;
    private Card twoofClubs;

    @Before
    public void setUp() {
        fiveOfHearts = new Card("hearts", 5);    // Base card
        tenOfSpades = new Card("spades", 10);   // Higher value card
        fiveofDiamonds = new Card("diamonds", 5);  // Same value, different suit
        twoofClubs = new Card("clubs", 2);     // Lower value card
    }


    @Test
    public void testConstructorInitializesCorrectly() {
        Assertions.assertEquals("hearts", fiveOfHearts.getSuit());
        Assertions.assertEquals(5, fiveOfHearts.getValue());
    }

    @Test
    public void testShouldReturnNegativeIntegerWhenComparedToHigherValueCard() {
        Assertions.assertTrue(fiveOfHearts.compareTo(tenOfSpades) < 0);
    }

    @Test
    public void testShouldReturnPositiveIntegerWhenComparedToLowerValueCard() {
        Assertions.assertTrue(fiveOfHearts.compareTo(twoofClubs) > 0);
    }

    @Test
    public void testShouldReturnZeroWhenComparedToEqualValueCard() {
        Assertions.assertEquals(0, fiveOfHearts.compareTo(fiveofDiamonds));
    }

    @Test (expected = NullPointerException.class)
    public void testShouldThrowNullPointerExceptionWhenCardIsNull() {
        fiveOfHearts.compareTo(null);
    }


}