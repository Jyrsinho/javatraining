package MyHashMap;

public class MyHashMap {

    private String[] hashmap;

    public MyHashMap(int size) {
        this.hashmap = new String[size];
    }

    public int hash(String key) {
        int hashSum = 0;
        for (int i = 0; i < key.length() ; i++) {
            hashSum = hashSum + key.charAt(i);
        }
        return hashSum % hashmap.length;
    }

    public int getHashMapLenght() {
        return this.hashmap.length;
    }

    public String[] getHashMap() {
        return this.hashmap;
    }

}