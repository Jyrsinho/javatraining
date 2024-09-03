package DataStructures;

public class Node<T> {

    public T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void setNextNode(Node<T> node) {
        this.next = node;
    }

    public Node<T> getNextNode() {
        return this.next;
    }

    public void setPrevNode(Node<T> node) {
        this.prev = node;
    }

    public Node<T> getPrevNode() {
        return this.prev;
    }

    public T getData() {
        return this.data;
    }

}
