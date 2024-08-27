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
        Node<T> removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();

        if (this.head != null) {
            this.head.setPrevNode(null);
        }
        if (removedHead == this.tail) {
            removeTail();
        }

        return removedHead.getData();
    }


    public T removeTail() {
        Node<T> removedTail = this.tail;
        if (removedTail == null) {
            return null;
        }
        this.tail = removedTail.getPrevNode();

        if (this.tail != null) {
            this.tail.setNextNode(null);
        }
        if (removedTail == this.head) {
            removeHead();
        }

        return removedTail.getData();
    }

    public T removeByData(T data) {

        T removed = null;


        // if data is found in the head
        if (this.head.getData() == data) {
            removed = this.head.getData();
            removeHead();
        }

        Node<T>currentNode = this.head.getNextNode();

        //if data is found in the middle of the Linked List
        while (currentNode.getNextNode() != null) {
            if (currentNode.getData() == data) {
                removed = currentNode.getData();
                currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
                currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
            }
            currentNode = currentNode.getNextNode();
        }

        // if data is found in the tail
        if (this.tail != null && tail.getData() == data) {
            removed = this.tail.getData();
            removeTail();
        }

        return removed;
    }


    public Node<T> getHead() {
        return head;
    }


    public Node<T> getTail() {
        return tail;
    }

    public int getLength() {
        int length = 0;
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
