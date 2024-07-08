package PrefixPhoneNumbers;

public class PhoneNumber implements Comparable<PhoneNumber>, PrefixChecker<PhoneNumber> {

    String phoneNumber;

    public PhoneNumber() {

    }

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getLength() {
        return this.phoneNumber.length();
    }

    @Override
    public String toString() {
        return this.getPhoneNumber();
    }


    /**
     * Checks whether this phoneNumber is a prefix of a given phoneNumber
     * @param comparablePNumber PhoneNumber that could include this PhoneNumber as a prefix
     * @return true if this PhoneNumber is a prefix of comparablePNumber
     */
    @Override
    public boolean isAPrefixOf(PhoneNumber comparablePNumber) {
        return comparablePNumber.getPhoneNumber().substring(0,this.getLength()).equals(this.getPhoneNumber());

    }

    //TODO fix this to compare length of the phoneNumber not lexicographical values
    @Override
    public int compareTo(PhoneNumber o) {
        //comparison based on the length of the strings
        int lenthComparison= Integer.compare(this.phoneNumber.length(), o.phoneNumber.length());
        if (lenthComparison !=0) return lenthComparison;
        // if lengths are the same, compare lexicographically
        return this.phoneNumber.compareTo(o.phoneNumber);
        }


    }


