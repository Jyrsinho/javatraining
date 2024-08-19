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
    public String encrypt() {
        StringBuilder cryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            int charactersIndex = findCharIndexFromAlphabet(plainText.charAt(i));
            cryptedText.append(alphabet[charactersIndex+1]);
        }

        return cryptedText.toString();
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
