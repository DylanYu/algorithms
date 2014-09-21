package interview;

/**
 * An N length array fills with integer range from 1 to N, some are missing whille some are 
 * duplicate, find every integer's frequency. O(N) time, O(1) space.
 * 
 * @author Dongliang Yu
 *
 */
public class CountNumber {
    public static void count(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0)
                continue;
            while (A[i] > 0) {
                int idx = A[i] - 1;
                if (A[idx] < 0) {
                    A[i] = 0;
                    A[idx]--;
                } else {
                    A[i] = A[idx];
                    A[idx] = -1;
                }
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = { 6, 9, 10, 4, 1, 3, 6, 6, 9, 6 };
        count(num);
        for (int i = 0; i <num.length; i++) {
            System.out.println(i+1 + "," + -num[i]);
        }
    }
}
