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
