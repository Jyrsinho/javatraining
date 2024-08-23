package LinkedList;

public class LinkedList {

    public Node head;

    public LinkedList() {
        head = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        newHead.setNextNode(head);

    }


    public Node getHead() {
        return head;
    }
}
