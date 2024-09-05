package DataStructures;

public class Stack<T> {

    private LinkedList<T> stack;
    private Node<T> top;
    private int size;
    int maxSize;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    public Stack() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new LinkedList<>();
        this.size = 0;
    }

    public void push(T value) {
        if (size == maxSize) {
            throw new StackOverflowError();
        }
        stack.addToHead(value);
        size += 1;
    }

    public T pop() {
        if (this.top == null) {
            throw new Error("Stack underflow");
        }
        return stack.removeHead();
    }


    public T peek() {
        if (this.top == null) {
            throw new Error("Stack empty");
        }
        return stack.getHead().getData();
    }

    public int getSize() {
        return size;
    }
}
