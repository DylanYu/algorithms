package interview;

/**
 * Given an array, return the maximum count of surpasser.
 * 
 * For an array A, the element A[i]'s surpasser is A[j] which j > i and 
 * A[j] > A[i].
 * 
 * For example, in [10, 3, 7, 1, 23, 14, 6, 9] the surpasser of 10 is 23 and 
 * 14, so the count of surpasser of 10 is 2. 
 * 
 * @author Dongliang Yu
 *
 */
public class MaximumSurpasserCount {
    class Node {
        int val;
        int index;
        public Node(int n, int i) { val = n; index = i; }
    }
    
    public int maxCount(int[] num) {
        int len = num.length;
        int[] count = new int[len];
        Node[] nodes = new Node[len];
        for (int i = 0; i < num.length; i++)
            nodes[i] = new Node(num[i], i);
        mergeSort(nodes, count, 0, num.length-1);
        int maxCount = 0;
        for (int e : count)
            maxCount = Math.max(maxCount, e);
        return maxCount;
    }
    
    private void mergeSort(Node[] nodes, int[] count, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi-lo) / 2;
        mergeSort(nodes, count, lo, mid);
        mergeSort(nodes, count, mid+1, hi);
        merge(nodes, count, lo, hi);
    }
    
    private void merge(Node[] nodes, int[] count, int lo, int hi) {
        if (lo >= hi) return;
        Node[] tmp = new Node[nodes.length];
        for (int i = lo; i <= hi; i++)
            tmp[i] = nodes[i];
        int mid = lo + (hi-lo) / 2;
        int i = lo;
        int j = mid+1;
        int k = lo;
        while (i <= mid && j <= hi) {
            if (tmp[i].val < tmp[j].val) {
                count[tmp[i].index] += (hi - j + 1); // essence
                nodes[k++] = tmp[i++];
            } else {
                nodes[k++] = tmp[j++];
            }
        }
        while (i <= mid)
            nodes[k++] = tmp[i++];
        while (j <= hi)
            nodes[k++] = tmp[j++];
    }
    
    public static void main(String[] args) {
        int[] num = {10, 3, 7, 1, 23, 14, 6, 9};
        int count = new MaximumSurpasserCount().maxCount(num);
        System.out.println(count);
    }
}
