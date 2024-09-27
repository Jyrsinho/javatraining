package MyHashMap;

public class MyHMNode {

    private String key;
    private String value;
    private MyHMNode next;

    public MyHMNode(String key, String value) {
        this.key  = key;
        this.value = value;
        this.next = null;
    }

    public void setNextNode(MyHMNode node) {
        this.next = node;
    }

    public MyHMNode getNextNode() {
        return this.next;
    }

    public void setKeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
