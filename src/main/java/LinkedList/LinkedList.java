package LinkedList;

public class LinkedList {

    public Node head;

    public LinkedList() {
        head = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = head;
        this.head = newHead;
        if (currentHead != null) this.head.setNextNode(currentHead);


    }


    public Node getHead() {
        return head;
    }
}
