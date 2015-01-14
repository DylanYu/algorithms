package interview;

import java.util.LinkedList;

/**
 * Given an input stream and the window size k, get the maximum element in current window.
 * 
 * @author Dongliang Yu
 *
 */
public class MaximumElementInSlidingWindow {
    private int[] num;
    private int index;
    private int k;
    private LinkedList<Pair> queue;
    
    class Pair {
        int element;
        int time;
        public Pair(int e, int t) { this.element = e; this.time = t; }
    }
    
    public MaximumElementInSlidingWindow(int[] num, int k) {
        this.num = num;
        index = 0; // next index
        this.k = k;
        queue = new LinkedList<Pair>();
    }
    
    public void next() {
        if (index == num.length) return;
        if (!queue.isEmpty() && queue.getFirst().time <= index-k) // move window
            queue.removeFirst();
        while (!queue.isEmpty() && queue.getLast().element <= num[index])
            queue.removeLast();
        queue.add(new Pair(num[index], index));
        index++;
    }
    
    public int getMax() {
        if (queue.isEmpty())
            return Integer.MIN_VALUE;
        return queue.getFirst().element;
    }
    
    public static void main(String[] args) {
        int[] num = {4, 8, 12, 0, 32, 1, 6, 11, 12, 13, 9, 8, 7, 6};
        MaximumElementInSlidingWindow instance = new MaximumElementInSlidingWindow(num, 3);
        for (int i = 0; i < num.length; i++) {
            instance.next();
            System.out.print("now: " + num[i] + ", max:");
            System.out.println(instance.getMax());
        }
    }
}
