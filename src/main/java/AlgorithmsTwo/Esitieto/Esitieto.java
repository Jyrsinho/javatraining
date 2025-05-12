package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class Esitieto {

    public void kasitteleSyote(String syote) {
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote(syote);
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

        Esitieto esitieto = new Esitieto();
        esitieto.kasitteleSyote(testiSyote);
    }
}
