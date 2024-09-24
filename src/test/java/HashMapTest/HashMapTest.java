package HashMapTest;

import MyHashMap.MyHashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapTest {

    @Test
    public void testConstructorShouldCreateHashMapOfGivenSize() {
        MyHashMap hashMap = new MyHashMap(10);
        assertEquals(10, hashMap.getHashMapLenght());
    }

    @Test
    public void testHashShouldReturnValidHashingIndexForKey1() {
        MyHashMap hashMap = new MyHashMap(10);
        assert(hashMap.hash("key1") >= 0 || hashMap.hash("key1") < hashMap.getHashMapLenght());

    }

    @Test
    public void testHashShouldReturnValidHashingIndexForKey2() {
        MyHashMap hashMap = new MyHashMap(100);
        String key = "key2";
        assert(hashMap.hash(key) >= 0 || hashMap.hash(key) < hashMap.getHashMapLenght());
    }

    @Test
    public void testShouldAssignValuesToHashMap() {
        MyHashMap hashMap = new MyHashMap(10);
        hashMap.assign("testKey", testValue);
        assertEquals(1, getAmountOfValuesInHashMap(hashMap.getHashMap()));

    }

    public int getAmountOfValuesInHashMap(String[] hashMap) {
        int valuesInHashMap = 0;
        for (int i = 0; i < hashMap.length; i++) {
            if (hashMap[i] != null) {
                valuesInHashMap++;
            }
        }
        return valuesInHashMap;
    }

}
