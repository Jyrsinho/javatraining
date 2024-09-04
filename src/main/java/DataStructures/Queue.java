package DataStructures;

public class Queue<T> {

    LinkedList<T> queue;
    int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;


    public Queue() {
        queue = new LinkedList<>();
        this.size = 0;
        this.maxSize = DEFAULT_MAX_SIZE;

    }

    public Queue(int maxSize) {
        queue = new LinkedList<>();
        this.size = 0;
        this.maxSize = maxSize;
    }


    public void enqueue(T value) throws Exception {
        if (this.size == maxSize) {
            throw new Exception("Queue is full");
        }

        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            queue.head = newNode;
        } else {
           queue.addToTail(value);
        }
        size++;

    }


    public T dequeue() {
        if (size == 0) {
            return null;
        }

        Node <T>previousHead = queue.head;
        queue.head = queue.head.getNextNode();
        size --;

        return previousHead.getData();

    }


    public T peek() {
        return queue.head.getData();
    }


    public int getSize() {
        return size;
    }


}
