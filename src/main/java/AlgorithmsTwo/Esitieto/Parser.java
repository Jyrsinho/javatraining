package AlgorithmsTwo.Esitieto;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
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
            System.out.println("Luettiin " +seuraava);
            if (seuraava.equals("0")) {
                nollaLaskuri++;
                System.out.println("Lisattiin nollalaskuri. Arvo nyt " +nollaLaskuri);
            } else {
                nollaLaskuri = 0;
                System.out.println("Nollalaskuri nollattu");
            }

            switch (nollaLaskuri) {
                case 0:
                    System.out.println("Nollalaskuri on 0. Lisätään stringbuilderiin");
                    sb.append(seuraava);
                    sb.append(" ");
                    System.out.println("sb:ssä nyt: " + sb);
                    continue;
                case 1:
                    Kurssi uusiKurssi = luoKurssiSyotteesta(sb.toString());
                    sb = new StringBuilder();
                    System.out.println("Luotiin uusi Kurssi >" );
                    uusiKurssi.tulosta();
                    kurssiLista.lisaaKurssi(uusiKurssi);
                    continue;
                case 2:
                    kurssiListat.add(kurssiLista);
                    System.out.println("Lisättiin kurssilistoihin ->");
                    kurssiLista.tulosta();
                    kurssiLista = new KurssiLista();
                    continue;
                default:
                    System.out.println("Kolme nollaa. Lopetetaan.");
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