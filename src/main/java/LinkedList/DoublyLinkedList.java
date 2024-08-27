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
        Node<T> currentHead = this.head;
        this.head = new Node<>(data);
        head.setNextNode(currentHead);

    }

    public Node<T> getHead() {
        return head;
    }
}
