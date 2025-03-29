package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;

public class Perija {
    private final String nimi;
    private final boolean elossa;
    private final int id;
    private final ArrayList<Perija> lapset;
    int perintoaSaatu;


    public Perija(String nimi, boolean elossa, int id) {
        this.nimi = nimi;
        this.elossa = elossa;
        this.id = id;
        this.lapset = new ArrayList<Perija>();
        this.perintoaSaatu = 0;

    }

    public void vastaanOtaPerinto(int perinto){
        perintoaSaatu += perinto;
    }

    public void lisaaLapsi(Perija lapsi) {
        lapset.add(lapsi);
    }


    /**
     * Tekee listan Perijan omista perijoista, jotka voivat peria hänet. Tähän lasketaan vainajan elossa olevat lapset
     * sekä vainajan kuolleet lapset, joilla on elossa olevia lapsia jne.
     */
    public ArrayList<Perija> perivatJalkelaiset() {
        ArrayList<Perija> laillisetPerijat = new ArrayList<>();
        for (Perija lapsi: this.lapset) {
            if (lapsi.onValidiPerija()){
                laillisetPerijat.add(lapsi);
            }
        }
        return laillisetPerijat;
    }

    /**
     * Palauttaa true jos Perija on itse elossa tai hänellä on eläviä jälkeläisiä
     */
    public boolean onValidiPerija() {

        if (this.onElossa()) {
            return true;
        }
        for (Perija lapsi: this.lapset) {
            if (lapsi.onValidiPerija()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Jos vainaja on elossa hän perii annetun summan muussa tapauksessa hänen jälkeläisensä alenevassa polvessa
     * perivät hänen osuutensa
     * @param perintoSumma summa, joka peritään
     * @return perinnonMaara palauttaa jaljella olevan perinnonMaaran
     */
    public int peri(int perinnonMaara,ArrayList <Perija> perijat, int perintoSumma) {
            // jos perija on elossa, annetaan perinto perijalle itselleen
        if (this.onElossa()) {
            perintoaSaatu += perintoSumma;
            perinnonMaara -= perintoSumma;
            // lisataan Perija perijat listaan, jos hanta ei siella viela ole
            if (!perijat.contains(this)) {
                perijat.add(this);
            }
            // jos perija on kuollut ja hanelle on jalkelaisia jaetaan hanen perinto-osuutensa hanen perijoidensa kesken
        }else if (!perivatJalkelaiset().isEmpty()) {
            perintoSumma = perintoSumma / this.perivatJalkelaiset().size();
            for (Perija lapsi: this.perivatJalkelaiset()) {
                perinnonMaara = lapsi.peri(perinnonMaara, perijat, perintoSumma);
            }
        }
        return perinnonMaara;
    }



    public String getNimi() {
        return nimi;
    }

    public int getId() {
        return id;
    }

    public boolean onElossa() {
        return elossa;
    }

    public int getPerintoaSaatu() {
        return perintoaSaatu;
    }

    public ArrayList<Perija> getLapset() {
        return lapset;
    }

}
