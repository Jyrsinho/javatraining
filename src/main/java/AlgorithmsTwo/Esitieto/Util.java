package AlgorithmsTwo.Esitieto;

public class Util {

    public static int laskeUusiperiodi(int myohaisin, int kurssinPeriodi) {
       if (myohaisin % 4 >= kurssinPeriodi) {
           return myohaisin - myohaisin % 4 + 4 + kurssinPeriodi;
       }else {
           return myohaisin - myohaisin % 4 + kurssinPeriodi;
       }

    }
}
