package DataStructures;

public class HashMap {

    public String[] hashmap;

    public HashMap(int size) {
        this.hashmap = new String[size];
    }


    public int hash(String key) {

        int sum = 0;

        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % hashmap.length;

    }

    public int getSize() {
        return hashmap.length;
    }

    public static void main(String[] args) {

    }
}