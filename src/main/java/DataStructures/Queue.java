package DataStructures;

import java.util.NoSuchElementException;

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
        if (!hasSpace()) {
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
        if (isEmpty()) {
            return null;
        }
        size --;
        return queue.removeHead();

    }


    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue.head.getData();
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean hasSpace() {
        return (size < maxSize);
    }


}
