package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

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
    }



}
