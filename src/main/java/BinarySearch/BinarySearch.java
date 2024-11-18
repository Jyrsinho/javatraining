package BinarySearch;

import java.util.Arrays;




public class BinarySearch {

    /**
     * Returns the index of the searched integer using binary search
     *
     * @param t array to be searched
     * @return Result object that contains the index of the searched integer and
     * the amount of comparisons.
     */
    public static Result binarySearch(int[] t, int target) {
        // Create new Result object to store the index of the searched integer and the number of comparisons
        // executed during the search
        Result result = new Result();

        // make sure that the array is sorted
        Arrays.sort(t);


        int low = 0;
        int high = t.length - 1;
        int proposedIndex;
        int numberOfComparisons = 0;


        while (low <= high) {

            proposedIndex = (high + low) / 2;

            // If the target is found, update the Result Object and return it
            if (t[proposedIndex] == target) {
                numberOfComparisons++;
                result.setNumberOfComparisons(numberOfComparisons);
                result.setIndex(proposedIndex);
                return result;
            }
            // if the target is smaller than proposed Index, update the high value
            if (t[proposedIndex] > target) {
                high = proposedIndex - 1;
            }
            // if the target is larger than proposed Index, update the low value
            if (t[proposedIndex] < target) {
                low = proposedIndex + 1;
            }
            numberOfComparisons++;

        }

        result.setNumberOfComparisons(numberOfComparisons);
        result.setIndex(-1);
        return result;
    }

}
