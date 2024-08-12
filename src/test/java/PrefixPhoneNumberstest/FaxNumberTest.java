package PrefixPhoneNumberstest;


import PrefixPhoneNumbers.FaxNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FaxNumberTest {
    FaxNumber faxNumber1 = new FaxNumber("01");
    FaxNumber faxNumber2 = new FaxNumber("010");
    FaxNumber faxNumber3 = new FaxNumber("999");
    FaxNumber faxNumber4 = new FaxNumber("10");


    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testGetLengthForNineNineNineShouldReturnThree() {
        assertEquals(3, faxNumber3.getLength());
    }

    @Test
    public void testZeroOneShouldBeAPrefixOfZeroOneZero() {
        assertTrue(faxNumber1.isAPrefixOf(faxNumber2));
    }

    @Test
    public void ZeroOneShouldNotBeAPrefixOfNineNineNine() {
        assertFalse(faxNumber1.isAPrefixOf(faxNumber3));
    }


    @Test
    public void OneZeroShouldNotBeAPrefixOfZeroOneZero() {
        assertFalse(faxNumber4.isAPrefixOf(faxNumber2));
    }
}



