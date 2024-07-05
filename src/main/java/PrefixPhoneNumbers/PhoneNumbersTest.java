package PrefixPhoneNumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumbersTest {


    PhoneNumber phoneNumber1;           // 0100
    PhoneNumber phoneNumber2;           // 999
    PhoneNumber phoneNumber3;           // 010
    PhoneNumber phoneNumber4;           // 10
    PhoneNumber phoneNumber5;           // 9822
    PhoneNumber phoneNumber6;

    @BeforeEach
    public void setUp() {
        this.phoneNumber1 = new PhoneNumber("0100");
        this.phoneNumber2 = new PhoneNumber("999");
        this.phoneNumber3 = new PhoneNumber("010");
        this.phoneNumber4 = new PhoneNumber("10");
        this.phoneNumber5 = new PhoneNumber("9822");
        this.phoneNumber6 = new PhoneNumber("100");
    }

    @Test
    public void testShouldBeAbleToReturnTheAmountOfPhonenumbers() {
        PhoneNumber [] pNumberArray = {  phoneNumber1,      //0100
                                         phoneNumber2       //999
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(pNumberArray);
        assertEquals(2, phoneNumbers.getTheAmountOfPhoneNumbers());
    }


    @Test
    public void testShouldEvaluateFalseWhenGivenArrayWithTwoIdenticalNumbers() {

        PhoneNumber [] pNumberArray = {     phoneNumber1,       //0100
                                            phoneNumber1        //0100
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(pNumberArray);
        assertFalse(phoneNumbers.isConsistent());
    }


    @Test
    public void testShouldReturnTrueWithTwoCompletelyDifferentNumbers() {

        PhoneNumber[] pNumberArray = {  phoneNumber1,       //0100
                                        phoneNumber2        //999
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(pNumberArray);
        assertTrue(phoneNumbers.isConsistent());
    }

    @Test
    public void testArraySortingShouldSortNumbersBasedOnTheirLength() {
        PhoneNumber[] input1 = {            phoneNumber5,       //9822
                                            phoneNumber2,       //999
                                            phoneNumber4        //10
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(input1);
        phoneNumbers.sortArray();
        String expected1 = "10, 999, 9822";

        assertEquals(expected1, phoneNumbers.toString(), "The array should be sorted by length.");

    }

    @Test
    public void testShouldSortEqualLengthNumbersBasedOnTheirNumbersValues() {
        PhoneNumber[] input1 = {        phoneNumber2,       //999
                                        phoneNumber3,       //010
                                        phoneNumber6        //100
        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(input1);
        phoneNumbers.sortArray();
        String expected = "010, 100, 999";

        assertEquals(expected, phoneNumbers.toString());

    }



    @Test
    public void testShouldRetunrFalseWithTwoCompletelyDifferentNumbersAndOneWithSamePrefix() {
        PhoneNumber[] t =  { phoneNumber1,      // 0100
                             phoneNumber5,      // 9822
                             phoneNumber3       // 010

        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(t);
        assertFalse(phoneNumbers.isConsistent());
    }

    @Test
    public void testShouldReturnTrueWithOnePhoneNumberContainingOtherInTheEndOfTheNumber() {
        PhoneNumber[] t =  {  phoneNumber1,     //0100
                         phoneNumber5,          //9822
                         phoneNumber6           //100

        };
        PhoneNumbers phoneNumbers = new PhoneNumbers(t);
        assertTrue(phoneNumbers.isConsistent());
    }




}
