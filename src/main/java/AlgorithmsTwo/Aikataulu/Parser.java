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
        syote = poistaRivinVaihdot(syote);
        syote = siivoaSyotteestaHanta(syote);
        String[] aikaTaulutusSyotteet = jaaAikaTaulutuksiin(syote);
        luoAikaTaulutukset(aikaTaulutusSyotteet);
    }

    private String poistaRivinVaihdot(String syote) {
        String regex = "\n";
        syote = syote.replaceAll(regex, " ");
        return syote;
    }

    private String siivoaSyotteestaHanta(String syote) {
        String regex ="(\\s+0\\s+0\\s+0)";
        String[] osat = syote.split(regex);
        return osat[0];

    }

    private String[] jaaAikaTaulutuksiin(String syote) {
       // jaetaan kahden nollan kohdalta
        String regex = "(\\s+0\\s+0)";
        String[] osat = syote.split(regex);

        return osat;
    }

    private void luoAikaTaulutukset(String[] osat) {
        for (int i = 0; i < osat.length; i++) {
            luoAikaTaulutus(osat[i]);
        }
    }

    private void luoAikaTaulutus(String aikataulutuksenSyote){

        ArrayList<ArrayList<Integer>> kayttajat = new ArrayList<>();
        //kayttajan syote vaihtuu aina 0 kohdalla
        String[] kayttajienToiveet = aikataulutuksenSyote.split("(\\s+0\\s+)");
        for (int i = 0; i < kayttajienToiveet.length; i++) {
            ArrayList<Integer> kayttajanToiveet = luoKayttajanLista(kayttajienToiveet[i]);
            kayttajat.add(kayttajanToiveet);
        }

        AikaTaulutus uusiAikataulutus = new AikaTaulutus(kayttajat);
        aikataulutukset.add(uusiAikataulutus);
    }


    private ArrayList<Integer> luoKayttajanLista (String kayttajanToiveet) {
        ArrayList<Integer> kayttajanToiveLista = new ArrayList<>();

        Scanner scanner = new Scanner(kayttajanToiveet);
        while (scanner.hasNextInt()) {
            int toive = scanner.nextInt();
            kayttajanToiveLista.add(toive);
        }

        return kayttajanToiveLista;
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
