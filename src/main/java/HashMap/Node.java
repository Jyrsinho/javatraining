package HashMap;

public class Node<T> {


    private final T key;
    private final T value;
    private Node<T> next;
    private Node<T> prev;


    public Node(T key, T value) {
        this.key = key;
        this.value = value;
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

    public T getKey() {
        return this.key;
    }

    public T getValue() {return this.value; }

}

