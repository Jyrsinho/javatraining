package PrefixPhoneNumbers;

public class PhoneNumber {

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
}
