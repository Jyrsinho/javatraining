package Pokergametest;

import PokerGame.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {

    private Card fiveOfHearts;
    private Card tenOfSpades;
    private Card fiveofDiamonds;
    private Card twoofClubs;

    @BeforeEach
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

    @Test
    public void testShouldThrowNullPointerExceptionWhenCardIsNull() {
        assertThrows(NullPointerException.class, () -> {
            fiveOfHearts.compareTo(null);
        });
    }


}