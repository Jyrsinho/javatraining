package CipherTextTest;

import CipherText.CipherText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipherTextTest {

    @Test
    public void testCipherText() {
        CipherText cipherText = new CipherText("AUTO");

        assertEquals("BVUP", cipherText.encrypt());

    }
}
