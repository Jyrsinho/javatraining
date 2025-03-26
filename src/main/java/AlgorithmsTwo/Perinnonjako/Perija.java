package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;

public class Perija {
    private String nimi;
    private boolean elossa;
    private int id;
    private ArrayList<Perija> lapset;
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
     * Palauttaa true jos Perija on itse elossa tai hänellä on eläviä jälkeläisiä
     */
    public boolean onLaillinenPerija() {

        if (this.onElossa()) {
            return true;
        }

        for (Perija lapsi: this.lapset) {
            if (lapsi.onLaillinenPerija()) {
                return true;
            }
        }

        return false;

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
