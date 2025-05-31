package AlgorithmsTwo.Esitieto;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

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
        long alku = System.nanoTime();
        esitieto.kasitteleSyote();
         long loppu = System.nanoTime();

        double ms = (loppu - alku) / 1e6;
        System.out.printf("Suoritus kesti %.3f ms\n", ms);

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


            Kurssi kurssi = kurssit.get(kurssiID);
            // jos kurssissa on jo vierailtu, palautetaan sen periodi
            if (vierailtu[kurssiID]) {
                return kurssi.getPeriodi();
            }
            int myohaisinEsitieto = 0;

            // lisätään kurssi rekursiopinoon ja kuljetulle reitille
            rekursioPino[kurssiID] = true;
            reitti.push(kurssiID);

            //jos kurssilla on vierailemattomia lapsia, vieraillaan niissa ja palautetaan niistä niiden periodit
            ArrayList<Integer> esitiedot = kurssi.getEnnakkotiedot();
            for (Integer esitieto: esitiedot) {
                // jos kurssin lapsi on jo rekursiopinossa, looppi on löytynyt palautetaan -1 ja otetaan reitti talteen
                if (rekursioPino[esitieto]) {
                    // Silmukka löytyi -> kerätään reitti talteen
                    silmukka.clear();
                    boolean lisaa = false;
                    for (int kurssiId : reitti) {
                        if (kurssiId == esitieto) {
                            lisaa = true;
                        }
                        if (lisaa) {
                            silmukka.push(kurssit.get(kurssiId));
                        }
                    }
                  //  silmukka.push(kurssit.get(kurssiID)); // lisää nykyinenkin
                    return -1;
                }else   {
                    int esitiedonPeriodi;
                    if (vierailtu[esitieto]) {
                       esitiedonPeriodi = kurssit.get(esitieto).getPeriodi();
                    } else {
                        esitiedonPeriodi = jarjestaGraafiHelper(esitieto);
                    }
                    if (esitiedonPeriodi < 0) {
                        return -1;
                    }
                    if (esitiedonPeriodi > myohaisinEsitieto) {
                        myohaisinEsitieto = esitiedonPeriodi;
                    }
                }
            }

            // jos vieraillaan ensimmaista kertaa lasketaan kurssin periodi suhteessa kurssin lasten periodeihin
            int kurssinPeriodi = Util.laskeUusiperiodi(myohaisinEsitieto, kurssi.getPeriodi());

            kurssi.setPeriodi(kurssinPeriodi);
            // merkataan kurssi vierailluksi ja lisätään se vastaukseen
            vierailtu[kurssiID] = true;

            Stack<Kurssi> pienemmat = new Stack<>();
            while (!vastaus.isEmpty() && vastaus.peek().periodi < kurssi.periodi) {
                pienemmat.push(vastaus.pop());
            }

            vastaus.add(kurssi);
            while (!pienemmat.isEmpty()) {
                vastaus.push(pienemmat.pop());
            }

            // Backtrack: palautetaan kurssin periodi ja poistetaan kurssi rekursiopinosta
            rekursioPino[kurssiID] = false;
            reitti.pop();
            return kurssi.getPeriodi();
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
