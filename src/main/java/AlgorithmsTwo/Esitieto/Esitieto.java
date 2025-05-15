package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class Esitieto {

    public void kasitteleSyote() {
        Parser parser = new Parser();
        // parser kasitteleSyote avaa scannerin, lukee syotteen ja puskee ulos tarvittavat tietorakenteet
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote();
        for (KurssiLista kurssiLista: kurssilistat) {
            kurssiLista.analysoiKurssilista();
            kurssiLista.tulosta();
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Esitieto esitieto = new Esitieto();
        esitieto.kasitteleSyote();

    }
}
