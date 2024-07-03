package PrefixPhoneNumbers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumbersTest {



    @Test
    public void testShouldBeAbleToReturnTheAmountOfPhonenumbersInCurrentInstanceOfPhoneNumbers() {
        String [] pNumberArray = {  "0100",
                "0100"
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(pNumberArray);
        assertEquals(2, phoneNumbers.getTheAmountOfPhoneNumbers());
    }


    @Test
    public void testShouldEvaluateFalseWhenGivenArrayWithTwoIdenticalNumbers() {

        String [] pNumberArray = {  "0100",
                                    "0100"
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(pNumberArray);
        assertFalse(phoneNumbers.isConsistent());
    }


    @Test
    public void testShouldReturnTrueWithTwoCompletelyDifferentNumbers() {

        String[] pNumberArray = {  "0100",
                "9999"
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(pNumberArray);
        assertTrue(phoneNumbers.isConsistent());
    }

    @Test
    public void testShouldRetunrFalseWithTwoCompletelyDifferentNumbersAndOneWithSamePrefix() {
        String[] t =  { "0100",
                        "9822",
                        "010"

        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(t);
        assertFalse(phoneNumbers.isConsistent());
    }




}
