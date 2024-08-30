package LinkedList;

import java.sql.SQLOutput;

public class LinkedList<T> {

    public Node<T> head;

    public LinkedList() {
        head = null;
    }

    /**
     * adds new Node to the tail end of the LinkedList
     * @param data data payload of new Node to be added
     */
    public void addToHead(T data) {
        Node<T> newHead = new Node<>(data);
        Node<T> currentHead = head;
        this.head = newHead;
        if (currentHead != null) this.head.setNextNode(currentHead);


    }

    /**
     * adds new Node to the tail end of the LinkedList
     * @param data data payload of new Node to be added
     */
    public void addToTail(T data) {
        //if list is empty the new tail is the new head
        Node<T> tail = this.head;

        if (tail== null){
            this.head = new Node<T>(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node<T> (data));
        }
    }

    /**
     * removes the head of the LinkedList returns the removed
     * Node's String payload
     */
    public T removeHead() {
        Node<T> removedHead = this.head;
        if (removedHead == null) return null;
        this.head = removedHead.getNextNode();
        return removedHead.getData();

    }

    /**
     * removes the tail of the LinkedList - returns the removed
     * Node's String payload
     */
    public T removeTail() {
        Node<T> currentNode = this.head;

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
    public boolean contains(T data) {
        boolean contains = false;
        Node<T> currentNode = this.head;
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
     * @return data String that was removed from Linked List. Null if nothins is removed
     */
    public T remove (T data) {
        T removed= null;

        if (this.head == null) return null;

        if (this.head.getData().equals(data)) {
            return removeHead();
        }

        Node<T> previousNode = this.head;
        Node<T> currentNode = this.head.getNextNode();

        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                removed = currentNode.getData();
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
            sb.append(currentNode.getData());
            sb.append(", ");
            currentNode = currentNode.getNextNode();
        }
            sb.append(currentNode.getData());
        }
        sb.append("<tail>");

        return sb.toString();
    }


    public void swap(T data1, T data2) throws Exception {

        //find data1 and store the node containing data1 and previousNode
        Node<T> currentNode1 = this.head;
        Node<T> previousNode1 = null;
        Node<T> currentNode2 = this.head;
        Node<T> previousNode2 = null;

        while (currentNode1 != null) {
            if (currentNode1.getData() == data1) {
                break;
            }
            previousNode1 = currentNode1;
            currentNode1 = currentNode1.getNextNode();
        }

        //find data2 and store the node containing data2 and its previousNode
        while (currentNode2 != null) {
            if (currentNode2.getData() == data2) {
                break;
            }
            previousNode2 = currentNode2;
            currentNode2 = currentNode2.getNextNode();
        }

        if (currentNode1 == null || currentNode2 == null) {
            throw new Exception("The list does not contain given data");
        }

        //swap data1 and data2 next pointers

        Node<T> temp = currentNode1.getNextNode();
        currentNode1.setNextNode(currentNode2.getNextNode());
        currentNode2.setNextNode(temp);

        Node<T> tempPrevious = previousNode1.getNextNode();
        previousNode1.setNextNode(previousNode2.getNextNode());
        previousNode2.setNextNode(tempPrevious);




        //swap data1 and data2 next pointers
        //swap data1previous and dataprevious next pointers
    }

    public String getList() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        return sb.toString();
    }


    public Node<T> getHead() {
        return head;
    }

}
