package PrefixPhoneNumbers;

//TODO Turn this class into a generic class that can evaluate "String typed phonenumbers and int typed numbers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Numbers <T extends Comparable<T> & PrefixChecker<T>> {

    private final ArrayList<T> numbers;

    public Numbers(){
        this.numbers = new ArrayList<>();
    }


    /**
     * Adds numbers to the Arraylist
     */
    public void add(T number) {
        numbers.add(number);
    }


    /**
     * removes the given number from the numbers arraylist
     * @param number to be removed
     */
    public void remove(T number) {
        numbers.remove(number);
    }


    /**
     * returns the given index of numbers arraylist
     * @param index that is given
     * @return element at the given index of numbers arraylist
     */
    public T get(int index) {
    return numbers.get(index);

    }


    /**
     * returns the length of the numbers arraylist
     * @return the length of the numbers arraylist
     */
    public int getLength() {
        return numbers.size();
    }


    /**
     * Sorts the String array of phonenumbers based on the length of the phonenumbers.
     */
    public void sortArray() {
        Collections.sort(numbers);
    }


    /**
     * Checks whether the current PhoneNumbers instance is consistent or not
     * @return true if current PhoneNumbers instance is consistent, false if it is not consistent
     */
    public boolean isConsistent() {
        if (numbers.isEmpty()) return true;
        this.sortArray();                    //sorts the phoneNumbers array from the shortest element to longest
        boolean isConsistent = true;

        for (int i = 0, j= i+1; i < numbers.size() -1; i++, j++) {
            isConsistent = !numbers.get(i).isAPrefixOf(numbers.get(j));
            if (!isConsistent)  break;
            }

        return isConsistent;
    }


    @Override public String toString () {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i <numbers.size()-1){
                sb.append(", ");
            }
        }
        return String.valueOf(sb);
    }
}
