package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Dongliang Yu
 * 
 */
public class LinkedQueue<T> implements Iterable<T> {

    private Node head, tail;
    private int N;

    private class Node {
        T item;
        Node next;
    }

    public LinkedQueue() {
        head = null;
        tail = null;
        N = 0;
    }

    public void enqueue(T item) {
        Node oldtail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty())
            head = tail;
        else
            oldtail.next = tail;
        N++;
    }

    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        T item = head.item;
        head = head.next;
        if (isEmpty())
            tail = null; // to avoid loitering
        N--;
        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return N;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        Node current = head;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<String>();
        queue.enqueue("1");
        queue.enqueue("2");
        System.out.println("size: " + queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        System.out.println("size: " + queue.size());
        for (String s : queue)
            System.out.println(s);
    }

}
