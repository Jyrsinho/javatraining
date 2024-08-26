package LinkedList;

public class LinkedList {

    public Node head;

    public LinkedList() {
        head = null;
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

    /**
     * removes the head of the LinkedList returns the removed
     * Node's String payload
     */
    public String removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) return null;
        this.head = removedHead.getNextNode();
        return removedHead.getData();

    }

    /**
     * removes the tail of the LinkedList - returns the removed
     * Node's String payload
     */
    public String removeTail() {
        Node currentNode = this.head;

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(null);
        return currentNode.getData();

    }


    /**
     * Checks whether LinkedList contains given data String
     * @param data String to be looked for
     * @return true if data String is found in LinkedList, false if not
     */
    public boolean contains(String data) {
        boolean contains = false;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                contains = true;
                break;
            }
            currentNode = currentNode.getNextNode();
        }

        return contains;
    }

    /**
     * Removes a spesific node containing given Data String
     * @param data to be removed from Linked List
     */
    public void remove (String data) {

    }

    /**
     * returns the amount of elements in LinkedList
     * @return returns the amount of elements in LinkedList
     */
    public int getLength() {
        Node currentNode = this.head;
        if (currentNode == null) return 0;

        int length = 0;
        while (currentNode!= null) {
            length++;
            currentNode = currentNode.getNextNode();
        }

        return length;
    }


    /**
     * prints out the Linked List's data payloads
      * @return String containing Linked List's Nodes data.
     */
    public String printList() {
        StringBuilder sb = new StringBuilder();
        sb.append("<head>: ");

        if (this.head != null){
            Node currentNode = head;
        while (currentNode.getNextNode() != null) {
            sb.append(currentNode.getData());
            sb.append(", ");
            currentNode = currentNode.getNextNode();
        }
            sb.append(currentNode.getData());
        }
        sb.append("<tail>");

        return sb.toString();
    }


    public Node getHead() {
        return head;
    }

}
