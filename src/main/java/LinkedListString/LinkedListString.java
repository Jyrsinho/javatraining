package LinkedListString;

import LinkedList.Node;

public class LinkedListString {

    private Node<Character> head;

    public LinkedListString() {
        head = null;
    }

    public void append(char c) {
        Node<Character> newNode = new Node<>(c);
        newNode.setNextNode(this.head);
        this.head = newNode;

    }

    public Node<Character> getHead() {
        return head;
    }

    public void printString() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

    }

