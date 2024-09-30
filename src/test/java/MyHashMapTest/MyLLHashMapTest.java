package MyHashMapTest;

import MyHashMap.HMLinkedList;
import MyHashMap.MyHMNode;
import MyHashMap.MyLLHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyLLHashMapTest {

    public MyLLHashMap<String> hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new MyLLHashMap<String>(10);
    }


    @Test
    public void testConstructorShouldCreateArrayFilledWithLinkedLists() {
        assertNotNull(hashMap.getHashmap()[0]);
        assertNotNull(hashMap.getHashmap()[9]);
    }

    @Test
    public void testAssigningValuesToHashMapShouldIncreaseSize() {
        hashMap.assign("testKey", "testValue");
        assertEquals(1, hashMap.getSize());
    }

    @Test
    public void testShouldAssignValuesToHashmap() {
        hashMap.assign("testKey", "testValue");
        assertEquals(1, getAmountOfElements(hashMap.getHashmap()));

    }

    @Test
    public void testShouldGetValueFromHashmapWithOneKeyValuePair() {
        hashMap.assign("testKey", "testValue");
        assertEquals("testValue" ,hashMap.getValue("testKey"));
    }

    @Test
    public void testShouldGetValueFromHashmapWithMultipleKeyValuePairs() {
        hashMap.assign("testKey", "testValue");
        hashMap.assign("testKey2", "testValue2");
        hashMap.assign("testKey3", "testValue3");
        assertEquals("testValue3" ,hashMap.getValue("testKey3"));
    }


    @Test
    public void testShouldGetValueFromLLHeadFromHashMapWithMultipleKeyValuePairsInSameIndex1() {
        hashMap.assign("abc", "testValue1");
        hashMap.assign("bac", "testValue2");
        hashMap.assign("cba", "testValue3");
        assertEquals("testValue3" ,hashMap.getValue("cba"));
    }


    @Test
    public void testShouldGetValueFromLLTailFromHashMapWithMultipleKeyValuePairsInSameIndex1() {
        hashMap.assign("abc", "testValue1");
        hashMap.assign("bac", "testValue2");
        hashMap.assign("cba", "testValue3");
        assertEquals("testValue1" ,hashMap.getValue("abc"));

    }


    @Test
    public void testShouldGetValueFromLLMiddleFromHashMapWithMultipleKeyValuePairsInSameIndex2() {
        hashMap.assign("abc", "testValue1");
        hashMap.assign("bac", "testValue2");
        hashMap.assign("cba", "testValue3");
        assertEquals("testValue1", hashMap.getValue("abc"));
    }

    @Test
    public void testShouldReturnNoSuchKeyInHashmapMessageWhenGettingValueWithKeyThatDoesNotExistInTheHashmap() {
        hashMap.assign("testKey", "testValue");
        hashMap.assign("testKey2", "testValue2");

        assertEquals("No such key in hashmap", hashMap.getValue("testKey4"));
    }

    @Test
    public void testShouldReturnRemovedValueFromHashmapWhenRemovingValuesFromHashmap() {
        hashMap.assign("testKey", "testValue");
        assertEquals("testValue", hashMap.remove("testKey"));
    }

    @Test
    public void testShouldDiminishTheSizeOfHashmapWhenRemovingValueFromHashmap() {
        hashMap.assign("testKey", "testValue");
        hashMap.assign("testKey2", "testValue2");
        hashMap.remove("testKey");
        assertEquals(1, hashMap.getSize());
    }

    @Test
    public void testShouldGrowTheHashMapWhenLoadFactorBoundaryHasBeenCrossed() {
        MyLLHashMap<String> hashMap = new MyLLHashMap<String>(3);
        hashMap.assign("testKey", "testValue");
        hashMap.assign("testKey2", "testValue2");
        hashMap.assign("testKey3", "testValue3");
        assertEquals(6, hashMap.getHashmap().length);
    }

    @Test
    public void testShouldReturnCorrectValuesAfterGrowingHashmap() {
        MyLLHashMap<String> hashMap = new MyLLHashMap<String>(3);
        hashMap.assign("testKey", "testValue");
        hashMap.assign("testKey2", "testValue2");
        hashMap.assign("testKey3", "testValue3");
        hashMap.assign("testKey4", "testValue4");
        hashMap.assign("testKey5", "testValue5");
        assertEquals("testValue2" ,hashMap.getValue("testKey2"));
    }

    @Test
    public void testShouldReturnFinalValueInSameLinkedListWhenRemovingFirsValueKeyValuePair() {
            hashMap.assign("abc", "testValue1");
            hashMap.assign("bac", "testValue2");
            hashMap.assign("cba", "testValue3");
            hashMap.remove("abc");
            assertEquals("testValue3", hashMap.getValue("cba"));
        }

    @Test
    public void testShouldAssingNewValueForKey() {
        hashMap.assign("testKey", "testValue");
        hashMap.assign("testKey", "testValue2");
        assertEquals("testValue2" ,hashMap.getValue("testKey"));
    }


    //TODO: Test are we breaking the integrity of the list when removing values from the middle of the linkedlist.


    // This should count the number of LinkedLists within a hashmap array that have a value
    public int getAmountOfElements(HMLinkedList[] hashMap) {
        int amountOfKeyValuePairs = 0; //amount of Linked Lists in array
        for (int i = 0; i < hashMap.length; i++) {
            MyHMNode currentNode = hashMap[i].getHead();
            while (currentNode != null) {
                amountOfKeyValuePairs++;
                currentNode = currentNode.getNextNode();
            }
        }
        return amountOfKeyValuePairs;
    }

}
