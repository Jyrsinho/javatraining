package LinkedList;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private T data;


    public DoublyLinkedList() {
        head = null;
        tail = null;
    }


    public void addToHead(T data) {
        Node<T> previousHead = head;
        this.head = new Node<>(data);

        if (previousHead == null) {
            this.tail = this.head;
        } else {
            head.setNextNode(previousHead);
            previousHead.setPrevNode(head);
        }
    }

    public void addToTail(T data) {
        Node<T> previousTail = tail;
        this.tail = new Node<>(data);

        if (previousTail == null) {
            this.head = this.tail;
        }
        else {
            previousTail.setNextNode(tail);
            tail.setPrevNode(previousTail);
        }
    }

    public T removeHead() {
        if (head == null) {
            return null;
        }
        return null;
    }


    public Node<T> getHead() {
        return head;
    }


    public Node<T> getTail() {
        return tail;
    }


    /**
     * prints out the Linked List's data payloads
     * @return String containing Linked List's Nodes data.
     */
    public String printList() {
        StringBuilder sb = new StringBuilder();
        sb.append("<head>: ");

        if (this.head != null){
            Node<T> currentNode = head;
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

}
