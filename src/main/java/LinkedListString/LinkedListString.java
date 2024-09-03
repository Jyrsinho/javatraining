package LinkedListString;

import DataStructures.Node;

public class LinkedListString<T> {

    private Node<T> head;

    public LinkedListString() {
        head = null;
    }

    public void append(T c) {
        Node<T> newNode = new Node<>(c);
        Node<T> currentNode = this.head;

        if (currentNode == null) {
            this.head = newNode;
        } else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void concatenate(LinkedListString<T> lst1, LinkedListString<T> lst2) {

        Node<T> currentNode = lst1.head;

        while (currentNode != null) {
            this.append(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }

        currentNode = lst2.head;

        while (currentNode != null) {
            this.append(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

    public T remove(int targetIndex) {
        T removedChar;

        if (targetIndex == 0) {
            removedChar = this.head.getData();
            if (this.head.getNextNode() != null) {
                this.head = this.head.getNextNode();
            }else {
                this.head = null;
            }
            return removedChar;
        }

        int currentNodeIndex = 1;
        Node<T> previousNode = this.head;
        Node<T> currentNode= this.head.getNextNode();
        removedChar = currentNode.getData();

        while(currentNodeIndex < targetIndex) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentNodeIndex++;
            removedChar = currentNode.getData();
        }
        previousNode.setNextNode(currentNode.getNextNode());

        return removedChar;
    }

    public void removeCharsFrom(int startIndex, int amountToRemove) {
        for (int i = startIndex+amountToRemove-1; i >= startIndex; i--) {
            this.remove(i);
        }
    }


    /**
     * Exercise to see can you be more efficient removing whole chunks of
     */
    public void removeChars(int startIndex, int amountToRemove) {

        Node <T> currentNode = this.head;
        Node <T> previousNode = this.head;
        Node <T> nextNode= this.head;

        // if removing starts from the head. Set the head to nextNode
        if (startIndex == 0) {
            int stepsTaken = 0;
            while (nextNode != null && stepsTaken < amountToRemove) {
                nextNode = nextNode.getNextNode();
                this.head = nextNode;
                stepsTaken++;
            }
        // if removing starts from the middle of the list. Find the current and previous nodes.
        }else {
            int currentNodeIndex = 0;
            while (currentNode != null && currentNodeIndex < startIndex) {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
                currentNodeIndex++;
            }
            //find the next node
            int stepsTaken = 0;
            nextNode = currentNode;
            while (nextNode != null && stepsTaken < amountToRemove) {
                nextNode = nextNode.getNextNode();
                stepsTaken++;
            }
            previousNode.setNextNode(nextNode);

        } // end of else statement
    }


    /**
     * returns the character at Nth Node. Starting from zero
     * @param targetIndex location of Node in the Linked List. Starting from zero
     */
    public T charAt(int targetIndex) {
        int currentNodeIndex = 0;
        Node<T> currentNode = this.head;

        while (currentNode != null && currentNodeIndex < targetIndex) {
            currentNode = currentNode.getNextNode();
            currentNodeIndex++;
        }
        if (currentNode == null) {
            return null;
        }

        return currentNode.getData();
    }


    public LinkedListString<T> integerToLinkedListString (int x) {
        LinkedListString<T> lst = new LinkedListString<T>();

        return lst;

    }


    public Node<T> getHead() {
        return head;
    }

    public void printString() {
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            stringBuilder.append(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        return stringBuilder.toString();

    }
    }


