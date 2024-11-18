package BinarySearch;

import java.util.Arrays;
import java.util.Random;


public class BinarySearch {


    public static class Result {

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

    /**
     * Returns the index of the searched integer using binary search
     *
     * @param t array to be searched
     * @return Result object that contains the index of the searched integer and
     * the amount of comparisons.
     */
    public  Result binarySearch(int[] t, int target) {
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

    /**
     * Metodi, joka luo satunnaisia kokonaislukuja sisältävän taulukon
     * @param size Taulukon koko
     * @param min Pienin mahdollinen arvo
     * @param max Suurin mahdollinen arvo
     * @return Taulukko, joka sisältää satunnaisia kokonaislukuja
     */
    public static int[] generateSortedRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        Arrays.sort(array);

        return array;
    }


    public static void printArray(int [] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }

    }

    public static void main(String[] args) {

        /*
        Luo satunnaisia kokonaislukuja sisältävä taulukko (esim. Random-luokan metodeilla) ja järjestä se käyttäen
        jotakin valmista järjestysrutiinia (esim. Array.Sort). Generoitavat kokonaisluvut kannattaa valita joltakin
        suhteellisen suppealta väliltä, esim. 0-50.
Testeissä kannattaa käyttää sekä pieniä että suuria taulukoita. Pienet (noin 10 alkiota) voi tulostaa näytölle.
Suurista taulukoista (esim 100 alkioita) kannattaa tulostaa vain esim. taulukon koko.
Testitulostuksiin tuloksena tieto haettavan alkion löytymisestä ja vertailuoperaatioiden lukumäärä.
         */

        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Luodaan 10-alkioinen satunnainen järjestetty taulukko nollasta kymmeneen:");
        int [] randomArray = generateSortedRandomArray(10, 0, 10);
        printArray(randomArray);
        System.out.println();
        System.out.println("Etsitään taulukosta lukua 2");
        Result result = binarySearch.binarySearch(randomArray, 2);
        System.out.println("Luku 2 löytyi taulukosta indexistä:" +result.getIndex() + " Hakuun käytettiin " + result.getNumberOfComparisons() + " vertailua.");


    }

}
