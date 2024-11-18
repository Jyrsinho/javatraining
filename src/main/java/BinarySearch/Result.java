package BinarySearch;



public class Result {

    private int index;
    private int numberOfComparisons;


    /**
     * Sets the index value of the Result object
     *
     * @param index where the integer is located in the array
     */
    public void setIndex(int index) {
        this.index = index;
    }

    public void setNumberOfComparisons(int numberOfComparisons) {
        this.numberOfComparisons = numberOfComparisons;
    }

    public int getIndex() {
        return index;
    }

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }



}
