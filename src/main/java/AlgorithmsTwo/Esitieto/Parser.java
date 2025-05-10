package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {


    public Parser() {
    }

    public ArrayList<KurssiLista> kasitteleSyote(String syote) {
        String syoteIlmanHantaa = poistaHanta(syote);
        String[] kurssilistaSyotteet = jaaOsiin(syoteIlmanHantaa);

        ArrayList<KurssiLista> kurssilistat = luoKurssiListat(kurssilistaSyotteet);

        return kurssilistat;
    }

    private String poistaHanta(String syote) {
        String regex = ("\\s*0\\s*0\\s*0");
        return syote.split(regex)[0];
    }

    private String[] jaaOsiin(String syote) {
       String regex = ("\\s*0\\s*0");
       return syote.split(regex);
    }

    private ArrayList<KurssiLista> luoKurssiListat(String[] kurssilistaSyotteet) {
        ArrayList<KurssiLista> kurssilistat = new ArrayList<>();
        for (String kurssilistaSyote: kurssilistaSyotteet) {
            KurssiLista uusiKurssilista = luoKurssiLista(kurssilistaSyote);
            kurssilistat.add(uusiKurssilista);
        }
        return kurssilistat;
    }

    /**
     * syote on muotoa id, nimi, periodi: ennakkotiedot
     * 1 Sähly 1: 7 3 8 0
     * @param syote
     * @return
     */
    private KurssiLista luoKurssiLista(String syote) {
        KurssiLista uusiKurssiLista = new KurssiLista();

        String[] kurssit = syote.split("\\s0" );

        for (String kurssiSyote : kurssit) {
            Kurssi uusiKurssi = luoKurssiSyotteesta(kurssiSyote);
            uusiKurssiLista.lisaaKurssi(uusiKurssi);
        }
        return uusiKurssiLista;
    }

    /**
     * Saa syotteena kurssin tiedot muodossa:
     * id, nimi, periodi: ennakkotiedot, 0
     * Parsii syotteesta kurssiolion ja palauttaa sen
     * @param syote {String}
     * @return {Kurssi}
     */
    private Kurssi luoKurssiSyotteesta(String syote) {
        String ennakkotiedotSyote;
        int id;
        String nimi;
        int periodi;
        ArrayList<Integer> ennakkotiedot = new ArrayList<>();

        String[] osat = syote.split(":");
        String idNimiJaPeriodi = osat[0];
        if (osat.length == 2) {
            ennakkotiedotSyote = osat[1];
        } else {
            ennakkotiedotSyote = "";
        }

        Scanner scanner = new Scanner(idNimiJaPeriodi);
        id = scanner.nextInt();
        nimi = scanner.next();
        periodi = scanner.nextInt();

        Scanner ennakkotiedotScanner = new Scanner(ennakkotiedotSyote);
        while (ennakkotiedotScanner.hasNext()){
            int ennakkotieto = ennakkotiedotScanner.nextInt();
            if (ennakkotieto != 0) {
                ennakkotiedot.add(ennakkotieto);
            }
        }
        return new Kurssi(id, nimi, periodi, ennakkotiedot);
    }

}
