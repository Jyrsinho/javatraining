package AlgorithmsTwo.Aikataulu;

import java.util.*;

/**
 * Aikataulutus palauttaa kayttajien aikatoiveista taulukon, jossa kullekin kayttajalle on annettu aika.
 * Ensimmainen indeksi on 0
 */
public class AikaTaulutus {
    static final int NIL = 0;
    static final int INF = Integer.MAX_VALUE;

    private final int asiakkaidenMaara;
    private final int aikojenMaara;
    private ArrayList<ArrayList<Integer>> kayttajienToiveet;

    private int[] uParit;
    private int[] vParit;
    private int[] etaisyydet;

    private int matsienMaara;

    /**
     * Luodaan uusi aikataulutus Arraylistista joka sisaltaa kayttajat ja heidan aikatoiveensa
     * matriisissa
     * @param kayttajat kaksiulotteinen taulukko kayttajista ja heidan toiveistaan
     */
    public AikaTaulutus(ArrayList<ArrayList<Integer>> kayttajat) {
        matsienMaara = 0;
        asiakkaidenMaara = kayttajat.size();
        aikojenMaara = 1000;

        kayttajienToiveet = kayttajat;

        uParit = new int[asiakkaidenMaara + 1 ];
        vParit = new int[aikojenMaara + 1 ];
        etaisyydet = new int[asiakkaidenMaara + 1 ];

        Arrays.fill(uParit, NIL);
        Arrays.fill(vParit, NIL);

        for (ArrayList<Integer> toiveet : kayttajienToiveet) {
            Collections.sort(toiveet);
        }
    }


    /**
     * Palauttaa taulukon
     *
     */
    public void jaaAikataulu() {
        while (bfs()) {
            for(int asiakas = 1; asiakas <= asiakkaidenMaara; asiakas++)

                if (uParit[asiakas] == NIL && dfs(asiakas))
                    matsienMaara++;
        }
    }

    private boolean bfs() {

        Queue<Integer> jono = new LinkedList<>();

        for(int asiakas = 1; asiakas <= asiakkaidenMaara; asiakas++)
        {
            if (uParit[asiakas] == NIL)
            {
                etaisyydet[asiakas] = 0;
                jono.add(asiakas);
            }

            else
                etaisyydet[asiakas] = INF;
        }
       etaisyydet[NIL] = INF;

        while (!jono.isEmpty())
        {
            int asiakas = jono.poll();
            if (etaisyydet[asiakas] < etaisyydet[NIL])
            {
                for(int i : kayttajienToiveet.get(asiakas - 1))
                {
                    int v = i;
                    if (etaisyydet[vParit[v]] == INF)
                    {
                        etaisyydet[vParit[v]] = etaisyydet[asiakas] + 1;
                        jono.add(vParit[v]);
                    }
                }
            }
        }
        return (etaisyydet[NIL] != INF);
    }


    boolean dfs(int asiakas)
    {
        if (asiakas != NIL)
        {
            for(int i : kayttajienToiveet.get(asiakas - 1)) {
                int aika = i;
                if (etaisyydet[vParit[aika]] == etaisyydet[asiakas] + 1)
                {
                    if (dfs(vParit[aika]) == true)
                    {
                        vParit[aika] = asiakas;
                        uParit[asiakas] = aika;
                        return true;
                    }
                }
            }
            etaisyydet[asiakas] = INF;
            return false;
        }
        return true;
    }


    public void tulostaAjat() {
        for (int i = 0; i <uParit.length; i++) {
            System.out.println(uParit[i]);
        }
    }

    public int[] annaAsiakkaidenAjat() {
        return uParit;
    }

}
