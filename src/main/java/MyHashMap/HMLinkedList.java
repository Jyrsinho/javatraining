package MyHashMap;

public class HMLinkedList {
    public MyHMNode head;

    public HMLinkedList() {
        this.head = null;
    }

    public void addToHead(String key, String value) {
        MyHMNode newHead = new MyHMNode(key, value);
        MyHMNode currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String key, String value) {
        MyHMNode tail = this.head;
        if (tail == null) {
            this.head = new MyHMNode(key, value);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new MyHMNode(key, value));
        }
    }

    public void removeHead() {
        MyHMNode removedHead = this.head;
        if (removedHead == null) {
            return;
        }
        this.head = removedHead.getNextNode();
    }
}

