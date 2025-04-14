package AlgorithmsTwo.LukuJarjestys;

import java.util.HashMap;

public class AikatauluRuutu {

    HashMap<Tapahtuma, Integer> tapahtumat;


    public AikatauluRuutu() {
        this.tapahtumat = new HashMap<>();
    }

    public void lisaa(Tapahtuma tapahtuma) {
        if (tapahtumat.containsKey(tapahtuma)) {
            tapahtumat.put(tapahtuma, tapahtumat.get(tapahtuma) + 1);
        }else {
            tapahtumat.put(tapahtuma, 1);
        }
    }
}
