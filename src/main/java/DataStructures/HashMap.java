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
        int indexToBeAddedIn = hash(key);

        hashmap[indexToBeAddedIn][0] = key;
        hashmap[indexToBeAddedIn][1] = value;

    }


    public int hash(String key) {

        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % hashmap.length;

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