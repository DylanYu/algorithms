package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Dongliang Yu
 * 
 */
public class ResizingStack<T> implements Iterable<T> {

    private T[] s;
    private int N;
    private int capacity;

    public ResizingStack() {
        this(1);
    }

    public ResizingStack(int capacity) {
        N = 0;
        this.capacity = capacity;
        s = (T[]) new Object[capacity]; // Java doesn't allow generic array
                                        // creation
    }

    public void push(T item) {
        if (N == capacity)
            resize(2 * capacity);
        s[N++] = item;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack Underflow");
        T item = s[--N];
        s[N] = null; // to avoid loitering
        if (N < capacity / 4)
            resize(capacity / 2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int currentPos = N;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return currentPos > 0;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return s[--currentPos];
        }
    }

    private void resize(int newCapacity) {
        T[] copy = (T[]) new Object[newCapacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        capacity = newCapacity;
        s = copy;
    }

    public static void main(String[] args) {
        ResizingStack<String> stack = new ResizingStack<String>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        System.out.println("size: " + stack.size());
        for (String s : stack)
            System.out.println(s);
        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("size: " + stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("size: " + stack.size());
    }

}
