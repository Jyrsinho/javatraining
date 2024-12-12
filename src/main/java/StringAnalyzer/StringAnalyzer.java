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
    public int wordsInString (String string) {
        if (string.isEmpty()) {
            return 0;
        }

        int wordsInString = 1;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ' && string.charAt(i + 1) != ' ') {
                wordsInString++;
            }
        }

        return wordsInString;

    }

}
