package AlgorithmsTwo.UnionFind;

public class UnionFind {

    private int[] parent;
    private int[] rank;
    int n;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        this.n = n;
        //aluksi jokainen solmu on itsensä vanhempi
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * Palauttaa edustajan annetun solmun setille
     */
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /**
     * Yhdistää kaksi solmua samaan settiin
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        // etsitään solmun x edustaja
        int xEdustaja = find(x);
        // etsitään solmun y edustaja
        int yEdustaja = find(y);
        //tarkistetaan etteivät solmut ole jo samassa setissä
        if (xEdustaja == yEdustaja) {
            return;
        }
        if (rank[xEdustaja] < rank[yEdustaja]) {
            parent[xEdustaja] = yEdustaja;
            rank[yEdustaja] += rank[xEdustaja];
        }else {
            parent[yEdustaja] = xEdustaja;
            rank[xEdustaja] += rank[yEdustaja];
        }

    }

    public static void main(String[] args) {
        int n = 5;
        UnionFind uf = new UnionFind(n);
        uf.union(0,1);
        uf.union(2,3);
        uf.union(0,4);

        for (int i = 0; i < n; i++) {
            System.out.println("Element " + i
                    + ": Representative = "
                    + uf.find(i));
        }

    }
}
