package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.*;

public class Esitieto {

    public void kasitteleSyote() {
        Parser parser = new Parser();
        // parser kasitteleSyote avaa scannerin, lukee syotteen ja puskee ulos tarvittavat tietorakenteet
        ArrayList<KurssiLista> kurssilistat = parser.kasitteleSyote();
        for (KurssiLista kurssiLista: kurssilistat) {
            kurssiLista.analysoiKurssilista();
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Esitieto esitieto = new Esitieto();
        esitieto.kasitteleSyote();


    }

    public static class Kurssi implements Comparable<Kurssi>{
        private int id;
        private String nimi;
        private int periodi;
        private ArrayList<Integer> ennakkotiedot;

        public Kurssi(int id, String nimi, int periodi, ArrayList<Integer> ennakkotiedot) {
            this.id = id;
            this.nimi = nimi;
            this.periodi = periodi;
            this.ennakkotiedot = ennakkotiedot;
        }

        public Kurssi(int id, String nimi, int periodi, int[] testiennakkotiedot) {
            this.ennakkotiedot = new ArrayList<>();
            this.id = id;
            this.nimi = nimi;
            this.periodi = periodi;
            for (int i = 0; i < testiennakkotiedot.length; i++) {
                this.ennakkotiedot.add(testiennakkotiedot[i]);
            }
        }

        public void setPeriodi(int periodi) {
            this.periodi = periodi;
        }

        public int getId() {
            return id;
        }

        public String getNimi() {
            return nimi;
        }

        public ArrayList<Integer> getEnnakkotiedot() {
            return ennakkotiedot;
        }

        public int getPeriodi() {
            return periodi;
        }

        public void tulosta() {
            System.out.printf("%d: %d %s", periodi, id, nimi);
            System.out.println();
        }

        public void tulostaKaikki() {
            System.out.printf("%d: %d %s", periodi, id, nimi);
            System.out.print("  -   ");
            System.out.print("ennakkotiedot ");
            for (Integer integer : ennakkotiedot) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        public void tulostaIdJaNimi() {
            System.out.printf("%d %s\n", id, nimi);
        }

        @Override
        public int compareTo(Kurssi o) {
            return this.periodi - o.periodi;
        }


    }

    public static class KurssiLista {
        private ArrayList<Kurssi> kurssit;
        int V; // Solmujen maara
        boolean[] vierailtu;
        boolean[] rekursioPino;
        boolean onSilmukka;
        Stack<Kurssi> vastaus;
        Stack<Kurssi> silmukka;
        Stack<Integer> reitti;
        Map<Integer, Integer> periodimuisti = new HashMap<>();
        Set<Integer> kaynnissa = new HashSet<>();

        public KurssiLista() {
            kurssit = new ArrayList<>();
            vastaus = new Stack<>();
            silmukka = new Stack<>();
        }

        public void lisaaKurssi(Kurssi kurssi) {
            kurssit.add(kurssi);
        }

        public void analysoiKurssilista() {
            V = kurssit.size();
            onSilmukka = sisaltaaSilmukan();

            tulosta();

        }

        /**
         * Kaydaan jokainen graafin node lapi ja kutsutaan niille rekursiivista metodia, joka
         * tarkistaa onko kyseinen node osa syklia
         * @return true jos graafi sisaltaa silmukan, false jos ei
         */
        private boolean sisaltaaSilmukan() {
            vierailtu = new boolean[V];
            rekursioPino = new boolean[V];

            // aloitetaan ykkosesta koska 0 indeksissa on dummy
            for (int i = 1; i < kurssit.size(); i++) {
                reitti = new Stack<>();
                if (!vierailtu[i] && jarjestaGraafiHelper(i) < 0) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Päivittää oman suoritusajankohtansa ennaakotietojensa mukaan ja palauttaa sitten oman suoritusaikansa
         * @param kurssiID kurssi jossa vieraillaan
         * @return vierailtavan kurssin suoritusajankohta
         */
        private int jarjestaGraafiHelper(int kurssiID) {

            // Memoisaatio: jos jo laskettu, palauta suoraan
            if (periodimuisti.containsKey(kurssiID)) {
                return periodimuisti.get(kurssiID);
            }

            // Silmukan tarkistus: jos jo tällä rekursioreitillä → sykli
            if (kaynnissa.contains(kurssiID)) {
                // Tallennetaan silmukka tulostusta varten
                silmukka.clear();
                boolean lisaa = false;
                for (int kurssiId : reitti) {
                    if (kurssiId == kurssiID) lisaa = true;
                    if (lisaa) silmukka.push(kurssit.get(kurssiId));
                }
                return -1; // Silmukka havaittu
            }

            // Aloita uusi vierailu
            kaynnissa.add(kurssiID);
            reitti.push(kurssiID);
            Kurssi kurssi = kurssit.get(kurssiID);
            int myohaisinEsitieto = 0;

            for (int esitietoID : kurssi.getEnnakkotiedot()) {
                int esitiedonPeriodi = jarjestaGraafiHelper(esitietoID);
                if (esitiedonPeriodi < 0) return -1;
                myohaisinEsitieto = Math.max(myohaisinEsitieto, esitiedonPeriodi);
            }

            // Lasketaan kurssin periodi
            int kurssinPeriodi = Util.laskeUusiperiodi(myohaisinEsitieto, kurssi.getPeriodi());
            kurssi.setPeriodi(kurssinPeriodi);
            periodimuisti.put(kurssiID, kurssinPeriodi); // Memoisaatio

            // Vastaukseen lisäys (suoritusjärjestys stackiin oikeassa järjestyksessä)
            Stack<Kurssi> pienemmat = new Stack<>();
            while (!vastaus.isEmpty() && vastaus.peek().getPeriodi() < kurssinPeriodi) {
                pienemmat.push(vastaus.pop());
            }
            vastaus.push(kurssi);
            while (!pienemmat.isEmpty()) {
                vastaus.push(pienemmat.pop());
            }

            // Rekursion jälkisiivous
            kaynnissa.remove(kurssiID);
            reitti.pop();
            return kurssinPeriodi;
        }



        public ArrayList<Kurssi> getKurssit() {
            return kurssit;
        }


        public int[] getSuoritusJarjestys() {
            int [] suoritusJarjestys = new int[V - 1];
            int index = 0;

            for (Kurssi kurssi: vastaus) {
                suoritusJarjestys[index] = kurssi.getId();
                index++;
            }

            return suoritusJarjestys;
        }


        //
        public void tulosta() {
            if (onSilmukka) {
                tulostaSilmukka();
            } else {
                tulostaSuoritusAjankohdat();
            }
        }

        public void tulostaEnnakkotiedoilla() {
            for (Kurssi kurssi: kurssit) {
                kurssi.tulostaKaikki();
            }
        }

        private void tulostaSilmukka() {
            //Tulosta Silmukka voi tulostaa silmukan suoraan rekursiopinosta
            PrintStream out = System.out;
            out.println("Silmukka:");
            for (Kurssi kurssi: silmukka) {
                kurssi.tulostaIdJaNimi();
            }
        }

        public boolean onSilmukka() {
            return onSilmukka;
        }



        private void tulostaSuoritusAjankohdat() {

            PrintStream out = System.out;
            out.println("Suoritusajankohdat:");

            while (!vastaus.isEmpty()) {
                Kurssi tulostettava = vastaus.pop();
                tulostettava.tulosta();
            }
        }

    }

    public static class Parser {
        Scanner scanner = new Scanner(System.in);

        public Parser() {
        }

        /**
         * Lukee kayttajan syotteen ja palauttaa sita vastaavan listan Kurssilista- objekteja
         * @return {ArrayList<Kurssilista>} kaikki kayttajan syotteen Kurssilistat
         */
        public ArrayList<KurssiLista> kasitteleSyote() {
            // 1 nolla lopettaa kurssin syotteen
            // 2 nolla lopettaa Kurssilistan syotteen
            // 3 nolla lopettaa koko syotteen
            // Kurssin syote tulee jarjestyksessa id nimi periodi : ennakkotiedot

            ArrayList<KurssiLista> kurssiListat = new ArrayList<>();
            KurssiLista kurssiLista = new KurssiLista();
            //lisataan jokaisen kurssiListaan dummy kurssi etta voidaan kasitella kursseja indeksista 1 lahtien
            kurssiLista.lisaaKurssi(new Kurssi(0, "dummy", 0, new ArrayList<>()));
            int nollaLaskuri = 0;
            ArrayList<String> kurssinTiedot = new ArrayList<>();

            while (scanner.hasNext()) {
                String seuraava = scanner.next();
                if (seuraava.equals("0")) {
                    nollaLaskuri++;
                } else {
                    nollaLaskuri = 0;
                }

                switch (nollaLaskuri) {
                    case 0:
                        if (!seuraava.equals(":")) {
                            kurssinTiedot.add(seuraava);
                        }
                        continue;
                    case 1:
                        Kurssi uusiKurssi = luoKurssiSyotteesta(kurssinTiedot);
                        kurssinTiedot = new ArrayList<>();
                        kurssiLista.lisaaKurssi(uusiKurssi);
                        continue;
                    case 2:
                        kurssiListat.add(kurssiLista);
                        kurssiLista = new KurssiLista();
                        kurssiLista.lisaaKurssi(new Kurssi(0, "dummy", 0, new ArrayList<>()));
                        continue;
                    default:
                        break;
                }
            }
            return kurssiListat;
        }

        private Kurssi luoKurssiSyotteesta(ArrayList<String> kurssinTiedot) {
            ArrayList<Integer> ennakkotiedot = new ArrayList<>();
            int id = Integer.parseInt(kurssinTiedot.getFirst());
            String nimi = kurssinTiedot.get(1);
            String periodi = kurssinTiedot.get(2);
            String siivottuperiodi = periodi.replaceAll(":", "");
            int periodiInteger = Integer.parseInt(siivottuperiodi);

            for (int i = 3; i < kurssinTiedot.size(); i++) {
                ennakkotiedot.add(Integer.parseInt(kurssinTiedot.get(i)));
            }

            return new Kurssi(id, nimi, periodiInteger, ennakkotiedot);
        }
    }

    public static class Util {

        public static int laskeUusiperiodi(int myohaisin, int kurssinPeriodi) {
            if (myohaisin % 4 >= kurssinPeriodi) {
                return myohaisin - myohaisin % 4 + 4 + kurssinPeriodi;
            }else {
                return myohaisin - myohaisin % 4 + kurssinPeriodi;
            }

        }
    }
}
