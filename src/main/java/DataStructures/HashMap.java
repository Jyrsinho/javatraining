package DataStructures;

public class HashMap {

    private String[][] hashmap;
    private int keyValuePairs;
    private final double RATIO_OF_FULNESS = 0.7;

    public HashMap(int size) {
        this.hashmap = new String[size][2];
        this.keyValuePairs = 0;
    }


    /**
     * Add key- value pairs to the Hashmap
     * @param key to be added
     * @param value to be added
     */
    public void assing(String key, String value) {
        int hashCode = hash(key);
        int index = findIndexForHash(hashCode);

        while (hashmap[index][0] != null) {
            index ++;
            if (index == hashmap.length) index = 0;
        }

        hashmap[index][0] = key;
        hashmap[index][1] = value;
        keyValuePairs++;

        checkAvailability();
    }

    public void checkAvailability() {
        if ((double) keyValuePairs / hashmap.length > RATIO_OF_FULNESS) {
            growTheSizeOfHashMap(this);
        }
    }


    public void growTheSizeOfHashMap(HashMap oldHashMap) {
        HashMap newHashMap = new HashMap(oldHashMap.getSize() *2);

        for (int i = 0; i < oldHashMap.hashmap.length; i++) {
            if (oldHashMap.hashmap[i][0] != null) {
                newHashMap.assing(oldHashMap.hashmap[i][0], oldHashMap.hashmap[i][1]);
            }
            }
        this.hashmap = newHashMap.hashmap;
        }


    public int findIndexForHash(int hash) {
        return hash % hashmap.length;
    }


    public int hash(String key) {

        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode += key.charAt(i);
        }
        return hashCode;
    }


    public String retrieve(String key) {

        int hashCode = hash(key);
        int index = findIndexForHash(hashCode);
        return hashmap[index][1];

    }

    public int getAmountOfKeyValuePairs() {
        return keyValuePairs;
    }


    public int getSize() {
        return hashmap.length;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashMap:");
        sb.append("\n");

        for (int i = 0; i < hashmap.length; i++) {
            sb.append(i + ": ");
            for (int j = 0; j < hashmap[i].length; j++) {
                sb.append(hashmap[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        HashMap testHashMap = new HashMap(5);
        testHashMap.assing("auto", "volvo");

        System.out.println(testHashMap.toString());

        testHashMap.assing("auto", "volvo");
        System.out.println(testHashMap.toString());

        System.out.println(testHashMap.hash("Jyri"));

    }
}