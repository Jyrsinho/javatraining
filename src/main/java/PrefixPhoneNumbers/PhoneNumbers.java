package PrefixPhoneNumbers;

//TODO turn phonenumbers Strings into phonenumber objects
//TODO Turn this class into a generic class that can evaluate "String typed phonenumbers and int typed numbers

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


        for (int i = 0; i < phoneNumbers.length-1; i++) {
            int currentMinimum = i;
            for (int j = i+1; j < phoneNumbers.length; j++) {
                if (phoneNumbers[j].getLength() < phoneNumbers[i].getLength()) {
                    currentMinimum = j;
                }
            }
            PhoneNumber temp = phoneNumbers[i];
            phoneNumbers[i] = phoneNumbers[currentMinimum];
            phoneNumbers[currentMinimum] = temp;
        }


    }


    /**
     * Checks whether the current PhoneNumbers instance is consistent or not
     * @return true if current PhoneNumbers instance is consistent, false if it is not consistent
     */
    public boolean isConsistent() {
        sortArray();                    //sorts the phoneNumbers array from shortest element to longest
        boolean isConsistent = true;

        outerLoop:
        for (int i = 0; i < phoneNumbers.length -1; i++) {
            PhoneNumber phoneNumber = phoneNumbers[i];
            for (int j = i+1; j < phoneNumbers.length; j++) {
                PhoneNumber comparablePhoneNumber = phoneNumbers[j];
                isConsistent = !containsPrefix(phoneNumber, comparablePhoneNumber);
                if (!isConsistent) break outerLoop;
            }
        }

        return isConsistent;

    }

    /**
     * checks if one phonenumber starts with another phonenumber
     * @param phoneNumber that could be included in the beginning of a comparablePhoneNumber
     * @param comparablePhoneNumber that might include the phoneNumber
     * @return true if beginning of comparablePhoneNumber begins with phoneNumber
     */
    public boolean containsPrefix(PhoneNumber phoneNumber, PhoneNumber comparablePhoneNumber) {
        String comparablePhoneNumberBeginning = comparablePhoneNumber.getPhoneNumber().substring(0, phoneNumber.getLength());
        return comparablePhoneNumberBeginning.equals(phoneNumber.getPhoneNumber());
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
