package BinarySearch;

import java.util.Arrays;

public class BinarySearch {

    /**
     * Returns the index of the searched integer using binary search
     * @param t array to be searched
     * @return Result object that contains the index of the searched integer and
     * the amount of comparisons.
     */
    public static Result binarySearch(int [] t, int target) {
        Result result = new Result();

        // make sure that the array is sorted
        Arrays.sort(t);

        int low = 0;
        int high = t.length - 1;
        int proposedIndex;
        int numberOfComparisons = 0;


        while ( low <= high) {

            proposedIndex = (high - low) / 2 ;

            if (t[proposedIndex] == target) {
                result.setIndex(proposedIndex);
                break;
            }
            if (t[proposedIndex] > target) {
                high = proposedIndex -1;
            }
            if (t[proposedIndex] < target) {
                low = proposedIndex + 1;
            }

        }

        result.setNumberOfComparisons(numberOfComparisons);

        return result;
    }


}
