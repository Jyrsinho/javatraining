package AlgorithmsTwo.Aikataulu;

import java.util.ArrayList;

public class MatrixBuilder {

    private int u;
    private int v;

    public MatrixBuilder(int uVertices, int vVertices) {
       this.u = uVertices;
       this.v = vVertices;
    }

    public boolean[][] luoAdjMatrix(ArrayList<ArrayList<Integer>> kayttajat) {
        boolean[][] bpMatrix = new boolean[u][v];

        for (int kayttaja = 0; kayttaja < kayttajat.size(); kayttaja++) {
            for (int j = 0; j < kayttajat.get(kayttaja).size(); j++) {
                int kayttajantoive = kayttajat.get(kayttaja).get(j);
                bpMatrix[kayttaja][kayttajantoive] = true;
            }
        }

        return bpMatrix;
    }


    public void printBPMatrix(boolean[][] matrix) {
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
