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
        Node tail = this.head;

        if (tail== null){
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node (data));
        }
    }


    public Node getHead() {
        return head;
    }

}
