package LinkedList;

public class Node<T> {

    public T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public void setNextNode(Node<T> node) {
        this.next = node;
    }

    public Node<T> getNextNode() {
        return this.next;
    }

    public T getData() {
        return this.data;
    }

}
