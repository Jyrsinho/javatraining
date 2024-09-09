package HashMap;



public class LinkedList<T> {

    public Node<T> head;

    public LinkedList() {
        head = null;
    }


    /**
     * adds new Node to the tail end of the LinkedList
     * @param key value to be added to new head node
     * @param value to be added to new head node
     */
    public void addToHead(T key, T value) {
        Node<T> newHead = new Node<>(key, value);
        Node<T> currentHead = head;
        this.head = newHead;
        if (currentHead != null) this.head.setNextNode(currentHead);


    }


    /**
     * removes the head of the LinkedList returns the removed
     * Node's String payload
     */
    public T removeHead() {
        Node<T> removedHead = this.head;
        if (removedHead == null) return null;
        this.head = removedHead.getNextNode();
        return removedHead.getValue();

    }



    /**
     * Checks whether LinkedList contains given data String
     * @param key value to be looked for
     * @return true if data String is found in LinkedList, false if not
     */
    public boolean contains(T key) {
        boolean contains = false;
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                contains = true;
                break;
            }
            currentNode = currentNode.getNextNode();
        }

        return contains;
    }

    /**
     * Removes a spesific node containing given Data key
     * @param key of key-value pair to be removed from Linked List
     * @return key  that was removed from Linked List. Null if nothins is removed
     */
    public T remove (T key) {
        T removed= null;

        if (this.head == null) return null;

        if (this.head.getKey().equals(key)) {
            return removeHead();
        }

        Node<T> previousNode = this.head;
        Node<T> currentNode = this.head.getNextNode();

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                removed = currentNode.getKey();
                previousNode.setNextNode(currentNode.getNextNode());
            }
            currentNode = currentNode.getNextNode();
        }

        return removed;
    }

    /**
     * returns the amount of elements in LinkedList
     * @return returns the amount of elements in LinkedList
     */
    public int getLength() {
        Node<T> currentNode = this.head;
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
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                sb.append(currentNode.getKey());
                sb.append(", ");
                currentNode = currentNode.getNextNode();
            }
            sb.append(currentNode.getKey());
        }
        sb.append("<tail>");

        return sb.toString();
    }

    /**
     * Returns the list as a String
     * @return the list as a String
     */
    public String getList() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            sb.append(currentNode.getKey());
            sb.append(", ");
            sb.append(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
        return sb.toString();
    }


    public Node<T> getHead() {
        return head;
    }


    public Node<T> getTail() {
        Node<T> currentNode = this.head;
        if (currentNode == null) {
            return null;
        }

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

}
