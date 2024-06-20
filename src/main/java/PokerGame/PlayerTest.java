package PokerGame;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;


public class PlayerTest {

    private Player timo;

    @Before
    public void setUp() {
        timo = new Player(null,"Timo", "blue");
    }

    @Test
    public void testPlayerConstructorInitializesCorrectly() {

        assertEquals("Timo",timo.getName());
        assertEquals("blue", timo.getColor());
    }
}
