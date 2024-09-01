package LinkedList;


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
            this.head = new Node<>(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node<>(data));
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

        //swap previous1 and previous2 next pointers
        if (currentNode1 == head) {
            head = currentNode2;
        } else {
            previousNode1.setNextNode(currentNode2);
        }

        if (currentNode2 == head) {
            head = currentNode1;
        } else {
            previousNode2.setNextNode(currentNode1);
        }


        //swap data1 and data2 next pointers
        Node<T> temp = currentNode1.getNextNode();
        currentNode1.setNextNode(currentNode2.getNextNode());
        currentNode2.setNextNode(temp);


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

    /**
     * Returns the list as a String
     * @return the list as a String
     */
    public String getList() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            sb.append(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        return sb.toString();
    }

    /**
     * Get the Nth last element from the list
     * @param steps the amount of steps from the tail of the list
     * @return the element that is n steps from the tail of the list
     */
    public T getNthLastElement (int steps) {
        Node<T> preceedingNode = this.head;
        Node<T> currentNode = this.head;

        for (int i = 0; i < steps; i++) {
            //Tässä pitää tsekata onko steps OUT OF BOUNDS
            currentNode = currentNode.getNextNode();
        }

        while (currentNode.getNextNode() != null) {
            preceedingNode = preceedingNode.getNextNode();
            currentNode = currentNode.getNextNode();
        }

        return preceedingNode.getData();
    }


    public LinkedList<Integer> intToList (int x) {
        LinkedList<Integer> digitList = new LinkedList<Integer>();

        if (x == 0) {
            digitList.addToHead(0);
            return digitList;
        }

        int digit;

        while (x > 0) {
            digit = x % 10;
            x = x / 10;
            digitList.addToHead(digit);
        }

        return digitList;
    }


    public LinkedList<Integer> sumOfLists (LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> sumList = new LinkedList<Integer>();

        Node<Integer> current1 = list1.getHead();
        Node<Integer> current2 = list2.getHead();
        int int1;
        int int2;
        int digit;

        while (current1 != null && current2 != null) {
            int1 = current1.getData();
            int2 = current2.getData();
            digit = int1 + int2;
            sumList.addToTail(digit);
            current1 = current1.getNextNode();
            current2 = current2.getNextNode();
        }

        return sumList;
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
