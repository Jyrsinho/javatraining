package DataStructures;

import java.util.NoSuchElementException;

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
        if (!hasSpace()) {
            throw new StackOverflowError();
        }
        stack.addToHead(value);
        size += 1;

    }

    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        this.size -= 1;
        return stack.removeHead();
    }


    public T peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack empty");
        }
        return stack.getHead().getData();
    }


    public boolean isThere(T value) {
        boolean found = false;
        Stack<T> helperStack = new Stack<>();

        while (!this.isEmpty() ){
            T candidate = pop();
            helperStack.push(candidate);
            if (candidate.equals(value)) {
                found = true;
                break;
            }
        }

        while (!helperStack.isEmpty()) {
            this.push(helperStack.pop());
        }

        return found;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean hasSpace() {
        return size < maxSize;
    }
}
