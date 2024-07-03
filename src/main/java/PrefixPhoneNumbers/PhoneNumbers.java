package PrefixPhoneNumbers;

public class PhoneNumbers {

    String [] phoneNumbers;

    public PhoneNumbers(String [] phoneNumbers){
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
     * Checks whether the current PhoneNumbers instance is consistent or not
     * @return true if current PhoneNumbers instance is consistent, false if it is not consistent
     */
    public boolean isConsistent() {

        if (phoneNumbers[0] != phoneNumbers[1])
            return true;

        return false;
    }
}
