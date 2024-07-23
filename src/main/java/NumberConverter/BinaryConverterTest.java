package NumberConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryConverterTest {

    @Test
    public void testShouldReturnStringOfOnesAndZeros() {

        BinaryConverter binaryConverter = new BinaryConverter();
        int number = 8;
        String result = binaryConverter.convertDecimalToBinary(number);
        assertTrue(result != null);

    }
}
