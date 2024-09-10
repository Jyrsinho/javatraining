package HashMapTest;

import HashMap.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashMapTest {
    HashMap<String> hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMap(3);
    }

    @Test
    public void testShouldReturnIndexSuitableForArray() {
        String testKey = "anneli";
        int hash = hashMap.hash(testKey);
        assertTrue(hash < hashMap.getSize() && hash >= 0);
    }

    @Disabled
    public void testShouldReturnIndexSuitableForArray2() {
        String testKey = "auto";
        int hash = hashMap.hash(testKey);
        assertTrue(hash < hashMap.getSize() && hash >= 0);
    }

    @Disabled
    public void testShouldAssingAmountOfKeyValuePairsInHashMap() {
        assertEquals(0, hashMap.getAmountOfKeyValuePairs());
        hashMap.assing("Auto", "Volvo");
        assertEquals(1, hashMap.getAmountOfKeyValuePairs());
        hashMap.assing("Mopo", "Kawasaki");
        assertEquals(2, hashMap.getAmountOfKeyValuePairs());
    }

    @Disabled
    public void testShouldAssingAmountOfKeyValuePairsInHashMapEvenWhenElementsHaveSameHash() {
    hashMap.assing("Auto", "Volvo");
    hashMap.assing("Auto", "Volvo");
    assertEquals(2, hashMap.getAmountOfKeyValuePairs());
    }

    @Disabled
    public void testShouldHandleAddingThreeKeyValuePairsToHashMapWithThreeSlots() {
        hashMap.assing("Auto", "Volvo");
        hashMap.assing("Auto", "Volvo");
        hashMap.assing("Auto", "Volvo");
        assertEquals(3, hashMap.getAmountOfKeyValuePairs());
    }

    @Disabled
    public void testShouldDoubleTheSizeOfHashMapWhen75PercentOccupied() {
        HashMap hashMap5 = new HashMap(5);
        assertEquals(5, hashMap5.getSize());
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        assertEquals(10, hashMap5.getSize());
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        hashMap5.assing("Auto", "Volvo");
        assertEquals(20, hashMap5.getSize());
    }


}
