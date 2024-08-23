package LinkedList;

public class LinkedList {

    public Node head;

    public LinkedList() {
        head = null;
    }

    public void addNodeToHead(Node newNode) {
        Node oldHead = this.head;
        this.head = newNode;
        this.head.setNextNode(oldHead);

    }
}
