package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;

public class Esitieto {

    public void kasitteleSyote(String syote) {
        Parser parser = new Parser();
        parser.kasitteleSyote(syote);

        ArrayList<KurssiLista> suorituslistat = parser.getKurssiListat();
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
