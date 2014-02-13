package interview;

import java.util.Random;

/**
 * Clone a linked structure with two pointers per node.
 * <p>
 * Suppose that you are given a reference to the first node of a linked
 * structure where each node has two pointers: one pointer to the next node in
 * the sequence (as in a standard singly-linked list) and one pointer to an
 * arbitrary node.
 * 
 * @author Dongliang Yu
 * 
 */
public class CloneLinkedStructure {

    private static class Node {
        private String item;
        private Node next;
        private Node random;
    }

    public static Node cloneLinkedStructure(Node head) {
        // make holes after each original node
        for (Node p = head; p != null;) {
            Node pnext = p.next;
            Node hole = new Node();
            hole.item = ".";
            p.next = hole;
            hole.next = pnext;
            p = pnext;
        }

        Node fakeHead = new Node(); // fake new head
        Node q = fakeHead;
        Node p = head;
        while (p != null) {
            // build the new linked structure
            Node oldq = q;
            q = new Node();
            q.item = p.item;
            oldq.next = q;
            q.random = p.random.next; // link to a hole

            Node hole = p.next;
            hole.random = q; // use link RANDOM as a backward link to new node

            p = hole.next;
        }
        q.next = null;

        Node newHead = fakeHead.next; // throw fake head
        // build random links for the new linked structure
        for (q = newHead; q != null; q = q.next)
            q.random = q.random.random;

        // delete holes to restore original linked structure
        for (p = head; p != null; p = p.next)
            p.next = p.next.next;

        return newHead;
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
        i = 0;
        Node p = head;
        Random rand = new Random();
        while (i < N) {
            Node q = head;
            int r = rand.nextInt(N);
            for (int j = 0; j < r; j++)
                q = q.next;
            p.random = q;
            p = p.next;
            i++;
        }
        return head;
    }

    public static void traverse(Node head) {
        for (Node p = head; p != null; p = p.next) {
            System.out.printf("%s(%s)", p.item,
                    (p.random != null) ? p.random.item : "null");
            if (p.next != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = createLinkedStructure(10);
        traverse(head);

        Node newHead = cloneLinkedStructure(head);
        traverse(newHead);

        traverse(head);
    }

}
