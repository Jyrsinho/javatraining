package HashMapTest;

import DataStructures.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    HashMap hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMap(5);
    }

    @Test
    public void testShouldReturnIndexSuitableForArray() {
        String testKey = "anneli";
        int hash = hashMap.hash(testKey);
        assertTrue(hash < hashMap.getSize() && hash >= 0);
    }

    @Test
    public void testShouldReturnIndexSuitableForArray2() {
        String testKey = "auto";
        int hash = hashMap.hash(testKey);
        assertTrue(hash < hashMap.getSize() && hash >= 0);
    }

    @Test
    public void testShouldAddAmountOfKeyValuePairsInHashMap() {
        assertEquals(0, hashMap.getAmountOfKeyValuePairs());
        hashMap.add("Auto", "Volvo");
        assertEquals(1, hashMap.getAmountOfKeyValuePairs());
        hashMap.add("Mopo", "Kawasaki");
        assertEquals(2, hashMap.getAmountOfKeyValuePairs());
    }

    @Test
    public void testShouldAddAmountOfKeyValuePairsInHashMapEvenWhenElementsHaveSameHash() {
    hashMap.add("Auto", "Volvo");
    hashMap.add("Auto", "Volvo");
    assertEquals(2, hashMap.getAmountOfKeyValuePairs());
    }
}
