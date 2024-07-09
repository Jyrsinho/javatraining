package PrefixPhoneNumbers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumbersTest {


    PhoneNumber phoneNumber1;           // 0100
    PhoneNumber phoneNumber2;           // 999
    PhoneNumber phoneNumber3;           // 010
    PhoneNumber phoneNumber4;           // 10
    PhoneNumber phoneNumber5;           // 9822
    PhoneNumber phoneNumber6;

    Numbers <PhoneNumber> phoneNumbers;
    // Numbers <FaxNumber> faxNumbers;

   // FaxNumber faxNumber1;
   //  FaxNumber faxNumber2;

    @BeforeEach
    public void setUp() {
        this.phoneNumber1 = new PhoneNumber("0100");
        this.phoneNumber2 = new PhoneNumber("999");
        this.phoneNumber3 = new PhoneNumber("010");
        this.phoneNumber4 = new PhoneNumber("10");
        this.phoneNumber5 = new PhoneNumber("9822");
        this.phoneNumber6 = new PhoneNumber("100");
        phoneNumbers = new Numbers<>();
       // Numbers <FaxNumber> faxNumber = new Numbers<>();


        //this.faxNumber1 = new FaxNumber(100100);
        //this.faxNumber2 = new FaxNumber(100);
    }

    @AfterEach
    public void tearDown() {
        phoneNumbers = null;
    }


    @Test
    public void testShouldBeAbleToReturnTheAmountOfNumbers() {

        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        assertEquals(2, phoneNumbers.getLength());
    }


    @Test
    public void testShouldEvaluateFalseWhenGivenArrayWithTwoIdenticalNumbers() {

        phoneNumbers.add(phoneNumber1); //0100
        phoneNumbers.add(phoneNumber1); //0100
        assertFalse(phoneNumbers.isConsistent());
    }



    @Test
    public void testShouldReturnTrueWithTwoCompletelyDifferentNumbers() {

        phoneNumbers.add(phoneNumber1); //0100
        phoneNumbers.add(phoneNumber2); //999
        System.out.println(phoneNumbers);
        assertTrue(phoneNumbers.isConsistent());
    }

    @Test
    public void testShouldReturnTrueWhenGivenEmptyArray() {
        assertTrue(phoneNumbers.isConsistent());
    }



    @Test
    public void testArraySortingShouldSortNumbersBasedOnTheirLength() {
        PhoneNumber[] input1 = {            phoneNumber5,       //9822
                                            phoneNumber2,       //999
                                            phoneNumber4        //10
        };
        phoneNumbers.add(phoneNumber5); //98222
        phoneNumbers.add(phoneNumber2); //999
        phoneNumbers.add(phoneNumber4); //10
        phoneNumbers.sortArray();
        String expected1 = "10, 999, 9822";

        assertEquals(expected1, phoneNumbers.toString(), "The array should be sorted by length.");
    }


    @Test
    public void testShouldSortEqualLengthNumbersBasedOnTheirNumbersValues() {

        phoneNumbers.add(phoneNumber2); ///999
        phoneNumbers.add(phoneNumber3); //010
        phoneNumbers.add(phoneNumber6); //100
        phoneNumbers.sortArray();
        String expected = "010, 100, 999";

        assertEquals(expected, phoneNumbers.toString());

    }


    @Test
    public void testShouldRetunrFalseWithTwoCompletelyDifferentNumbersAndOneWithSamePrefix() {

        phoneNumbers.add(phoneNumber1); ///0100
        phoneNumbers.add(phoneNumber5); //9822
        phoneNumbers.add(phoneNumber3); //010
        assertFalse(phoneNumbers.isConsistent());
    }


    @Test
    public void testShouldReturnTrueWithOnePhoneNumberContainingOtherInTheEndOfTheNumber() {
        PhoneNumber[] t =  {  phoneNumber1,     //0100
                         phoneNumber5,          //9822
                         phoneNumber6           //100

        };
        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber5);
        phoneNumbers.add(phoneNumber6);
        assertTrue(phoneNumbers.isConsistent());
    }






}
