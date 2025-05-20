package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static AlgorithmsTwo.Esitieto.Esitieto.Util.laskeUusiperiodi;


public class Esitieto {

    public void kasitteleSyote() {
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
        LinkedList<Integer> sykli;

        public KurssiLista() {
            kurssit = new ArrayList<>();
        }

        public void lisaaKurssi(Kurssi kurssi) {
            kurssit.add(kurssi);
        }

        public void analysoiKurssilista() {
            V = kurssit.size();
            onSilmukka = sisaltaaSilmukan();
            if (onSilmukka) {
                jarjestaSilmukka();
            }
            if (!onSilmukka) {
                kurssit.removeFirst();
                kurssit.sort(Kurssi::compareTo);
            }
        }

        /**
         * Kaydaan jokainen graafin node lapi ja kutsutaan niille rekursiivista metodia, joka
         * tarkistaa onko kyseinen node osa syklia
         * @return true jos graafi sisaltaa silmukan, false jos ei
         */
        private boolean sisaltaaSilmukan() {
            vierailtu = new boolean[V];
            rekursioPino = new boolean[V];

            for (int i = 0; i < kurssit.size(); i++) {
                if (!vierailtu[i] && sisaltaaSilmukanHelper(i)) {
                    return true;
                }
            }
           return false;
        }

        private boolean sisaltaaSilmukanHelper(int kurssiID) {
            // Nykyinen node on jo rekursiossa -> cykli havaittu -> lopetetaan dfs
            if (rekursioPino[kurssiID]) {
                sykli = new LinkedList<>();
                sykli.add(kurssiID);
                return true;
            }
            // Nykyinen node jo vierailtu eika restackissa -> ei osa sykliä -> ei tarvitse enaa vierailla
            if (vierailtu[kurssiID]) {
                return false;
            }
            // Jos vieraillaan nodessa ekaa kertaa, merkataan se vierailluksi ja osaksi stakkiä
            vierailtu[kurssiID]= true;
            rekursioPino[kurssiID] = true;

            // Kaydaan rekursiivisesti kaikissa nykyisen noden esitiedoissa jos ne sisaltavat syklin niin palautetaan true
            ArrayList<Integer> ennakkotiedot = kurssit.get(kurssiID).getEnnakkotiedot();
            for (int ennakkotieto : ennakkotiedot){
                if (sisaltaaSilmukanHelper(ennakkotieto)) {
                    sykli.add(kurssiID);
                    return true;
                }
            }

            // Paivitetaan kurssin periodi sitten kun ollaan graafin syvimmassa pisteessa
            paivitaPeriodi(kurssit.get(kurssiID));

            //Jos syklia ei ole loytynyt niin mennaan takaisin (backtrack) edelliseen nodeen kuitataan etta tasta nodesta
            // ei loytynyt syklia ja poistetaan tama node rekursiopinosta
            rekursioPino[kurssiID] = false;
            return false;
        }


        /**
         * Annetaan kurssille suoritusperiodi suhteessa sen esitietokursseihin.
         * @param kurssi
         */
        private void paivitaPeriodi(Kurssi kurssi) {
            int esitietojenMyohaisinPeriodi = etsiEnnakkotietojenMyohaisinPeriodi(kurssi.getEnnakkotiedot());
            int uusiperiodi = laskeUusiperiodi(esitietojenMyohaisinPeriodi, kurssi.getPeriodi());
            kurssi.setPeriodi(uusiperiodi);
        }

        /**
         * Palauttaa kurssin ennakkotietojen myohaisimman periodin. Jos ei ennakkotietoja, niin palautetaan 0.
         * @param ennakkotiedot {ArrayList<Integer>}
         * @return ennakkotietojen myohaisin periodi
         */
        private int etsiEnnakkotietojenMyohaisinPeriodi(ArrayList<Integer> ennakkotiedot) {
            int myohaisin = 0;
            for (int ennakkotieto: ennakkotiedot) {
                Kurssi ennakkotietoKurssi = kurssit.get(ennakkotieto);
                if (ennakkotietoKurssi.getPeriodi() > myohaisin) {
                    myohaisin = ennakkotietoKurssi.getPeriodi();
                }
            }
            return myohaisin;
        }




        public ArrayList<Kurssi> getKurssit() {
            return kurssit;
        }

        private void jarjestaSilmukka() {
            //eli syklin eka on syklin loppu loppu on FIFO:n alussa
            //otetaan ensin pää talteen
            // käännetään lista
            // poistetaan niin kauan kunnes tulee päätä vastaava arvo vastaan
            int syklinAlkuJaLoppu = sykli.poll();

            sykli = sykli.reversed();

            while (!sykli.isEmpty() && sykli.peek() != syklinAlkuJaLoppu) {
                sykli.poll();
            }
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
            PrintStream out = System.out;
            out.println("Silmukka:");
            while (!sykli.isEmpty()) {
                int kurssiId = sykli.poll();
                Kurssi kurssi = kurssit.get(kurssiId);
                System.out.printf("%d %s", kurssi.getId(), kurssi.getNimi());
                System.out.println();
            }
        }

        public boolean onSilmukka() {
            return onSilmukka;
        }

        /**
         * Palautetaan kurssien suoritusjarjestys. Poistetaan 0-indeksin dummyKurssi
         * @return {int[]}
         */
        public int[] getSuoritusJarjestys() {
            int[] jarjestys = new int[V - 1];

            // Tämä on nyt ihan puhtaasti testaamista varten taalla
            for (int i = 0; i < kurssit.size(); i++) {
               jarjestys[i] = kurssit.get(i).getId();
            }
            return jarjestys;
        }


        private void tulostaSuoritusAjankohdat() {

            PrintStream out = System.out;
            out.println("Suoritusajankohdat:");
            for (Kurssi kurssi: kurssit) {
                kurssi.tulosta();
            }
        }

    }

    public static class Parser {
        Scanner scanner;

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

            this.scanner = new Scanner(System.in);
            ArrayList<KurssiLista> kurssiListat = new ArrayList<>();
            KurssiLista kurssiLista = new KurssiLista();
            //lisataan jokaisen kurssiListaan dummy kurssi etta voidaan kasitella kursseja indeksista 1 lahtien
            kurssiLista.lisaaKurssi(new Kurssi(0, "dummy", 0, new ArrayList<>()));
            int nollaLaskuri = 0;
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNext()) {
                String seuraava = scanner.next();
                if (seuraava.equals("0")) {
                    nollaLaskuri++;
                } else {
                    nollaLaskuri = 0;
                }

                switch (nollaLaskuri) {
                    case 0:
                        sb.append(seuraava);
                        sb.append(" ");
                        continue;
                    case 1:
                        Kurssi uusiKurssi = luoKurssiSyotteesta(sb.toString());
                        sb = new StringBuilder();
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

        private Kurssi luoKurssiSyotteesta(String s) {
            ArrayList<Integer> ennakkotiedot = new ArrayList<>();
            Scanner scanner = new Scanner(s);
            int id = scanner.nextInt();
            String nimi = scanner.next();
            String periodi = scanner.next();
            String siivottuperiodi = periodi.replaceAll(":", "");
            int periodiInteger = Integer.parseInt(siivottuperiodi);

            while (scanner.hasNext()) {
                try {
                    int ennakkotieto = Integer.parseInt(scanner.next());
                    ennakkotiedot.add(ennakkotieto);
                } catch (Exception e) {
                    continue;
                }
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
