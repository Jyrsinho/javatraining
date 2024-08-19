package CipherTextTest;

import CipherText.CipherText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CipherTextTest {

    private final char[] alphabet = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    @Test
    public void testCipherText() {
        CipherText cipherText = new CipherText("AUTO",1,false);

        assertEquals("BVUP", cipherText.encrypt("AUTO", alphabet ));

    }

    @Test
    public void testCipherText2() {
        CipherText cipherText = new CipherText("BABA",1,false);

        assertEquals("CBCB", cipherText.encrypt("BABA", alphabet ));
    }

    @Test
    public void testShouldReturnCipherTextWhenPlainTextCharsAtTheEndOfAlphabet() {
        CipherText cipherText = new CipherText("ZORRO",1,false);

        assertEquals("APSSP", cipherText.encrypt("ZORRO", alphabet ));
    }

    @Test
    public void testShouldGiveProperCipherTextWhenThreeStepsAtTheEndOfAlphabet() {
        CipherText cipherText = new CipherText("ZYX",3,false);

        assertEquals("CBA", cipherText.encrypt("ZYX", alphabet ));
    }

    @Test
    public void testShouldGiveProperCipherTextWhenGoingBackWardsInAlphabet() {
        CipherText cipherText = new CipherText("ABBA",1, true);
        assertEquals("ZAAZ", cipherText.encrypt("ABBA", alphabet ));

    }

    @Test
    public void testShouldGiveProperCipherTextWhenThreeStepsAtTheBeginningOfAlphabet() {
        CipherText cipherText = new CipherText("ABBA",3,true);

        assertEquals("XYYX", cipherText.encrypt("ABBA", alphabet ));
    }

    @Test
    public void testShouldConvertCipherTextBackToPlaintext() {
        CipherText cipherText = new CipherText("ABBA",2,true);
        String cryptedText = cipherText.encrypt("ABBA", alphabet );
        assertEquals("ABBA", cipherText.decrypt(cryptedText, alphabet));
    }

    @Test
    public void testShouldCreateRandomAlphabetOfSameLengthAsOriginal() {
        CipherText cipherText = new CipherText("ABBA",1,false);

        char []randomAlphabet = cipherText.createRandomAlphabet();

        assertEquals(cipherText.getAlphabetLength(), randomAlphabet.length);

    }


    @Test
    public void testShouldCreateRandomAlphabet() {
        CipherText cipherText = new CipherText("ABBA",1,false);
        char []randomAlphabet = cipherText.createRandomAlphabet();

        assertNotEquals('A', randomAlphabet[0]);
    }

    @Test
    public void testShouldCreateRandomAlphabetWithUniqueCharacters() {
        CipherText cipherText = new CipherText("ABBA",1,false);
        char []randomAlphabet = cipherText.createRandomAlphabet();

    }

    @Test
    public void testShouldBeAbleToEncryptAndDecryptWithRandomAlphabet() {

        CipherText cipherText = new CipherText("ABBA",1,false);

        char[] randomAlphabet = cipherText.createRandomAlphabet();

        String cryptedText = cipherText.encrypt("ABBA", randomAlphabet);
        assertEquals("ABBA", cipherText.decrypt(cryptedText, randomAlphabet));

    }

}
