package AlgorithmsTwo.Perinnonjako;

import java.util.ArrayList;
import java.util.Scanner;

public class SyotteenAnalysoija {

    /**
     * @param input merkkijono jota tutkitaan
     * @return ArrayList jossa input jaoteltuna eri perintoinputeihin
     */
    public ArrayList<String> annaPerinnonjakoSyotteet(String input) {
        ArrayList<String> perinnonJaot = new ArrayList<>();
        Scanner sc = new Scanner(input);
        StringBuilder perinnonJako = new StringBuilder();
        int jarjestysNumero = 0;

            // otsikkoriveilla jarjestysnumerot ovat 0 ja 1
            // normaaleilla riveilla jarjestysnumerot ovat 2 - 5
            while (sc.hasNext()) {
                String merkkijono = sc.next();
                // otsikkorivin kasittely
                if (jarjestysNumero == 0) {
                    boolean syoteLoppuu = onNolla(merkkijono);
                    if (syoteLoppuu) {
                        break;
                    } else {
                        perinnonJako.append(merkkijono).append(" ");
                        jarjestysNumero++;
                    }
                }else if (jarjestysNumero == 1){
                    perinnonJako.append(merkkijono).append(" ");
                    jarjestysNumero++;
                    // muiden rivien kasittely
                    // normaalin rivin ensimmainen merkki | jos nolla niin lopetetaan
                } else if (jarjestysNumero == 2) {
                    boolean perinnonJakoLoppuu = onNolla(merkkijono);
                    if (perinnonJakoLoppuu) {
                        perinnonJako.delete(perinnonJako.length() - 1, perinnonJako.length());
                        perinnonJaot.add(perinnonJako.toString());
                        jarjestysNumero = 0;
                        perinnonJako = new StringBuilder();
                    }else {
                        perinnonJako.append(merkkijono).append(" ");
                        jarjestysNumero++;
                    }
                } else if (jarjestysNumero < 5) {
                    perinnonJako.append(merkkijono).append(" ");
                    jarjestysNumero++;
                    // normaalin rivin viimeisen merkin kasittely
                } else {
                    perinnonJako.append(merkkijono).append(" ");
                    jarjestysNumero= 2;
                }
                }

        return perinnonJaot;
    }

    private boolean onNolla(String merkkijono) {
        return merkkijono.equals("0");
    }

}