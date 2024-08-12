package PrefixPhoneNumberstest;


import PrefixPhoneNumbers.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneNumberTest {

    // Test should evaluate whether an instance method in PhoneNumber class can evaluate whether this
    // phoneNumber begins with another phoneNumber that is given as a parameter.

    PhoneNumber phoneNumber1 = new PhoneNumber("01");
    PhoneNumber phoneNumber2 = new PhoneNumber("010");
    PhoneNumber phoneNumber3 = new PhoneNumber("999");
    PhoneNumber phoneNumber4 = new PhoneNumber("10");

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void testZeroOneShouldBeAPrefixOfZeroOneZero() {
        assertTrue(phoneNumber1.isAPrefixOf(phoneNumber2));
    }


    @Test
    public void ZeroOneShouldNotBeAPrefixOfNNineNineNIne() {
        assertFalse(phoneNumber1.isAPrefixOf(phoneNumber3));
    }

    @Test
    public void OneZeroShouldNotBeAPrefixOfZeroOneZero() {
        assertFalse(phoneNumber4.isAPrefixOf(phoneNumber2));
    }

}
