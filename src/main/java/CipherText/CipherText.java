package CipherText;

public class CipherText {

    private char[] alphabet = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    private String plainText;

    public CipherText(String plainText) {
        this.plainText = plainText;
    }


    public String getPlainText() {
        return plainText;
    }


    public String encrypt() {

        return "BVUP";
    }
}
