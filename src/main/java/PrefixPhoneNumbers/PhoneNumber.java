package PrefixPhoneNumbers;

public class PhoneNumber implements Comparable<PhoneNumber> {

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
    public boolean isAPrefixOf(PhoneNumber comparablePNumber) {
        return comparablePNumber.getPhoneNumber().substring(0,this.getLength()).equals(this.getPhoneNumber());

    }


    @Override
    public int compareTo(PhoneNumber o) {
        if (this.getLength() == o.getLength()) {
            for (int i = 0; i < o.getLength(); i++) {
                char char1 = this.getPhoneNumber().charAt(i);
                char char2 = o.getPhoneNumber().charAt(i);
                if (char1 > char2) return 1;
                if (char1 < char2) return -1;
            }
            return 0;
        }
        else if (this.getLength() > o.getLength()) {
            return 1;
        }
        else {
            return -1;
        }
    }

}
