package interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Discretize an array
 * 
 * @author Dongliang Yu
 *
 */
public class Discretize {
    static class Node {
        int val;
        int index;
        public Node(int n, int i) { val = n; index = i; }
    }
    
    public static Node[] discretize(int[] num) {
        int len = num.length;
        Node[] arr = new Node[len];
        for (int i = 0; i < len; i++)
            arr[i] = new Node(num[i], i);
        Arrays.sort(arr, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < len; i++)
            arr[i].val = i;
        return arr;
    }
    
    public static void main(String[] args) {
        int[] num = {10, 3, 7, 1, 23, 14, 6, 9};
        Node[] ret = discretize(num);
        for (Node n : ret)
            System.out.print(n.val + "," + n.index + "   ");
    }
}
