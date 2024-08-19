package CipherText;

public class CipherText {

    private char[] alphabet = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };


    private final String plainText;

    /**
     * Constructor
     * @param plainText plaintext
     */
    public CipherText(String plainText) {
        this.plainText = plainText;
    }


    public String getPlainText() {
        return plainText;
    }


    /**
     * Encrypts the plaintext attribute of the CipherText object
     * @return encrypted version of the plaintext
     */
    public String encrypt(int steps, boolean reversed) {
        StringBuilder cryptedText = new StringBuilder();
        int factor;                                     //determines whether we move forwards or backwards in alphabet array
        if (reversed) factor = -1;
        else factor = 1;

        for (int i = 0; i < plainText.length(); i++) {
            int charactersIndex = findCharIndexFromAlphabet(plainText.charAt(i));
            cryptedText.append(findCharacterToBeAppended(charactersIndex,factor,steps));
        }

        return cryptedText.toString();
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
