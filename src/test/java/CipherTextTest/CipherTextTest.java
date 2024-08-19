package CipherTextTest;

import CipherText.CipherText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipherTextTest {

    @Test
    public void testCipherText() {
        CipherText cipherText = new CipherText("AUTO");

        assertEquals("BVUP", cipherText.encrypt(1, false));

    }

    @Test
    public void testCipherText2() {
        CipherText cipherText = new CipherText("BABA");

        assertEquals("CBCB", cipherText.encrypt(1, false));
    }

    @Test
    public void testShouldReturnCipherTextWhenPlainTextCharsAtTheEndOfAlphabet() {
        CipherText cipherText = new CipherText("ZORRO");

        assertEquals("APSSP", cipherText.encrypt(1, false));
    }

    @Test
    public void testShouldGiveProperCipherTextWhenThreeStepsAtTheEndOfAlphabet() {
        CipherText cipherText = new CipherText("ZYX");

        assertEquals("CBA", cipherText.encrypt(3, false));
    }

    @Test
    public void testShouldGiveProperCipherTextWhenGoingBackWardsInAlphabet() {
        CipherText cipherText = new CipherText("ABBA");
        assertEquals("ZAAZ", cipherText.encrypt(1, true));

    }

    @Test
    public void testShouldGiveProperCipherTextWhenThreeStepsAtTheBeginningOfAlphabet() {
        CipherText cipherText = new CipherText("ABBA");

        assertEquals("XYYX", cipherText.encrypt(3, true));
    }
}
