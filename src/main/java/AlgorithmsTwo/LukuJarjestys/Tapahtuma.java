package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;

/**
 * Paivamaara annetaan muodossa dd.mm.yyyy
 */
public class Tapahtuma {
    int ensimmainenAlkavaTunti;
    int viimeinenAlkavaTunti;
    LocalDate paivamaara;
    String nimi;

    public Tapahtuma(int ensimmainenAlkavaTunti, int viimeinenAlkavaTunti, LocalDate paivamaara, String nimi) {
        this.ensimmainenAlkavaTunti = ensimmainenAlkavaTunti;
        this.viimeinenAlkavaTunti = viimeinenAlkavaTunti;
        this.paivamaara = paivamaara;
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getEnsimmainenAlkavaTunti() {
        return ensimmainenAlkavaTunti;
    }

    public int getViimeinenAlkavaTunti() {
        return viimeinenAlkavaTunti;
    }

    public LocalDate getPaivamaara() {
        return paivamaara;
    }

    public void tulosta() {
        System.out.println(ensimmainenAlkavaTunti);
        System.out.println(viimeinenAlkavaTunti);
        System.out.println(paivamaara);
        System.out.println(nimi);
    }
}
