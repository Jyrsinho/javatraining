package ArrayAnalyzerTest;

import ArrayAnalyzer.ArrayAnalyzer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayAnazylerTest {


    @Test
    public void testShouldReturnThreeFromArrayFullOfThrees() {
        int[] array = {3,3,3,3,3};
        ArrayAnalyzer arrayAnalyzer = new ArrayAnalyzer(array);

        assertEquals(3, arrayAnalyzer.findMode());


    }
}
