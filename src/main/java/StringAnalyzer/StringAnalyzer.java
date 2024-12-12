package StringAnalyzer;

public class StringAnalyzer {


    //Kirjoita ohjelma, joka laskee montako sanaa (=välilyöntien erottamat merkkijonot) on merkkijonossa.
    // Älä käytä valmiita merkkijonojen metodeja, vaan käsittele suoraan yksittäisiä merkkejä.
    // Huomioi tapaukset, jossa välilyöntejä on merkkijonon alussa tai lopussa tai jos välilyöntejä on useampi
    // perättäin.

    /**
     * Counts how many words there are in a given string
     * @param string to be analyzed
     * @return how many words there are in a given string
     */
    public static int wordsInString (String string) {
        if (string.isEmpty()) {
            return 0;
        }

        int count = 0;
        boolean isWord = false;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                isWord = true;
            }
            if (string.charAt(i) == ' ' && isWord) {
                count++;
                isWord = false;
            }
        }
        if (isWord) {
            count++;
        }


        return count;

    }


    public static void main(String[] args) {
        String testString = "Kissa ui";
        System.out.printf("Merkkijonossa -"+ testString + "- on " + wordsInString(testString) +" sanaa.");
        System.out.println();

        testString = "      Kissa ui    kovaa";
        System.out.printf("Merkkijonossa -"+ testString + "- on " + wordsInString(testString) +" merkkiä.");
        System.out.println();

        testString = "Kissa ui kovaa       ";
        System.out.printf("Merkkijonossa -"+ testString + "- on " + wordsInString(testString) +" merkkiä.");
    }
}
