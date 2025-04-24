package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    ArrayList<AikaTaulutus> aikataulutukset;

    public Parser() {
        this.aikataulutukset = new ArrayList<>();
    }

    /**
     * Luodaan syotteesta ArrayList Tapauksista
     */
    public void kasitteleSyote(String syote) {
        ArrayList<String> tapausSyotteet = erotteleTapaukset(syote);
        luoAikataulutukset(tapausSyotteet);
    }

    private ArrayList<String> erotteleTapaukset(String syote) {
        ArrayList<String> tapausSyotteet = new ArrayList<>();
        int nollienMaara =0 ;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(syote);

        while (scanner.hasNext()) {
            String merkki = scanner.next();
            if (!merkki.equals("0")) {
                sb.append(merkki);
                sb.append(" ");
                nollienMaara = 0;
            }
            if (merkki.equals("0")){
                nollienMaara++;
            }
            if (nollienMaara == 2) {
                tapausSyotteet.add(sb.toString());
                sb = new StringBuilder();
            }
            if (nollienMaara == 3) {
                break;
            }

        }
        return tapausSyotteet;
    }

    private void luoAikataulutukset(ArrayList<String> tapausMerkkijonot) {
       for (String merkkiJono : tapausMerkkijonot) {
           luoAikaTaulutus(merkkiJono);
       }
    }


    private void luoAikaTaulutus(String merkkiJono) {
        AikaTaulutus aikaTaulutus = new AikaTaulutus();
        Scanner scanner = new Scanner(merkkiJono);
        int kayttajanID = 1;
        ArrayList<String> kayttajanToiveet = new ArrayList<>();
        int nollienMaara = 0;

        while (scanner.hasNext()) {
            String merkki = scanner.next();
            if (merkki.equals("0")) {
                nollienMaara++;
                if (nollienMaara ==1) {
                    Kayttaja uusiKayttaja = new Kayttaja(kayttajanID, kayttajanToiveet);
                    aikaTaulutus.lisaaKayttaja(uusiKayttaja);
                    kayttajanID++;
                    kayttajanToiveet = new ArrayList<>();
                } else {
                    return;
                }
            }else {
                kayttajanToiveet.add(merkki);
            }
        }
        aikataulutukset.add(aikaTaulutus);
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
