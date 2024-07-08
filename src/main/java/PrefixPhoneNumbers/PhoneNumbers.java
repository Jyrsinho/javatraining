package PrefixPhoneNumbers;

//TODO Turn this class into a generic class that can evaluate "String typed phonenumbers and int typed numbers

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneNumbers {

    PhoneNumber [] phoneNumbers;

    public PhoneNumbers(PhoneNumber [] phoneNumbers){
        this.phoneNumbers = phoneNumbers;
    }

    /**
     * returns the amount of elements in the array containing phonenumbers
     * @return the amount of phoneNumbers in the phonenumbers Array.
     */
    public int getTheAmountOfPhoneNumbers() {
        return phoneNumbers.length;
    }


    /**
     * Sorts the String array of phonenumbers based on the length of the phonenumbers.
     */
    public void sortArray() {

        List<PhoneNumber> phoneNumberList = Arrays.asList(phoneNumbers);
        Collections.sort(phoneNumberList);
    }


    /**
     * Checks whether the current PhoneNumbers instance is consistent or not
     * @return true if current PhoneNumbers instance is consistent, false if it is not consistent
     */
    public boolean isConsistent() {
        sortArray();                    //sorts the phoneNumbers array from the shortest element to longest
        boolean isConsistent = true;

        for (int i = 0, j= i+1; i < phoneNumbers.length -1; i++, j++) {
            isConsistent = !phoneNumbers[i].isAPrefixOf(phoneNumbers[j]);
            if (!isConsistent)  break;
            }

        return isConsistent;
    }


    @Override public String toString () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < phoneNumbers.length; i++) {
            sb.append(phoneNumbers[i]);
            if (i <phoneNumbers.length-1){
                sb.append(", ");
            }
        }
        return String.valueOf(sb);
    }
}
