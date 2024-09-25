package MyHashMap;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class MyHashMap {

    private String[] hashmap;

    public MyHashMap(int size) {
        this.hashmap = new String[size];
    }

    /**
     * returns the index for a key
     * @param key to be hashed
     * @return the hashed index for key's value to be added in
     */
    public int hash(String key) {
        int hashSum = 0;
        for (int i = 0; i < key.length() ; i++) {
            hashSum = hashSum + key.charAt(i);
        }
        return hashSum % hashmap.length;
    }

    /**
     * Assigns value to a hashmap based on the hashing value of a given key
     * @param key to be added
     * @param value to be added
     */
    public void assign(String key, String value) {
        int index = hash(key);
        while (hashmap[index] != null) {
            index = (index + 1) % hashmap.length;
        }
            hashmap[index] = value;

    }

    public String getValue(String key) {
        int index = hash(key);
        if (hashmap[index] == null) {
            throw new NoSuchElementException("No such key in hashmap");
        }
            return hashmap[index];
    }

    public String remove(String key) {
        int index = hash(key);

        if (hashmap[index] == null) {
            throw new NoSuchElementException("No such key in hashmap");
        }

        String deleted = hashmap[index];
        hashmap[index] = null;

        return deleted;

    }

    public int getHashMapLenght() {
        return this.hashmap.length;
    }

    public String[] getHashMap() {
        return this.hashmap;
    }

    HashMap<String, Integer> myHashMap = new HashMap<>();

}