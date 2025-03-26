package AlgorithmsTwoTest;

import AlgorithmsTwo.Perinnonjako.Perija;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerijaTest {
    @Test
    public void testShouldReturnFalseForLaillinenPerijaWhenPerijaIsdead() {
        Perija perija1  = new Perija("Sami", false, 0);
        boolean expected = false;
        boolean actual = perija1.onLaillinenPerija();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnTrueForLaillinenPerijaWhenPerijaIsdeadAndHasLivingChild() {
        Perija vanhempi = new Perija("Vanhempi", false, 0);
        Perija lapsi = new Perija("Lapsi", true, 1);
        vanhempi.lisaaLapsi(lapsi);
        boolean expected = true;
        boolean actual = vanhempi.onLaillinenPerija();
        assertEquals(expected, actual);
    }

    @Test
    public void testShouldReturnTrueForLaillinenPerijaWhenPerijaIsDeadButHasLivingGrandchild() {
        Perija vanhempi = new Perija("Vanhempi", false, 0);
        Perija lapsi = new Perija("Lapsi", false, 1);
        Perija lapsenlapsi = new Perija("Lapsenlapsi", true, 2);
        vanhempi.lisaaLapsi(lapsi);
        lapsi.lisaaLapsi(lapsenlapsi);
        boolean expected = true;
        boolean actual = vanhempi.onLaillinenPerija();
        assertEquals(expected, actual);
    }
}
