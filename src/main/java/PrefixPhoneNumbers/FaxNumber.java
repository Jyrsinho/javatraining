package PrefixPhoneNumbers;

public class FaxNumber implements Comparable<FaxNumber>, PrefixChecker<FaxNumber> {

    String faxNumber;

    public FaxNumber(){
    }

    public FaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * returns the amount of digits in faxNumber
     * @return the amount of digits in faxNumber
     */
    public int getLength() {
        return faxNumber.length();
    }

    @Override
    public String toString() {
        return this.getFaxNumber();
    }


    /**
     * Checks whether this faxNumber is a prefix of a given faxNumber
     * @param comparableFNumber FaxNumber that could include this FaxNumber as a prefix
     * @return true if this FaxNumber is a prefix of comparableFNumber
     */
    @Override
    public boolean isAPrefixOf(FaxNumber comparableFNumber) {
        return comparableFNumber.getFaxNumber().substring(0,this.getLength()).equals(this.getFaxNumber());

    }


    @Override
    public int compareTo(FaxNumber o) {
        //comparison based on the length of the strings
        int lentghComparison= Integer.compare(this.faxNumber.length(), o.faxNumber.length());
        if (lentghComparison !=0) return lentghComparison;
        // if lengths are the same, compare lexicographically
        return this.faxNumber.compareTo(o.faxNumber);
    }


}
