package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class Esitieto {

    public void kasitteleSyote(String syote) {
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
        /*
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            sb.append(nextLine);
            sb.append("\n");
        }
         */

        String testiSyote = """
                1 Sähly 1: 7 3 8 0
                2 Pitsinnypläys 4: 5 4 8 6 1 10
                7 3 0
                3 Ruoanlaitto 1: 7 8 0
                4 Pakohuone 1: 7 5 1 8 3 0
                5 Roolipeli 2: 8 7 3 1 0
                6 Suunnistus 3: 4 10 8 5 1 3 7 0
                7 Hikijumppa 2: 8 0
                8 Elokuvakerho 3: 0
                9 Auringonotto 1: 8 3 6 10 5 2 4
                1 7 0
                10 Rumpujen_soitto 3: 3 1 4 7 8
                5 0 0
                1 Lähdekritiikki 1: 0 2 Etiikka 2: 6 5 0
                3 Tutkimusmenetelmät 3: 2 8 4 5 0 4 Tietosuoja 4: 0
                5 Filosofia 1: 7 6 0 6 Äidinkieli 2
                :
                0 7 Diskurssianalyysi 3: 2 6 1 0 8 Tilastotiede 4: 0
                0
                0
                """;

        String testiSyote2 = """
                1 Ainoa_kurssi 3 : 0
                0
                1 Ainoa_kurssi 3 : 1 0
                0
                1 EkaKurssi 3 : 0
                2 TokaKurssi 2 : 2 0
                0
                1 KurssiA 3 : 0
                2 KurssiB 3 : 1 0
                0
                1 Algoritmit 4: 11 14 15 12 7 5 3 0
                2 Biologia 1: 0
                3 C-kurssi 3: 0
                4 Diskurssianalyysi 3: 10 14 6 1 15 7 0
                5 Erikoiskurssi: 4: 8 0
                6 Fiilistelykurssi 1: 2 3 0
                7 Graduseminaari 3: 3 11 2 15 14 0
                8 Harjoitustyö 1: 0
                9 Itsenäinen_projekti 3: 2 1 14 4 3 10 0
                10 Jatkokurssi 3: 11 5 8 13 12 0
                11 Kokeelliset_menetelmät 3: 3 6 0
                12 Luonnontiede 3: 6 2 14 3 0
                13 Menetelmäopinnot 1: 11 2 7 14 6 15 0
                14 Numismatiikka 4: 2 6 0
                15 Ohjelmistotuotanto 4: 14 11 12 0
                0
                0
                
                0
                """;

        String testisyote3 = """
                1 Algoritmit 4: 11 14 15 12 7 5 3 0
                2 Biologia 1: 0
                3 C-kurssi 3: 0
                4 Diskurssianalyysi 3: 10 14 6 1 15 7 0
                5 Erikoiskurssi: 4: 8 0
                6 Fiilistelykurssi 1: 2 3 0
                7 Graduseminaari 3: 3 11 2 15 14 0
                8 Harjoitustyö 1: 0
                9 Itsenäinen_projekti 3: 2 1 14 4 3 10 0
                10 Jatkokurssi 3: 11 5 8 13 12 0
                11 Kokeelliset_menetelmät 3: 3 6 0
                12 Luonnontiede 3: 6 4 2 14 3 0
                13 Menetelmäopinnot 1: 11 2 7 14 6 15 0
                14 Numismatiikka 4: 2 6 0
                15 Ohjelmistotuotanto 4: 14 11 12 0
                0
                0
                
                0
                """;

        Esitieto esitieto = new Esitieto();
        esitieto.kasitteleSyote(testiSyote);
        System.out.println();
        esitieto.kasitteleSyote(testiSyote2);
        System.out.println();
        esitieto.kasitteleSyote(testisyote3);

        //TODO syote on liian pitka sita ei voi lukea ensin kokonaisena
    }
}
