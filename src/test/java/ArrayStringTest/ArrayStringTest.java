package ArrayStringTest;

import ArrayString.ArrayString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayStringTest {

    @Test
    public void testShouldReturnSubstring() {
        ArrayString aS = new ArrayString();

        char[] testArray = new char[]{'a','a','s','i'};
        char[] expectedArray = new char[]{'a','s'};
        assertArrayEquals(expectedArray, aS.substring(testArray, 1, 2) );

    }
}
