package MyHashMap;

public class MyLLHashMap<T> {

    private HMLinkedList[] LLhashmap;
    private final double LOAD_FACTOR = 0.7;
    private int size;

    public MyLLHashMap(int size) {
        this.LLhashmap = new HMLinkedList[size];
        this.size = 0;

        fillHashMapWithEmptyLinkedLists();

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

    /**
     * add key - value -pairs to the hashmap
     * @param key to be added
     * @param value to be added
     */
    public void assign(String key, String value) {
        int index = hash(key);

        LLhashmap[index].addToHead(key, value);

        size++;

    }

    public String getValue(String key) {
        String value = "No such key in hashmap";
        int index = hash(key);

        MyHMNode currentNode = LLhashmap[index].getHead();
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                value = currentNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        }

        return value;
    }

    public int getSize() {
        return size;
    }

    public HMLinkedList[] getHashmap () {
        return this.LLhashmap;
    }


    /**
     * utility method that takes all the indices of hashmap array and fills them with empty linkedlists.
     */
    public void fillHashMapWithEmptyLinkedLists() {
        for (int i = 0; i < LLhashmap.length; i++) {
            LLhashmap[i] = new HMLinkedList();
        }
    }


}
