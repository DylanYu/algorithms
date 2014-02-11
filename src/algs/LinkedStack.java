package algs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Dongliang Yu
 *
 */
public class LinkedStack<Item> implements Iterable<Item> {
	
	private Node head;
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public LinkedStack() {
		head = null;
		N = 0;
	}
	
	public void push(Item item) {
		Node newhead = new Node();
		newhead.item = item;
		newhead.next = head;
		head = newhead;
		N++;
	}
	
	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack Underflow");
		Item item = head.item;
		head = head.next;
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
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("a");
		stack.push("b");
		System.out.println(stack.pop());
		stack.push("c");
		stack.push("d");
		stack.push("e");
		for (String s : stack)
			System.out.println(s);
		System.out.println("size: " + stack.size());
	}
	
}
