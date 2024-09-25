package MyHashMap;

public class MyHMNode {

    public String key;
    public String value;
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
}
