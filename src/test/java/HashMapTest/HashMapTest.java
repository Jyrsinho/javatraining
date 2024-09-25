package HashMapTest;

import MyHashMap.MyHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HashMapTest {

    MyHashMap hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new MyHashMap(10);
    }

    @Test
    public void testConstructorShouldCreateHashMapOfGivenSize() {
        assertEquals(10, hashMap.getHashMapLenght());
    }

    @Test
    public void testHashShouldReturnValidHashingIndexForKey1() {
        assert(hashMap.hash("key1") >= 0 || hashMap.hash("key1") < hashMap.getHashMapLenght());

    }

    @Test
    public void testHashShouldReturnValidHashingIndexForKey2() {
        MyHashMap hashMap2 = new MyHashMap(100);
        String key = "key2";
        assert(hashMap2.hash(key) >= 0 || hashMap2.hash(key) < hashMap2.getHashMapLenght());
    }

    @Test
    public void testShouldAssignValuesToHashMap() {
        hashMap.assign("testKey", "testValue");
        assertEquals(1, getAmountOfValuesInHashMap(hashMap.getHashMap()));
    }

    @Test
    public void testShouldAssignMultipleValuesToHashMap() {
        hashMap.assign("testKey1", "testValue1");
        hashMap.assign("testKey2", "testValue2");
        hashMap.assign("testKey3", "testValue3");
        assertEquals(3, getAmountOfValuesInHashMap(hashMap.getHashMap()));
    }

    @Test
    public void testShouldGetValueFromHashMap() {
        hashMap.assign("testKey1", "testValue1");
        assertEquals("testValue1", hashMap.getValue("testKey1"));
    }

    @Test
    public void testShouldGetValueFromHashMap2() {
        hashMap.assign("testKey1", "testValue1");
        hashMap.assign("testKey2", "testValue2");
        hashMap.assign("testKey3", "testValue3");
        assertEquals("testValue3", hashMap.getValue("testKey3"));
    }

    @Test
    public void testShouldThrowNoSuchElementErrorWhenGettingValueFromHashMapThatDoesNotExist() {
        hashMap.assign("testKey1", "testValue1");
        hashMap.assign("testKey2", "testValue2");
        hashMap.assign("testKey3", "testValue3");

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            hashMap.getValue("testKey4");
        });
        assertEquals("No such key in hashmap", exception.getMessage());
    }


    @Test
    public void testShouldRemoveValueFromHashMap() {
        hashMap.assign("testKey1", "testValue1");
        hashMap.assign("testKey2", "testValue2");
        hashMap.assign("testKey3", "testValue3");

        String expected = "testValue1";
        String actual = hashMap.remove("testKey1");

        assertEquals(expected, actual);
        assertEquals(2, getAmountOfValuesInHashMap(hashMap.getHashMap()));
    }

    @Test
    public void testShouldThrowNoSuchElementErrorWhenRemovingValueFromHashMapThatDoesNotExist() {
        hashMap.assign("testKey1", "testValue1");
        hashMap.assign("testKey2", "testValue2");

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            hashMap.remove("testKey4");
        });
        assertEquals("No such key in hashmap", exception.getMessage());
    }

    @Test
    public void testShouldAddTwoValuesWithSameHashToHashMap() {
        hashMap.assign("testKey1", "testValue1");
        hashMap.assign("testKey1", "testValue2");
        assertEquals(2, getAmountOfValuesInHashMap(hashMap.getHashMap()));
    }

    @Test
    public void testShouldAddThreeValuesWithsameHashToHashMap() {
        hashMap.assign("testKey1", "testValue1");
        hashMap.assign("testKey1", "testValue2");
        hashMap.assign("testKey1", "testValue3");
        assertEquals(3, getAmountOfValuesInHashMap(hashMap.getHashMap()));
    }


    @Test
    public void testHashmapShouldGrowInSizeWhenTooCrowded() {
        MyHashMap hashMap3 = new MyHashMap(3);
        hashMap3.assign("testKey1", "testValue1");
        hashMap3.assign("testKey2", "testValue2");
        hashMap3.assign("testKey3", "testValue3");
        hashMap3.assign("testKey4", "testValue4");
    }

    @Test
    public void testHashMapShouldReturnProperValuesEvenAfterGrowingInSize() {
        MyHashMap hashMap3 = new MyHashMap(3);
        hashMap3.assign("testKey1", "testValue1");
        hashMap3.assign("testKey2", "testValue2");
        hashMap3.assign("testKey3", "testValue3");
        hashMap3.assign("testKey4", "testValue4");
        assertEquals("testValue4", hashMap3.getValue("testKey4"));
        assertEquals("testValue3", hashMap3.getValue("testKey3"));
        assertEquals("testValue2", hashMap3.getValue("testKey2"));
        assertEquals("testValue1", hashMap3.getValue("testKey1"));
    }


    /*
     *   TODO COLLISION HANDLING - separate chaining, where each array index points to a different data structure
     *
     */

    public int getAmountOfValuesInHashMap(String[][] hashMap) {
        int valuesInHashMap = 0;
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i][0] != null) {
                valuesInHashMap++;
            }
        }
        return valuesInHashMap;
    }

}
