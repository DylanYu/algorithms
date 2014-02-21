package interview;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Shuffling a linked list.
 * <p>
 * Given a singly-linked list containing N items, rearrange the items uniformly
 * at random. Your algorithm should consume a logarithmic (or constant) amount 
 * of extra memory and run in time proportional to NlogN in the worst case.
 * <p>
 * Current solution is NOT uniformly distributed random.
 * 
 * @author Dongliang Yu
 *
 */
public class ShuffleLinkedList {

    private static class Node {
        String item;
        Node next;
    }
    
    public static Node shuffle(Node head) {
        int N = 0;
        for (Node p = head; p != null; p = p.next)
            N++;
        Node fakeHead = new Node();
        fakeHead.next = head;
        shuffle(fakeHead, N);
        return fakeHead.next;
    }
    
    public static void shuffle(Node prev, int N) {
        if (prev == null || N <= 1)
            return;
        Node prevR = prev;
        for (int i = 0; i < N / 2; i++)
            prevR = prevR.next;
        shuffle(prev, N / 2);
        shuffle(prevR, N - N / 2); 
        mergeRandomly(prev, prevR);
    }
    
    private static void mergeRandomly(Node prevL, Node prevR) {
        if (prevL == null || prevR == null)
            return;
        Node l = prevL.next;
        Node r = prevR.next;
        while (l != r && r != null) {
            if (Math.random() < 0.5) {
                prevL = prevL.next;
                l = l.next;
            } else {
                prevR.next = r.next;
                
                r.next = prevL.next;
                prevL.next = r;
                r = prevR.next;
                
                prevL = prevL.next;
            }
        }
    }
    
    public static Node createLinkedStructure(int N) {
        if (N < 1)
            throw new UnsupportedOperationException("Length is too short.");
        int i = 0;
        Node head = new Node();
        head.item = i++ + "";
        Node tail = head;
        while (i < N) {
            Node oldtail = tail;
            tail = new Node();
            tail.item = i++ + "";
            oldtail.next = tail;
        }
        tail.next = null;
        return head;
    }
    
    public static void traverse(Node head) {
        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.item);
            if (p.next != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }
    
    public static void checkRandom() {
        int N = 30;
        int[] stat = new int[N];
        for (int i = 0; i < N; i++)
            stat[i] = 0;
        for (int count = 0; count < 10000; count++) {
            Node head = ShuffleLinkedList.createLinkedStructure(N);
            head = ShuffleLinkedList.shuffle(head);
            for (int i = 0; i < N; i++) {
                if (Integer.parseInt(head.item) == i)
                    stat[i]++;
                head = head.next;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += stat[i];
        for (int i = 0; i < N; i++)
            System.out.printf("%.3f, ", stat[i] / (double) sum);
    }
    
    public static void checkRandomControlGroup() {
        int N = 30;
        int[] stat = new int[N];
        for (int i = 0; i < N; i++)
            stat[i] = 0;
        for (int count = 0; count < 10000; count++) {
            ArrayList<Integer> aList = new ArrayList<Integer>();
            for (int i = 0; i < N; i++)
                aList.add(i);
            Collections.shuffle(aList);
            for (int i = 0; i < N; i++) {
                if (aList.get(i) == i)
                    stat[i]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += stat[i];
        for (int i = 0; i < N; i++)
            System.out.printf("%.3f, ", stat[i] / (double) sum);
    }
    
    public static void main(String[] args) {
        Node head = ShuffleLinkedList.createLinkedStructure(10);
        ShuffleLinkedList.traverse(head);
        head = ShuffleLinkedList.shuffle(head);
        ShuffleLinkedList.traverse(head);
        
//        checkRandom();
//        System.out.println();
//        checkRandomControlGroup();
    }
    
}
