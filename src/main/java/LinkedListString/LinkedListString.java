package LinkedListString;

import LinkedList.Node;

public class LinkedListString {

    private Node<Character> head;

    public LinkedListString() {
        head = null;
    }

    public void append(char c) {
        Node<Character> newNode = new Node<>(c);
        Node<Character> currentNode = this.head;

        if (currentNode == null) {
            this.head = newNode;
        } else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void concatenate(LinkedListString lst1, LinkedListString lst2) {

        Node<Character> currentNode = lst1.head;

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

    public char remove(int targetIndex) {
        char removedChar = 0;

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
        Node<Character> previousNode = this.head;
        Node<Character> currentNode= this.head.getNextNode();
        removedChar = currentNode.getData();

        while(currentNode != null && currentNodeIndex < targetIndex) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentNodeIndex++;
            removedChar = currentNode.getData();
        }
        if (currentNode != null) {
            previousNode.setNextNode(currentNode.getNextNode());
        }

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

        Node <Character> currentNode = this.head;
        Node <Character> previousNode = this.head;
        Node <Character> nextNode= this.head;

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
    public Character charAt(int targetIndex) {
        int currentNodeIndex = 0;
        Node<Character> currentNode = this.head;

        while (currentNode != null && currentNodeIndex < targetIndex) {
            currentNode = currentNode.getNextNode();
            currentNodeIndex++;
        }
        if (currentNode == null) {
            return null;
        }

        return currentNode.getData();
    }


    public Node<Character> getHead() {
        return head;
    }

    public void printString() {
        Node<Character> currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

    public String getString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<Character> currentNode = this.head;
        while (currentNode != null) {
            stringBuilder.append(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
        return stringBuilder.toString();

    }
    }


