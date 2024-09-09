package HashMap;


public class HashMap<T> {

    private LinkedList<T>[] hashmap;
    private int keyValuePairs;
    private final double RATIO_OF_FULLNESS = 0.7;


    public HashMap(int size) {
        this.hashmap = new LinkedList[size];
        this.keyValuePairs = 0;
    }


    /**
     * Add key- value pairs to the Hashmap
     * @param key to be added
     * @param value to be added
     */
    public void assing(T key, T  value) {
        int index = hash(key);

        if (hashmap[index] != null) {
            hashmap[index].addToHead((T) key, (T) value);
        }


        checkAvailability();
    }

    public void checkAvailability() {
        if ((double) keyValuePairs / hashmap.length > RATIO_OF_FULLNESS) {
            growTheSizeOfHashMap(this);
        }
    }


    public void growTheSizeOfHashMap(HashMap<T> oldHashMap) {
        HashMap<T> newHashMap = new HashMap(oldHashMap.getSize() *2);

        for (int i = 0; i < oldHashMap.hashmap.length; i++) {
            if (oldHashMap.hashmap[i] != null) {
                newHashMap.assing(oldHashMap.hashmap[i].head.getKey(), oldHashMap.hashmap[i].head.getValue());
            }
            }
        this.hashmap = newHashMap.hashmap;
        }




    public int hash(String key) {

        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode += key.charAt(i);
        }
        return hashCode % hashmap.length;
    }




    public int getAmountOfKeyValuePairs() {
        return keyValuePairs;
    }


    public int getSize() {
        return hashmap.length;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataStructures.HashMap.HashMap.HashMap:");
        sb.append("\n");

        for (int i = 0; i < hashmap.length; i++) {
            sb.append(i + ": ");
            sb.append(hashmap[i].getHead().getKey());
            sb.append(hashmap[i].getHead().getValue());
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {


    }
}
