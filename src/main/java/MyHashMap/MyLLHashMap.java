package MyHashMap;

public class MyLLHashMap<T> {

    private HMLinkedList [] LLhashmap;
    private final double LOAD_FACTOR = 0.7;
    private int size;

    public MyLLHashMap(int size) {
        this.LLhashmap = new HMLinkedList[size];
        this.size = 0;
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
        return hashSum % LLhashmap.length;
    }

    public void assign(String key, String value) {
        int index = hash(key);



    }


}
