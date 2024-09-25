package MyHashMap;

import java.util.NoSuchElementException;

public class MyHashMap {

    private String[][] hashmap;
    private final double LOAD_TRESHOLD = 0.7;
    private int amountOfElements;

    public MyHashMap(int size) {
        this.hashmap = new String[size][2];
        this.amountOfElements = 0;
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
        while (hashmap[index][0] != null) {
            index = (index + 1) % hashmap.length;
        }
        hashmap[index][0] = key;
        hashmap[index][1] = value;
        amountOfElements++;
        if ((double) amountOfElements / hashmap.length>= LOAD_TRESHOLD) {
            growHashMap();
        }
    }

    public void growHashMap() {
        int currentHashMapSize = hashmap.length;
        MyHashMap newHashMap = new MyHashMap(currentHashMapSize * 2);

        for (int i = 0; i < hashmap.length; i++) {
            if (hashmap[i][0] != null) {
                newHashMap.assign(hashmap[i][0], hashmap[i][1]);
            }
        }
        this.hashmap = newHashMap.hashmap;
    }



    public String getValue(String key) {
        int index = hash(key);
        if (hashmap[index][0] == null) {
            throw new NoSuchElementException("No such key in hashmap");
        }
            return hashmap[index][1];
    }


    public String remove(String key) {
        int index = hash(key);

        if (hashmap[index][0] == null) {
            throw new NoSuchElementException("No such key in hashmap");
        }

        String deleted = hashmap[index][1];
        hashmap[index][0] = null;
        hashmap[index][1] = null;

        return deleted;

    }

    public int getHashMapLenght() {
        return this.hashmap.length;
    }

    public String[][] getHashMap() {
        return this.hashmap;
    }


}