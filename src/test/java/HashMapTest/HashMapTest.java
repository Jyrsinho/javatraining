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
        hashMap = new HashMap(3);
    }

    @Test
    public void testShouldReturnIndexSuitableForArray() {
        String testKey = "anneli";
        int hash = hashMap.hash(testKey);
        int index = hashMap.findIndexForHash(hash);
        assertTrue(index < hashMap.getSize() && index >= 0);
    }

    @Test
    public void testShouldReturnIndexSuitableForArray2() {
        String testKey = "auto";
        int hash = hashMap.hash(testKey);
        int index = hashMap.findIndexForHash(hash);
        assertTrue(index < hashMap.getSize() && index >= 0);
    }

    @Test
    public void testShouldAssingAmountOfKeyValuePairsInHashMap() {
        assertEquals(0, hashMap.getAmountOfKeyValuePairs());
        hashMap.assing("Auto", "Volvo");
        assertEquals(1, hashMap.getAmountOfKeyValuePairs());
        hashMap.assing("Mopo", "Kawasaki");
        assertEquals(2, hashMap.getAmountOfKeyValuePairs());
    }

    @Test
    public void testShouldAssingAmountOfKeyValuePairsInHashMapEvenWhenElementsHaveSameHash() {
    hashMap.assing("Auto", "Volvo");
    hashMap.assing("Auto", "Volvo");
    assertEquals(2, hashMap.getAmountOfKeyValuePairs());
    }

    @Test
    public void testShouldHandleAddingThreeKeyValuePairsToHashMapWithThreeSlots() {
        hashMap.assing("Auto", "Volvo");
        hashMap.assing("Auto", "Volvo");
        hashMap.assing("Auto", "Volvo");
        assertEquals(3, hashMap.getAmountOfKeyValuePairs());
    }

    @Test
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

    @Test
    public void testShouldReturnValueFromHashMap1() {
        HashMap hashMap10 = new HashMap(10);
        hashMap10.assing("Auto", "Volvo");
        hashMap10.assing("Mopo", "Kawasaki");
        hashMap10.assing("Polkupyora", "Cannondale");
        assertEquals("Kawasaki", hashMap10.getValue("Mopo"));
    }

    @Test
    public void testShouldReturnValueFromHashMapThatsSizeHasBeenAlteredAfterAddingTheKeyValuePair() {
        hashMap.assing("Auto", "Volvo");
        hashMap.assing("Mopo", "Kawasaki");
        hashMap.assing("Polkupyora", "Cannondale");
        assertEquals("Cannondale", hashMap.getValue("Polkupyora"));
    }
}
