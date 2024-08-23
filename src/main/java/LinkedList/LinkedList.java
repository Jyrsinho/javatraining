package LinkedList;

public class LinkedList {

    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
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
        //if list is empty the new tail is the new head
        if (head == null) {
            this.head = new Node(data);
            this.tail = this.head;
        } else {
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            Node newTail = new Node(data);
            currentNode.setNextNode(newTail);
            this.tail = newTail;
        }
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
