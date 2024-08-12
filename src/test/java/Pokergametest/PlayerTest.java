package Pokergametest;


import PokerGame.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    private Player timo;

    @BeforeEach
    public void setUp() {
        timo = new Player(null,"Timo", "blue");
    }

    @Test
    public void testPlayerConstructorInitializesCorrectly() {

        assertEquals("Timo",timo.getName());
        assertEquals("blue", timo.getColor());
    }
}
