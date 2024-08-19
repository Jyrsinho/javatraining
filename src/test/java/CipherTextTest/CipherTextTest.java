package CipherTextTest;

import CipherText.CipherText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CipherTextTest {

    @Test
    public void testCipherText() {
        CipherText cipherText = new CipherText("AUTO",1,false);

        assertEquals("BVUP", cipherText.encrypt( ));

    }

    @Test
    public void testCipherText2() {
        CipherText cipherText = new CipherText("BABA",1,false);

        assertEquals("CBCB", cipherText.encrypt());
    }

    @Test
    public void testShouldReturnCipherTextWhenPlainTextCharsAtTheEndOfAlphabet() {
        CipherText cipherText = new CipherText("ZORRO",1,false);

        assertEquals("APSSP", cipherText.encrypt());
    }

    @Test
    public void testShouldGiveProperCipherTextWhenThreeStepsAtTheEndOfAlphabet() {
        CipherText cipherText = new CipherText("ZYX",3,false);

        assertEquals("CBA", cipherText.encrypt());
    }

    @Test
    public void testShouldGiveProperCipherTextWhenGoingBackWardsInAlphabet() {
        CipherText cipherText = new CipherText("ABBA",1, true);
        assertEquals("ZAAZ", cipherText.encrypt());

    }

    @Test
    public void testShouldGiveProperCipherTextWhenThreeStepsAtTheBeginningOfAlphabet() {
        CipherText cipherText = new CipherText("ABBA",3,true);

        assertEquals("XYYX", cipherText.encrypt());
    }

    @Test
    public void testShouldConvertCipherTextBackToPlaintext() {
        CipherText cipherText = new CipherText("ABBA",2,true);
        cipherText.encrypt();
        assertEquals("ABBA", cipherText.decrypt());
    }

}
