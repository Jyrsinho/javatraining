package AlgorithmsTwo.LukuJarjestys;

import java.time.LocalDate;

/**
 * Paivamaara annetaan muodossa dd.mm.yyyy
 */
public class Tapahtuma {
    int alkuaika;
    int loppuaika;
    LocalDate paivamaara;
    String nimi;

    public Tapahtuma(int alkuaika, int loppuaika, LocalDate paivamaara, String nimi) {
        this.alkuaika = alkuaika;
        this.loppuaika = loppuaika;
        this.paivamaara = paivamaara;
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getAlkuaika() {
        return alkuaika;
    }

    public int getLoppuaika() {
        return loppuaika;
    }

    public LocalDate getPaivamaara() {
        return paivamaara;
    }

    public void tulosta() {
        System.out.println(alkuaika);
        System.out.println(loppuaika);
        System.out.println(paivamaara);
        System.out.println(nimi);
    }
}
