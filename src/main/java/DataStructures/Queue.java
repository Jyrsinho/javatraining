package DataStructures;

public class Queue<T> {

    LinkedList<T> queue;
    int size;

    public Queue() {
        queue = new LinkedList<>();
        size = 0;
    }


    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            queue.head = newNode;
        } else {
            Node<T> current = queue.head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
        size++;
    }


    public void dequeue(T value) {

    }


    public T peek() {
        return queue.head.getData();
    }


    public int getSize() {
        return size;
    }


}
