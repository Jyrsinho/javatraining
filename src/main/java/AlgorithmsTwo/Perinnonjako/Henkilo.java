package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;

public class Henkilo {
    private String nimi;
    private boolean elossa;
    private int id;
    private ArrayList<Henkilo> lapset;


    public Henkilo(String nimi, boolean elossa, int id) {
        this.nimi = nimi;
        this.elossa = elossa;
        this.id = id;
    }

    public void lisaaLapsi(Henkilo lapsi) {
        lapset.add(lapsi);
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

}
