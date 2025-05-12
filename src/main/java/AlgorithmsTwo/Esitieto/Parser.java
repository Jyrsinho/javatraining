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
        String regex = ("\\s+0\\s+0\\s+0");
        return syote.split(regex)[0];
    }

    private String[] jaaOsiin(String syote) {
       String regex = ("\\s+0\\s+0");
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
        //lisataan kurssilistaan dummy nollaindeksiin jotta voidaan kayttaa ykkosesta indekseja
        uusiKurssiLista.lisaaKurssi(new Kurssi(0,"dummy", 0, new ArrayList<>()));
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
        int id;
        String nimi;
        String periodi;
        ArrayList<Integer> ennakkotiedot = new ArrayList<>();

        Scanner scanner = new Scanner(syote);
        id = scanner.nextInt();
        nimi = scanner.next();
        periodi = scanner.next();
        periodi = periodi.replaceAll(":", "");
        int periodiInt = Integer.parseInt(periodi);

        while (scanner.hasNext()){
            String next = scanner.next();
            try{
                int ennakkotieto = Integer.parseInt(next);
                if (ennakkotieto != 0) {
                    ennakkotiedot.add(ennakkotieto);
                }
            }catch (NumberFormatException e){
                continue;
            }

        }

        return new Kurssi(id, nimi, periodiInt, ennakkotiedot);
    }



}
