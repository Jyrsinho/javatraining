package HashMap;

public class Node<T, V> {


    private final T key;
    private final V value;
    private Node<T, V> next;
    private Node<T, V> prev;


    public Node(T key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public void setNextNode(Node<T, V> node) {
        this.next = node;
    }

    public Node<T, V> getNextNode() {
        return this.next;
    }

    public void setPrevNode(Node<T, V> node) {
        this.prev = node;
    }

    public Node<T, V> getPrevNode() {
        return this.prev;
    }

    public T getKey() {
        return this.key;
    }

    public V getValue() {return this.value; }

}

