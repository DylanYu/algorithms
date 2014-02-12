package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Iterable<Item>{
	
	private Node head, tail;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public LinkedQueue() {
		head = null;
		tail = null;
		N = 0;
	}
	
	public void enqueue(Item item) {
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
	
	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		Item item = head.item;
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
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		Node current = head;
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
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
