package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    Scanner scanner;

    public Parser() {
    }

    /**
     * Lukee kayttajan syotteen ja palauttaa sita vastaavan listan Kurssilista- objekteja
     * @return {ArrayList<Kurssilista>} kaikki kayttajan syotteen Kurssilistat
     */
    public ArrayList<KurssiLista> kasitteleSyote() {
        this.scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String seuraava = scanner.next();
        }
        return new ArrayList<KurssiLista>();
    }
}