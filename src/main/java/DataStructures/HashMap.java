package DataStructures;

public class HashMap {

    public String[][] hashmap;

    public HashMap(int size) {
        this.hashmap = new String[size][2];
    }


    /**
     * Add key- value pairs to the Hashmap
     * @param key to be added
     * @param value to be added
     */
    public void add(String key, String value) {
        int hash = hash(key);
        int index = findIndexForHash(hash);

        while (hashmap[index][0] != null) {
            index ++;
            if (index == hashmap.length) index = 0;
        }

        hashmap[index][0] = key;
        hashmap[index][1] = value;
    }



    public int findIndexForHash(int hash) {
        return hash % hashmap.length;
    }


    public int hash(String key) {

        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum;
    }

    public int getAmountOfKeyValuePairs() {
        int amountOfKeyValuePairs = 0;
        for (String[] strings : hashmap) {
            if (strings[0] != null) {
                amountOfKeyValuePairs++;
            }
        }
        return amountOfKeyValuePairs;
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
        testHashMap.add("auto", "volvo");

        System.out.println(testHashMap.toString());

        testHashMap.add("auto", "volvo");
        System.out.println(testHashMap.toString());


    }
}