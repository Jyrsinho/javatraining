package AlgorithmsTwo.Aikataulu;

import java.util.*;

/**
 * Aikataulutus saa parserilta ArrayListin kayttajista ja heidan toiveajoistaan.
 * Aikataulutus palauttaa kayttajien aikatoiveista taulukon, jossa kullekin kayttajalle on annettu aika.
 * Ensimmainen indeksi on 0
 */
public class AikaTaulutus {

    private final int asiakkaita;
    // nollaindeksi jatetaan tyhjaksi. Ajaksi jota kukaan ei halua
    private final int aikoja;
    private boolean [][] bpGraph;


    /**
     * Luodaan uusi aikataulutus Arraylistista joka sisaltaa kayttajat ja heidan aikatoiveensa
     * matriisissa
     * @param kayttajat kaksiulotteinen taulukko kayttajista ja heidan toiveistaan
     */
    public AikaTaulutus(ArrayList<ArrayList<Integer>> kayttajat) {
        this.asiakkaita = kayttajat.size();
        int maksimiAika = kayttajat.stream()
                .flatMap(List::stream)
                .max(Integer::compareTo)
                .orElse(0);
        this.aikoja= maksimiAika + 1;

        MatrixBuilder matrixBuilder = new MatrixBuilder(asiakkaita, aikoja);
        this.bpGraph = matrixBuilder.luoAdjMatrix(kayttajat);

    }


}
