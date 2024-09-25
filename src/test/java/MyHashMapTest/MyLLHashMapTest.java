package MyHashMapTest;

import MyHashMap.MyLLHashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyLLHashMapTest {


    @Test
    public void testShouldAssignValuesToHashMap() {
        MyLLHashMap<String> hashMap = new MyLLHashMap<String>(10);
        hashMap.assign("testKey", "testValue");
        assertEquals(1, hashMap.getSize());
    }

}
