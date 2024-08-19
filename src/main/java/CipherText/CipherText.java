package CipherText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CipherText {

    private final char[] alphabet = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private char[] randomAlphabet;


    private final String plainText;
    private final int steps;
    private final boolean reversed;
    private String cryptedText;



    /**
     * Constructor
     * @param plainText plaintext
     */
    public CipherText(String plainText, int steps, boolean reversed) {
        this.plainText = plainText;
        this.steps = steps;
        this.reversed = reversed;
    }


    public String getPlainText() {
        return plainText;
    }


    public int getAlphabetLength() {
        return alphabet.length;
    }


    public void setCryptedText(String cryptedText) {
        this.cryptedText = cryptedText;
    }


    public char[]  createRandomAlphabet() {

       char [] randomAlphabet = new char[alphabet.length];
       List<Character> alphabetList = new ArrayList<>();
       for (char c : alphabet) {
           alphabetList.add(c);
       }

        Collections.shuffle(alphabetList);

        for (int i = 0; i < alphabetList.size(); i++) {
            randomAlphabet[i] =alphabetList.get(i);
        }
        return randomAlphabet;
    }



    /**
     * Encrypts the plaintext attribute of the CipherText object
     * @return encrypted version of the plaintext
     */
    public String encrypt(String plainText, char[] alphabet) {
        StringBuilder cryptedText = new StringBuilder();
        int factor;                                     //determines whether we move forwards or backwards in alphabet array
        if (reversed) factor = -1;
        else factor = 1;

        for (int i = 0; i < plainText.length(); i++) {
            int charactersIndex = findCharIndexFromAlphabet(plainText.charAt(i), alphabet);
            cryptedText.append(findCharacterToBeAppended(charactersIndex,factor,steps, alphabet));
        }

        this.cryptedText = cryptedText.toString();
        return cryptedText.toString();
    }


    public String decrypt(String cryptedText, char[] alphabet) {
        StringBuilder decryptedText = new StringBuilder();
        int factor;
        if (reversed) factor = 1;
        else factor = -1;

        for (int i = 0; i < cryptedText.length(); i++) {
            int charactersIndex = findCharIndexFromAlphabet(cryptedText.charAt(i), alphabet);
            decryptedText.append(findCharacterToBeAppended(charactersIndex,factor,steps, alphabet));
        }

        return decryptedText.toString();
    }


    public char findCharacterToBeAppended(int oCharacterIndex, int factor, int steps, char[] alphabet) {
        int newCharacterIndex;

        if (oCharacterIndex + factor * steps > alphabet.length-1 ||oCharacterIndex + factor * steps < 0 ){
            newCharacterIndex = oCharacterIndex + factor * steps - factor  * alphabet.length;
        } else {
            newCharacterIndex = oCharacterIndex + factor * steps;
        }

        return alphabet[newCharacterIndex];
    }

    /**
     * Finds the given characters index from the alphabet array
     * @param c character to be found
     * @return the given characters index from the alphabet array
     */
    public int findCharIndexFromAlphabet(char c, char[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (c == alphabet[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        CipherText cipherText = new CipherText("ABBA",2, true);

        for (int i = 0; i < cipherText.alphabet.length; i++) {
            System.out.print(cipherText.alphabet[i]);
        }

        System.out.println();
        char[] randomAlphabet = cipherText.createRandomAlphabet();

        for (int i = 0; i < randomAlphabet.length; i++) {
            System.out.print(randomAlphabet[i]);
        }

    }
}
