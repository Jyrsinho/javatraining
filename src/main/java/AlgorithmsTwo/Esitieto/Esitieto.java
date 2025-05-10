package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class Esitieto {

    public void kasitteleSyote(String syote) {
        // syote -> parser -> kurssilistat kukin kurssilista on kasa kurssiolioita
        Parser parser = new Parser();
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote(syote);
        for (KurssiLista kurssiLista: kurssilistat) {

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
                
                """;

        Esitieto esitieto = new Esitieto();
        esitieto.kasitteleSyote(testiSyote);
    }
}
