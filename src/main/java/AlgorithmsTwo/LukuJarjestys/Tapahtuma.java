package AlgorithmsTwo.LukuJarjestys;

public class Tapahtuma {
    int alkuaika;
    int loppuaika;
    String paivamaara;
    String nimi;

    public Tapahtuma(int alkuaika, int loppuaika, String paivamaara, String nimi) {
        this.alkuaika = alkuaika;
        this.loppuaika = loppuaika;
        this.paivamaara = paivamaara;
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void tulosta() {
        System.out.println(alkuaika);
        System.out.println(loppuaika);
        System.out.println(paivamaara);
        System.out.println(nimi);
    }
}
