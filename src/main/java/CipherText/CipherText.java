package CipherText;

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
        char[] randomAlphabet = new char[alphabet.length];

        for (int i = 0; i < alphabet.length; i++) {
            randomAlphabet[i] = alphabet[i];
        }

        return randomAlphabet;
    }


    /**
     * Encrypts the plaintext attribute of the CipherText object
     * @return encrypted version of the plaintext
     */
    public String encrypt() {
        StringBuilder cryptedText = new StringBuilder();
        int factor;                                     //determines whether we move forwards or backwards in alphabet array
        if (reversed) factor = -1;
        else factor = 1;

        for (int i = 0; i < plainText.length(); i++) {
            int charactersIndex = findCharIndexFromAlphabet(plainText.charAt(i));
            cryptedText.append(findCharacterToBeAppended(charactersIndex,factor,steps));
        }

        this.cryptedText = cryptedText.toString();
        return cryptedText.toString();
    }


    public String decrypt() {
        StringBuilder decryptedText = new StringBuilder();
        int factor;
        if (reversed) factor = 1;
        else factor = -1;

        for (int i = 0; i < cryptedText.length(); i++) {
            int charactersIndex = findCharIndexFromAlphabet(cryptedText.charAt(i));
            decryptedText.append(findCharacterToBeAppended(charactersIndex,factor,steps));
        }

        return decryptedText.toString();
    }




    public char findCharacterToBeAppended(int oCharacterIndex, int factor, int steps) {
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
    public int findCharIndexFromAlphabet(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (c == alphabet[i]) {
                return i;
            }
        }
        return -1;
    }
}
