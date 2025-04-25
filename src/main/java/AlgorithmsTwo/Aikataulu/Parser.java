package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Scanner;

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
        String[] aikaTaulutusSyotteet = jaaAikaTaulutuksiin(syote);
        luoAikaTaulutukset(aikaTaulutusSyotteet);
    }

    private String siivoaSyotteestaHanta(String syote) {
        String regex =" (0\\s*0\\s* 0)";
        String[] osat = syote.split(regex);
        return osat[0];

    }

    private String[] jaaAikaTaulutuksiin(String syote) {
       // jaetaan kahden nollan kohdalta
        String regex = "(0\\s*0)";
        String[] osat = syote.split(regex);
        return osat;
    }

    private void luoAikaTaulutukset(String[] osat) {
        for (int i = 0; i < osat.length; i++) {
            luoAikaTaulutus(osat[i]);
        }
    }

    private void luoAikaTaulutus(String aikataulutuksenSyote){

        ArrayList<Kayttaja> kayttajat = new ArrayList<>();
        //kayttajan syote vaihtuu aina 0 kohdalla
        String[] kayttajienToiveet = aikataulutuksenSyote.split("0");
        for (int i = 0; i < kayttajienToiveet.length; i++) {
           Kayttaja uusiKayttaja = luoUusiKayttajaSyotteesta(i + 1,kayttajienToiveet[i]);
           kayttajat.add(uusiKayttaja);
        }

        AikaTaulutus uusiAikataulutus = new AikaTaulutus(kayttajat);
        aikataulutukset.add(uusiAikataulutus);
    }


    private Kayttaja luoUusiKayttajaSyotteesta(int kayttajanID, String kayttajanSyote) {
        ArrayList<Integer> kayttajanToiveet = new ArrayList<>();
        Scanner scanner = new Scanner(kayttajanSyote);
        while (scanner.hasNext()) {
            int toive = scanner.nextInt();

            kayttajanToiveet.add(toive);
        }
        return new Kayttaja(kayttajanID, kayttajanToiveet);
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
