package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class Parser {
    ArrayList<AikaTaulutus> aikataulutukset;

    public Parser() {
        this.aikataulutukset = new ArrayList<>();
    }

    //TODO: Refaktoroidaan tämä niin, että käyttää pelkkiä RegExpejä.
    // nollat eivät ole tarpeellisia joten voidaan käyttää array.split metodia
    // kolme nollaa jakaa syötteen ja siihen kuulumattoman osan
    // kaksi nollaa jakaa Aikataulutukset
    // yksi nolla jakaaa yksittäiset käyttäjät

    /**
     * Luodaan syotteesta ArrayList Tapauksista
     */
    public void kasitteleSyote(String syote) {
        syote = siivoaSyotteestaHanta(syote);
        String regexp = "(0\\s*0\\s*0)";
        String[] aikaTaulutusSyotteet = syote.split("\\s+");

    }

    private void siivoaSyotteestaHanta(final String syote) {
        String re
        syote.split()
    }

    public void tulostaAikataulutukset() {
        System.out.println("Tulostetaan aikataulutukset");
        for (AikaTaulutus aikaTaulutus: aikataulutukset){
            System.out.println("AikaTaulutus: ");
            System.out.println(aikaTaulutus.toString());
        }
    }

    public ArrayList<AikaTaulutus> annaTapaukset() {
        return aikataulutukset;

    }
}
