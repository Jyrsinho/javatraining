package LinkedList;

public class LinkedList {

    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        ;
    }

    /**
     * adds new Node to the tail end of the LinkedList
     * @param data data payload of new Node to be added
     */
    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = head;
        this.head = newHead;
        if (currentHead != null) this.head.setNextNode(currentHead);


    }

    /**
     * adds new Node to the tail end of the LinkedList
     * @param data data payload of new Node to be added
     */
    public void addToTail(String data) {
        Node tempTail = head;

        if (tempTail == null) {
            this.head = new Node(data);
            this.tail = this.head;
        }



    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
