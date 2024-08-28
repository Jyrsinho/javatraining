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


    /**
     * returns the character at Nth Node. Starting from zero
     * @param index location of Node in the Linked List. Starting from zero
     */
    public Character charAt(int index) {
        return 'c';
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


