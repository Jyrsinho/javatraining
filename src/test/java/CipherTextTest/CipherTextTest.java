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
}
