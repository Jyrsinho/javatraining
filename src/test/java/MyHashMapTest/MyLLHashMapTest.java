package MyHashMapTest;

import MyHashMap.HMLinkedList;
import MyHashMap.MyLLHashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyLLHashMapTest {


    //TODO test that the constructor creates a

    @Test
    public void testConstructorShouldCreateArrayFilledWithLinkedLists() {
        MyLLHashMap<String> hashMap = new MyLLHashMap<String>(10);
        System.out.println(hashMap.getHashmap()[0]);

        assertNotNull(hashMap.getHashmap()[0]);
        assertNotNull(hashMap.getHashmap()[9]);
    }

    @Test
    public void testAssigningValuesToHashMapShouldIncreaseSize() {
        MyLLHashMap<String> hashMap = new MyLLHashMap<String>(10);
        hashMap.assign("testKey", "testValue");
        assertEquals(1, hashMap.getSize());
    }

    @Test
    public void testShouldAssignValuesToHashmap() {
        MyLLHashMap<String> hashMap = new MyLLHashMap<String>(10);
        hashMap.assign("testKey", "testValue");
        assertEquals(1, getAmountOfElements(hashMap.getHashmap()));

    }

    // This should count the number of LinkedLists within a hashmap array that have a value
    public int getAmountOfElements(HMLinkedList[] hashMap) {
        int amountOfKeyValuePairs = 0; //amount of Linked Lists in array
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i].head != null) {
                amountOfKeyValuePairs++;
            }
        }
        return amountOfKeyValuePairs;
    }

}
