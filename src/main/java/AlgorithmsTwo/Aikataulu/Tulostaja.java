package AlgorithmsTwo.Aikataulu;

import java.io.PrintStream;

public class Tulostaja {

    public void tulostaAikataulutus(int [] aikataulutus) {
        PrintStream out = System.out;
        for (int i = 0; i < aikataulutus.length; i++) {
            out.print("    ");
            out.print(aikataulutus[i]);
        }
        out.println();
    }
}
