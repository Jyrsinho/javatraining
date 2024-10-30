package AlgorithmsOneTest;

import AlgorithmsOne.Algorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static AlgorithmsOne.Algorithms.modulo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {

    @BeforeEach
    public void setUp() {
        Algorithms algorithmsOne = new Algorithms();
    }

    @Test
    public void testShouldReturnModuloOfTwoIntegers() {
        int a = 5;
        int b = 2;
        int expected = 1;
        assertEquals(modulo(a, b), expected);

    }

}
