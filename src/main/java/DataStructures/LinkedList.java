package DataStructures;


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
            if (currentNode.getNextNode() == null) return null;
            currentNode = currentNode.getNextNode();
        }

        while (currentNode.getNextNode() != null) {
            preceedingNode = preceedingNode.getNextNode();
            currentNode = currentNode.getNextNode();
        }

        return preceedingNode.getData();
    }

    /**
     * Returns the middle Node of the Linked List. If list length is even it returns the
     * right-weighted middle
     * @return the middle Node of the Linked List. If list length is even it returns the
     * right-weighted middle
     */
    public T getMiddle() {
        Node<T> tailSeeker = this.head;
        Node<T> middleSeeker = this.head;
        int count = 0;

        while (tailSeeker!= null) {
            if (count % 2 == 1) {
                middleSeeker = middleSeeker.getNextNode();
            }
            tailSeeker = tailSeeker.getNextNode();
            count++;
        }

        if (count < 3) return null;

        if (middleSeeker  == head) {
            return null;
        } else return middleSeeker.getData();

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

        Node<Integer> currentNode1 = list1.head;
        int list1Sum = 0;
        Node<Integer> currentNode2 = list2.head;
        int list2Sum = 0;

        while (currentNode1 != null) {
            int intToAdd = currentNode1.getData();
            list1Sum = list1Sum *10 + intToAdd;
            currentNode1 = currentNode1.getNextNode();
        }

        while (currentNode2 != null) {
            int intToAdd = currentNode2.getData();
            list2Sum = list2Sum *10 + intToAdd;
            currentNode2 = currentNode2.getNextNode();
        }

        int sum = list1Sum + list2Sum;
        LinkedList<Integer> listOfSum = intToList(sum);
        return listOfSum;

    }

    public void firstToLast() {
        Node <T> oldHead = this.head;

        if (this.head.getNextNode() != null) {
            this.head = this.head.getNextNode();
        }
        Node<T> currentNode = this.head;

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(oldHead);
        oldHead.setNextNode(null);
    }


    public void lastToFirst() {

        if (this.head.getNextNode() == null) return;

        // store the Node next to the head
        Node <T> nextToTheHead = this.head.getNextNode();

        // find the tail and one before it
        Node <T> newTail = this.head;
        Node<T> oldTail = this.head.getNextNode();
        while (oldTail.getNextNode() != null) {
            newTail = newTail.getNextNode();
            oldTail = oldTail.getNextNode();
        }

        // set the previous next to last Node as last node and set the old Tail as new Head.
        newTail.setNextNode(null);
        this.head = oldTail;
        oldTail.setNextNode(nextToTheHead);

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
